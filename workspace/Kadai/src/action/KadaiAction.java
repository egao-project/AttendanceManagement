package action;

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

import action.form.KadaiForm;

public class KadaiAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// アクションフォームに値を格納する為に定義
		KadaiForm queryForm = (KadaiForm) form;

		//KadaiFormから名前を取得
		String userName = queryForm.getName();

		// 取得したミリ秒から下一桁を取得
		Date Now = new Date();
		long fotuneValue = Now.getTime() % 10;

		//現在日時を取得
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm.ss");
        String strTime = sdf.format(cal.getTime());

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

		try {
			con = DriverManager.getConnection(url, user, pwd);
			stmt = con.createStatement();

			// fotuneValueとresultmuchテーブルのnumberに該当する結果とコメントを取得
			String resultSelect = "SELECT dbresult FROM result WHERE dbnum =" + fotuneValue;
			rs1 = stmt.executeQuery(resultSelect);
			rs1.next();
			String result = rs1.getString("dbresult");
			queryForm.setResult(result);

			String commentSelect = "SELECT dbcomment FROM result WHERE dbnum =" + fotuneValue;
			rs2 = stmt.executeQuery(commentSelect);
			rs2.next();
			String comment = rs2.getString("dbcomment");
			queryForm.setComment(comment);

			//userlistテーブルにインサート
			String userSet = "INSERT INTO userlist VALUES('" + strTime + "','" + userName + "','" + result + "')";
			stmt.executeUpdate(userSet);


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
