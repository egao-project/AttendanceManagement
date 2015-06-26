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

public class Management_Add extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// アクションフォームに値を格納する為に定義
		AM_form queryForm = (AM_form) form;

		// employeeテーブルの全情報取得のSQL文
		String sql = "SELECT * FROM employee";

		// レコードが無ければINSERT、有ればUPDATEのSQL文
		String newsql = "INSERT INTO employee VALUES (?, ?, ?) ON DUPLICATE KEY UPDATE emp_name=?, emp_pass=?";

		// 認証処理用の変数
		int count = 0;

		// DB接続
		try (Connection con = DBConnect.con();) {

			// employeeテーブルの全情報取得
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			// メッセージの格納
			while (rs.next()) {
				count++;
				if (count > 0) {
					if (queryForm.getEmpNum().equals(rs.getString("emp_no"))) {
						queryForm.setMessage("修正完了");
						break;
					} else {
						queryForm.setMessage("登録完了");
					}
				}
			}

			// レコードが無ければINSERT、有ればUPDATE
			pstmt = con.prepareStatement(newsql);
			pstmt.setString(1, queryForm.getEmpNum());
			pstmt.setString(2, queryForm.getEmpName());
			pstmt.setString(3, queryForm.getEmpPass());
			pstmt.setString(4, queryForm.getEmpName());
			pstmt.setString(5, queryForm.getEmpPass());
			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException:" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQLException:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
		}

		// マッピングに値を返す
		return (mapping.findForward("Add_Employee"));
	}
}