package action;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import action.form.AM_form;

public class Management_Add extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		System.out.println("1あいうえお");

		// AM_formとの定義
		AM_form queryForm = (AM_form) form;
		String eNum = queryForm.getEmpNum();
		System.out.println(eNum);
		String eName = queryForm.getEmpName();
		System.out.println(eName);
		String ePass = queryForm.getEmpPass();
		System.out.println(ePass);

		Connection con = null;
		PrintWriter out = response.getWriter();

		// 本運用時に変更！
		String url = "jdbc:mysql://localhost/attendance_management";
		String user = "root";
		String password = "ja0007ks";

		ActionMessages errors = new ActionMessages();
		System.out.println("2あいうえお");
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance(); // ドライバをロード
			System.out.println("3あいうえお");
			out.println("ドライバのロードに成功しました"); // コンソール確認用
			con = DriverManager.getConnection(url, user, password); // mysqlにコネクト
			out.println("データベース接続に成功しました"); // 確認用
			System.out.println("4あいうえお");
			String sql = "insert into employee values (?,?,?) on duplicate key update emp_name=? , emp_pass=?"; // emp_no=?,
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, eNum);
			pstmt.setString(2, ePass);
			pstmt.setString(3, eName);
			// pstmt.setString(2, eNum);
			pstmt.setString(4, eName);
			pstmt.setString(5, ePass);
			pstmt.executeUpdate(); // 記述した値を入力
			ResultSet rs = pstmt.executeQuery("select*from employee;"); // 以下、※まで確認用
			System.out.println("5あいうえお");

			while (rs.next()) {
				out.println(rs.getString("emp_no"));
				out.println(rs.getString("emp_name"));

			}
			rs.close();
			pstmt.close(); // ※※※ここまで確認※※※
			System.out.println("6あいうえお");

		} catch (ClassNotFoundException e) {
			out.println("ドライバのロードに失敗しました");
			System.out.println("7あいうえお");
		} catch (SQLException e) {
			out.println("SQL文が間違っています");
			System.out.println("8あいうえお");
		} catch (Exception e) {
			out.println("Exception:" + e.getMessage());
			System.out.println("9あいうえお");
		} finally {
			try {
				if (con != null) {
					con.close();
					out.println("データベース切断に成功しました"); // 確認用
					System.out.println("10あいうえお");
				} else {
					out.println("コネクションがありません"); // 確認用
					System.out.println("あいうえお");
				}
			} catch (SQLException e) {
				out.println("SQLException:" + e.getMessage());
				System.out.println("あいうえお");
			}
		}

		// マッピングに値を返す
		return (mapping.findForward("Add_Employee"));
	}
}