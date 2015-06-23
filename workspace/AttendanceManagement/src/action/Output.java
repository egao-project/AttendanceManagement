package action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import util.DBConnect;
import action.form.AM_form;

public class Output extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		System.out.println("S");

		// AM_formとの定義
		AM_form queryForm = (AM_form) form;

		// 社員番号をAM_formより取得
//		String empNum = queryForm.getEmpNum();
		String empNum = "E010";

		// 指定年月の取得
//		int output_year = queryForm.getOutput_year();
//		int output_month = queryForm.getOutput_month();
		int output_year = 2015;
		int output_month = 6;

		Connection con = null;
		Statement stmt = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		System.out.println(1);

		// DB
		try {
			// DB接続
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DBConnect.getConnect();
			stmt = con.createStatement();
			System.out.println(2);

			// 社員名の取得
			String nameSql = "SELECT emp_name AS emp_name FROM employee WHERE emp_no = '" + empNum + "'";
			rs1 = stmt.executeQuery(nameSql);
			rs1.next();
			String empName = rs1.getString("emp_name");
			System.out.println(3);

			// ファイル名の書式
			String fileName = "勤怠管理_" + empName + "_" + output_year + "年" + output_month + "月";
//			String fileName = "takimoto";

			// CSVファイルの保存先
			String csvDestination = "C:\\\\AttendanceManagement\\\\CSV\\\\";

			// CSV出力のSQL文
			String csvSql = "SELECT * FROM work_info where emp_no = '" + empNum +"' AND work_year = " + output_year + " AND work_month = " + output_month + " INTO OUTFILE \"" + csvDestination + fileName + ".csv\" FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '" + "\"" + "'";
			System.out.println(4);

			// CSVファイル出力
			rs2 = stmt.executeQuery(csvSql);
			System.out.println(5);
//			System.out.println(csvSql);
			stmt.close();
			queryForm.setMessage(output_year + "年" + output_month + "月" + "を出力しました");
			System.out.println(6);
			System.out.println("ok");
		} catch (SQLException e) {
			queryForm.setErrorMessage("出力に失敗しました");
			System.out.println(e.getMessage());
			System.out.println("catch");
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.err.println(e);
			}

			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				System.err.println(e);
			}

			try {
				if (rs1 != null) {
					rs1.close();
				}
			} catch (SQLException e) {
				System.err.println(e);
			}

			try {
				if (rs2 != null) {
					rs2.close();
				}
			} catch (SQLException e) {
				System.err.println(e);
			}
		}

		// マッピングに値を返す
		return (mapping.findForward("Success"));
	}
}