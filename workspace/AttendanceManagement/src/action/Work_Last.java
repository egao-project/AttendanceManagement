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

public class Work_Last extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		System.out.println("S");

		// AM_formとの定義
		AM_form queryForm = (AM_form) form;

		// 社員番号をAM_formより取得
//		String empNum = queryForm.getEmpNum();
		String empNum = "E010";

		// 現在時間の取得とフォームへセット
		Calendar now = Calendar.getInstance();
		int nowYear = now.get(Calendar.YEAR); 			// 現在 年
		int nowMonth = now.get(Calendar.MONTH) + 1; 	// 現在 月
		int nowDay = now.get(Calendar.DATE); 			// 現在 日
		int nowHour = now.get(Calendar.HOUR_OF_DAY); 	// 現在 時
		int nowMinute = now.get(Calendar.MINUTE); 		// 現在 分
		if (nowMinute == 0) { 							// 現在 分をStringでAM_formにセット(0なら00で)
			String nowMinute_0 = nowMinute + "0";
			queryForm.setNowMinute(nowMinute_0);
		} else {
			queryForm.setNowMinute(String.valueOf(nowMinute));
		}

		// 現在年月日を指定の書式にする 例)2015-06-17
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(now.getTime());

		// 現在時間を指定の書式にする 例)23:59
		String nowTime = String.valueOf(nowHour) + ":" + String.valueOf(nowMinute);

		// 繰り上げ用の時間
		int startHour_i = nowHour; // 繰上げ 時
		String startMinute = null; // 繰上げ 分

		// 15分単位の時間に変更
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
			startHour_i = nowHour + 1;
		}

		// 15分単位の時間を指定の書式にする 例)18:45
		String lastTime = String.valueOf(startHour_i) + ":" + startMinute;

		// 退勤時間のレコード追加のSQL文
		String sql = "UPDATE attendance_management.work_info SET work_last = ?, real_last = ? WHERE emp_no = ? AND date = ?";

		// 既存レコードか確認用の件数取得SQL文
		String countSql =  "SELECT COUNT(*) AS emp_no FROM work_info "
				+ "WHERE emp_no = '" + empNum + "' and date = '" + today + "' and work_last IS NULL;";

		Connection con = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		int count;							// 検索用の変数
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

			// レコードが既存か確認の為に件数を取得
			rs = stmt.executeQuery(countSql);
			rs.next();
			count = rs.getInt("emp_no");
			System.out.println(3);

			// レコード追加
			if (count == 1){
				pstmt.setString(1, lastTime);
				pstmt.setString(2, nowTime);
				pstmt.setString(3, empNum);
				pstmt.setString(4, today);
				pstmt.executeUpdate();
				pstmt.close();
				queryForm.setMessage(nowTime + "  お疲れ様でした！");
				System.out.println("ok");
			} else {
				queryForm.setErrorMessage("既に本日は退社しています");
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
		return (mapping.findForward("Last"));
	}
}