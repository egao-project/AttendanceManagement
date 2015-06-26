package action;

import util.DBConnect;
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

		// 社員番号の頭文字にMがつくレコード取得のSQL文
		String sql = "SELECT * FROM employee WHERE emp_no LIKE 'M%'";

		// 認証処理用の変数
		int count = 0;
		String check = "NG";

		try (Connection con = DBConnect.con();) {

			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			// 認証処理
			while (rs.next()) {
				if (count < rs.getRow()) {
					// 一致しなければ認証失敗
					if (queryForm.getEmpNum().startsWith("M")) {
						if (queryForm.getEmpPass().equals(rs.getString("emp_pass"))) {
							check = "OK";
							queryForm.setErrorMessage("");
							break;
						} else {
							queryForm.setErrorMessage("番号とパスワードの組み合わせが間違っています");
						}

					} else {
						queryForm.setErrorMessage("管理者権限のない番号です");
					}
				}
				count++;
			}

		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException:" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQLException:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
		}

		// マッピングに値を返す
		if (check.equals("OK")) {
			return (mapping.findForward("Admin"));
		} else {
			return (mapping.findForward("Top"));
		}
	}
}