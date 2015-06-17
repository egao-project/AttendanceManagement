package action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class CopyOfKadaiAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// DBにアクセス
		String host = "localhost";
		String port = "1521";
		String name = "XE";
		String user = "SYSTEM";
		String pwd = "abc";
		String url = "jdbc:oracle:thin:@" + host + ":" + port + "/" + name;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;

		String empNum = "E010";
		int nowYear = 2001;
		int nowMonth = 12;
		int nowDay = 31;
		String startTime = "12:15";
		String nowTime = "12:15";

		try {
			con = DriverManager.getConnection(url, user, pwd);
			stmt = con.createStatement();

			//userlistテーブルにインサート
			String sql = "INSERT INTO work_info (emp_no, work_year, work_month, work_day, work_start, real_start) "
					+ "VALUES ('" + empNum + "'," + nowYear + "," + nowMonth + "," + nowDay + ",'" + startTime + "','" + nowTime + "');";
			stmt.executeUpdate(sql);


		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			//rs1
			try {
				if (rs1 != null) {
					rs1.close();
				}
			} catch (SQLException e) {
				System.err.println(e);
			}

			try {
				if (rs1 != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				System.err.println(e);
			}

			try {
				if (rs1 != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.err.println(e);
			}

			//rs2
			try {
				if (rs2 != null) {
					rs2.close();
				}
			} catch (SQLException e) {
				System.err.println(e);
			}

			try {
				if (rs2 != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				System.err.println(e);
			}

			try {
				if (rs2 != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.err.println(e);
			}
		}


		// マッピングに値を返す
		return (mapping.findForward("show"));

	}
}
