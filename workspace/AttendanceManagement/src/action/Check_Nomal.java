package action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import util.DBConnect;
import util.Item;
import action.form.AM_form;

public class Check_Nomal extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// アクションフォームに値を格納する為に定義
		AM_form queryForm = (AM_form) form;
		Item item = new Item();

		// 入力した社員番号と一致するレコード取得のSQL文
		String sql = "SELECT * FROM employee WHERE emp_no = ?";

		// 認証処理用の変数
		int count = 0;
		String check = null;

		//DB接続
		try (Connection con = DBConnect.con();) {
			// 入力した社員番号と一致するレコード取得
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, queryForm.getEmpNum());
			ResultSet rs = pstmt.executeQuery();

			// 認証処理
			while (rs.next()) {
				count++;
				if (count == 1) {
					// 一致しなければ認証失敗
					if (!queryForm.getEmpPass().equals(rs.getString("emp_pass"))) {
						check = item.getFault();
						queryForm.setErrorMessage("パスワードが間違っています");
					} else {
						check = item.getSuccess();
						queryForm.setEmpName(rs.getString("emp_name"));
						queryForm.setErrorMessage("");
					}
				} else if (count > 1) {
					check = item.getFault();
					queryForm.setErrorMessage("エラー番号206が発生しました。管理者にお問い合わせ下さい");
				}
			}

			// 0件ならば認証失敗
			if (count == 0) {
				check = item.getFault();
				queryForm.setErrorMessage("登録がない番号です。");
			}

		} catch (NullPointerException e) {
			e.printStackTrace();
			check = item.getFault();
			queryForm.setErrorMessage("エラー番号201が発生しました。管理者にお問い合わせ下さい");
		} catch (SQLException e) {
			e.printStackTrace();
			check = item.getFault();
			queryForm.setErrorMessage("エラー番号202が発生しました。管理者にお問い合わせ下さい");
		} catch (Exception e) {
			e.printStackTrace();
			check = item.getFault();
			queryForm.setErrorMessage("エラー番号203が発生しました。管理者にお問い合わせ下さい");
		}

		// マッピングに値を返す
		if (check == null) {
			queryForm.setErrorMessage("エラー番号204が発生しました。管理者にお問い合わせ下さい");
			return (mapping.findForward("Top"));
		} else if (check.equals( item.getSuccess())){
			return (mapping.findForward("Nomal"));
		} else if (check.equals(item.getFault())){
			return (mapping.findForward("Top"));
		} else {
			queryForm.setErrorMessage("エラー番号205が発生しました。管理者にお問い合わせ下さい");
			return (mapping.findForward("Top"));
		}
	}
}