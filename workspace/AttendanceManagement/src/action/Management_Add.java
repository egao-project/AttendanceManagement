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

		// DB接続
		try (Connection con = DBConnect.con();) {

			// employeeテーブルの全情報取得
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			// メッセージの格納
			while (rs.next()) {
				if (queryForm.getEmpNum().equals(rs.getString("emp_no"))) {
					queryForm.setMessage("修正完了");
					break;
				} else {
					queryForm.setMessage("登録完了");
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

		} catch (NullPointerException e) {
			e.printStackTrace();
			queryForm.setErrorMessage("エラー番号301が発生しました。管理者にお問い合わせ下さい");
		} catch (SQLException e) {
			e.printStackTrace();
			queryForm.setErrorMessage("エラー番号302が発生しました。管理者にお問い合わせ下さい");
		} catch (Exception e) {
			e.printStackTrace();
			queryForm.setErrorMessage("エラー番号303が発生しました。管理者にお問い合わせ下さい");
		}

		// マッピングに値を返す
		return (mapping.findForward("Add_Employee"));
	}
}