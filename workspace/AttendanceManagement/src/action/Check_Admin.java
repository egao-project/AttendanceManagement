package action;

import util.DBConnect;
import util.Item;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import java.sql.PreparedStatement;

import action.form.AM_form;

public class Check_Admin extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// アクションフォーム利用の為の定義
		AM_form queryForm = (AM_form) form;
		Item item = new Item();

		// 社員番号の頭文字にMがつくレコード取得のSQL文
		String sql = "SELECT * FROM employee WHERE emp_no LIKE 'M%'";

		// 認証処理用の変数
		int count = 0;
		String check = null;

		try (Connection con = DBConnect.con();) {

			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			// 認証処理
			while (rs.next()) {
				if (count < rs.getRow()) {
					// 一致しなければ認証失敗
					if (queryForm.getEmpNum().startsWith("M")) {
						if (queryForm.getEmpNum().equals(rs.getString("emp_no"))) {
							if (queryForm.getEmpPass().equals(rs.getString("emp_pass"))) {
								check = item.getSuccess();
								queryForm.setErrorMessage("");
								break;
							} else {
								check = item.getFault();
								queryForm.setErrorMessage("パスワードが間違っています");
								break;
							}
						} else {
							check = item.getFault();
							queryForm.setErrorMessage("管理者権限のない番号です");
						}

					} else {
						check = item.getFault();
						queryForm.setErrorMessage("管理者権限のない番号です");
					}
				}
				count++;
			}

		} catch (NullPointerException e) {
			e.printStackTrace();
			check = item.getFault();
			queryForm.setErrorMessage("エラー番号101が発生しました。管理者にお問い合わせ下さい");
		} catch (SQLException e) {
			e.printStackTrace();
			check = item.getFault();
			queryForm.setErrorMessage("エラー番号102が発生しました。管理者にお問い合わせ下さい");
		} catch (Exception e) {
			e.printStackTrace();
			check = item.getFault();
			queryForm.setErrorMessage("エラー番号103が発生しました。管理者にお問い合わせ下さい");
		}

		// マッピングに値を返す
		if (check == null) {
			queryForm.setErrorMessage("エラー番号104が発生しました。管理者にお問い合わせ下さい");
			return (mapping.findForward("Top"));
		} else if (check.equals(item.getSuccess())) {
			return (mapping.findForward("Admin"));
		} else if (check.equals(item.getFault())) {
			return (mapping.findForward("Top"));
		} else {
			queryForm.setErrorMessage("エラー番号105が発生しました。管理者にお問い合わせ下さい");
			return (mapping.findForward("Top"));
		}
	}
}