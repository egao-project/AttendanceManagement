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
import action.form.AM_form;

public class Check_Nomal extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// アクションフォームに値を格納する為に定義
		AM_form queryForm = (AM_form) form;

		// 入力した社員番号と一致するレコード取得のSQL文
		String sql = "SELECT * FROM employee WHERE emp_no = ?";

		// 認証処理用の変数
		int count = 0;
		String check = "NG";

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
						queryForm.setErrorMessage("パスワードが間違っています");
					} else {
						check = "OK";
						queryForm.setEmpName(rs.getString("emp_name"));
						queryForm.setErrorMessage("");
					}
				}
			}

			// 0件ならば認証失敗
			if (count == 0) {
				queryForm.setErrorMessage("登録がない番号です。");
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
			return (mapping.findForward("Nomal"));
		} else {
			return (mapping.findForward("Top"));
		}
	}
}