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

public class Work_Start extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		System.out.println("S");

		// アクションフォームに値を格納する為に定義
		AM_form queryForm = (AM_form) form;

		// 社員番号の取得
		String empNum = queryForm.getEmpNum();
//		String empNum = "E010";

		// 現在日時
		Calendar now = Calendar.getInstance();
		int nowYear = now.get(Calendar.YEAR); 			// 現在 年
		int nowMonth = now.get(Calendar.MONTH) + 1; 	// 現在 月
		int nowDay = now.get(Calendar.DATE); 			// 現在 日
		int nowHour = now.get(Calendar.HOUR_OF_DAY); 	// 現在 時
		int nowMinute = now.get(Calendar.MINUTE); 		// 現在 分
		if (nowMinute == 0) { 							// 分が0の際は00とし、フォームに格納
			String nowMinute_0 = "00";
			queryForm.setNowMinute(nowMinute_0);
		} else {
			queryForm.setNowMinute(String.valueOf(nowMinute));
		}

		// 現在の年月日を指定書式に変換 例)2015-06-17
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(now.getTime());

		// 現在日時を指定書式に変換 例)23:59
		String nowTime = String.valueOf(nowHour) + ":" + String.valueOf(nowMinute);

		// 開始時間
		int startHour = nowHour; // 開始 時
		String startMinute = null; // 開始 分

		// 15分単位に変換
		if (nowMinute == 0) {
			startMinute = "00";
		} else if (nowMinute <= 15) {
			startMinute = "15";
		} else if (nowMinute <= 30) {
			startMinute = "30";
		} else if (nowMinute <= 45) {
			startMinute = "45";
		} else {
			startMinute = "00";
			startHour = nowHour + 1;
		}

		// 15分単位のString 例)10:45
		String startTime = String.valueOf(startHour) + ":" + startMinute;

		// 出勤レコード追加のSQL文
		String sql = "INSERT INTO work_info (emp_no, date, work_year, work_month, work_day, work_start, real_start) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?);";

		// 既存レコードが無いか検索用のSQL文
		String countSql =  "SELECT COUNT(*) AS emp_no FROM work_info WHERE emp_no = '" + empNum + "' and date = '" + today + "'";

		Connection con = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		int count;							// 検索用変数
		ResultSet rs = null;
		System.out.println(1);

		// DB
		try {
			// DB接続
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DBConnect.getConnect();
			stmt = con.createStatement();
			pstmt = con.prepareStatement(sql);
			System.out.println(2);

			// 既存レコードの検索
			rs = stmt.executeQuery(countSql);
			rs.next();
			count = rs.getInt("emp_no");
			System.out.println(3);

			// レコード追加
			if (count == 0){
				pstmt.setString(1, empNum);
				pstmt.setString(2, today);
				pstmt.setInt(3, nowYear);
				pstmt.setInt(4, nowMonth);
				pstmt.setInt(5, nowDay);
				pstmt.setString(6, startTime);
				pstmt.setString(7, nowTime);
				pstmt.executeUpdate();
				pstmt.close();
				queryForm.setMessage1(nowTime + "  本日もお願いします！");
				System.out.println("ok");
			} else {
				queryForm.setErrorMessage("既に出社しています");
				System.out.println("NG");
			}
		} catch (SQLException e) {
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
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				System.err.println(e);
			}
		}

		// マッピングに値を返す
		return (mapping.findForward("Start"));
	}
}