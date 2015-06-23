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
import org.apache.struts.action.ActionMessages;

import java.sql.PreparedStatement;
import action.form.AM_form;

public class Check_Admin extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// アクションフォームに値を格納する為に定義
		AM_form queryForm = (AM_form) form;

		// 社員番号・パスワードの取得
		String empNum = queryForm.getEmpNum();
		String empPass = queryForm.getEmpPass();
		System.out.println(empNum);
		System.out.println(empPass);

		Connection con = null;
		int count = 0;
		String check ="NG";

		ActionMessages errors = new ActionMessages();
		System.out.println("2");
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance(); 		// ドライバをロード
			System.out.println("ドライバのロードに成功しました"); 		// コンソール確認用
			con = DBConnect.getConnect(); 								// mysqlにコネクト
			System.out.println("データベース接続に成功しました"); 		// 確認用
			String sql = "select*from employee where emp_no like 'M%'";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("5");

			// 認証処理
			while (rs.next()) {

				if (count < rs.getRow()) {
					// 一致しなければ認証失敗
					if (empNum.startsWith("M")){
						if (empPass.equals(rs.getString("emp_pass"))) {
							check = "OK";
							queryForm.setMessage1("");
							break;
						} else {
							queryForm.setMessage1("パスワードが間違っています");
						}

					} else {
						queryForm.setMessage1("管理者権限がありません");

					}
				}
				count++;
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
					System.out.println("データベース切断に成功しました"); 		// 確認用
				} else {
					System.out.println("コネクションがありません"); 			// 確認用
				}
			} catch (SQLException e) {
				System.out.println("SQLException:" + e.getMessage());
			}

		}
		// マッピングに値を返す
		if (check.equals("OK")) {
			return (mapping.findForward("Admin"));
		} else {
			return (mapping.findForward("Top"));
		}
	}
}