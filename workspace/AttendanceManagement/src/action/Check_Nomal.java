package action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import util.DBConnect;
import action.form.AM_form;

public class Check_Nomal extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// アクションフォームに値を格納する為に定義
		AM_form queryForm = (AM_form) form;

		// 社員番号・パスワードの取得
		String empNum = queryForm.getEmpNum();
		String empPass = queryForm.getEmpPass();

		int count = 0;
		String check = "NG";

		ActionMessages errors = new ActionMessages();

		Connection con = null;
		System.out.println("2");

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance(); // ドライバをロード
			System.out.println("ドライバのロードに成功しました"); // コンソール確認用
			con = DBConnect.getConnect(); // mysqlにコネクト
			System.out.println("データベース接続に成功しました"); // 確認用

			String sql = "select * from employee where emp_no = ?";

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, empNum);

			ResultSet rs = pstmt.executeQuery();
			System.out.println("5");

			// 認証処理
			while (rs.next()) {
				count++;

				if (count == 1) {
					// 一致しなければ認証失敗
					if (!empPass.equals(rs.getString("emp_pass"))) {
						queryForm.setMessage1("パスワードが間違っています");
					} else {
						queryForm.setEmpName(rs.getString("emp_name"));
						check = "OK";
						queryForm.setMessage1("");
					}
				}
			}

			// 0件ならば認証失敗
			if (count == 0) {
				queryForm.setMessage1("登録がありません。");
			}

			rs.close();
			pstmt.close();
			System.out.println("6");

		} catch (ClassNotFoundException e) {
			System.out.println("ドライバのロードに失敗しました");
			System.out.println("7");
		} catch (SQLException e) {
			System.out.println("SQL文が間違っています");
			System.out.println("8");
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
			System.out.println("9");
		} finally {
			try {
				if (con != null) {
					con.close();
					System.out.println("データベース切断に成功しました"); // 確認用
				} else {
					System.out.println("コネクションがありません"); // 確認用
				}
			} catch (SQLException e) {
				System.out.println("SQLException:" + e.getMessage());
			}

		}
		// マッピングに値を返す
		String message = queryForm.getMessage1();
		System.out.println(message);

		if (check.equals("OK")) {
			return (mapping.findForward("Nomal"));
		} else {
			return (mapping.findForward("Top"));
		}
	}
}