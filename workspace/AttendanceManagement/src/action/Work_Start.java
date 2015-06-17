package action;

import java.sql.Connection;
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

	public ActionForward AM_form(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// AM_formとの定義
		AM_form queryForm = (AM_form) form;

		// 社員番号をAM_formより取得
		String empNum = queryForm.getEmpNum();

		// 現在時間の取得とフォームへセット
		Calendar now = Calendar.getInstance();
		int nowYear = now.get(Calendar.YEAR); 			// 現在 年
		int nowMonth = now.get(Calendar.MONTH); 		// 現在 月
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
		String startTime = String.valueOf(startHour_i) + ":" + startMinute;

		// 出勤時間のSQL文
		String sql = "INSERT INTO work_info (emp_no, date, work_year, work_month, work_day, work_start, real_start) "
				+ "VALUES ('" + empNum + "'," + today + "," + nowYear + "," + nowMonth + "," + nowDay + ",'" + startTime + "','" + nowTime + "');";

		// DB接続
		try (Connection con = DBConnect.getConnect();
			Statement stmt = con.createStatement()) {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.err.println(e);
		}

		// マッピングに値を返す
		return (mapping.findForward("Start"));
	}
}