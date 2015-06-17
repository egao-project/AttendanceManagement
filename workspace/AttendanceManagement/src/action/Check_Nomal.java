package action;

import util.DBConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import action.form.AM_form;

public class Check_Nomal extends Action {

	public ActionForward AM_form(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// フォームへアクセスする為に定義
		AM_form queryForm = (AM_form) form;

		//フォームから各項目の取得
		int	   empNum  = queryForm.getEmpNum();
		String empName = queryForm.getEmpName();
		String empPass = queryForm.getEmpPass();

		// SQL文
		String sqlNum  = "SELECT emp_no FROM employee WHERE emp_no = " + empNum;
		String sqlName = "";
		String sqlPass = "";

		// DB接
		try (Connection con = DBConnect.getConnect();
				Statement stmt = con.createStatement()) {
			int count = stmt.executeUpdate(sql);
			System.out.println("更新件数" + count);
		} catch (SQLException e) {
			System.err.println(e);
		}

		// マッピングに値を返す
		return (mapping.findForward("Nomal"));
	}
}