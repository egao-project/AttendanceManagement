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

public class Work_Last extends Action {

	public ActionForward AM_form(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// AM_formとの定義
		AM_form queryForm = (AM_form) form;

		// 社員番号をAM_formより取得
		String empNum = queryForm.getEmpNum();

		// 現在時間の取得とフォームへセット
		Calendar now = Calendar.getInstance();
		int nowHour = now.get(Calendar.HOUR_OF_DAY); 	// 現在 時
		int nowMinute = now.get(Calendar.MINUTE); 		// 現在 分

		// 現在年月日を指定の書式にする 例)2015-06-17
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(now.getTime());

		// 現在時間を指定の書式にする 例)23:59
		String nowTime = String.valueOf(nowHour) + ":" + String.valueOf(nowMinute);

		// 繰り上げ用の時間
		int lastHour_i = nowHour; 		// 繰上げ 時
		String lastMinute = null; 		// 繰上げ 分

		// 15分単位の時間に変更
		if (nowMinute == 0) {
			lastMinute = "00";
		} else if (nowMinute <= 15) {
			lastMinute = "15";
		} else if (nowMinute <= 30) {
			lastMinute = "30";
		} else if (nowMinute <= 45) {
			lastMinute = "45";
		} else {
			lastMinute = "00";
			lastHour_i = nowHour + 1;
		}

		// 15分単位の時間を指定の書式にする 例)18:45
		String lastTime = String.valueOf(lastHour_i) + ":" + lastMinute;

		// 退勤時間のSQL文
		String sql = "UPDATE attendance_management.work_info SET work_last = '" + lastTime + "',real_last = '" + nowTime + "' "
					+ "WHERE emp_no = '" + empNum + "' AND date = '" + today + "';";

		// DB接続とSQL文の発行
		try (Connection con = DBConnect.getConnect();
			Statement stmt = con.createStatement()) {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.err.println(e);
		}

		// マッピングに値を返す
		return (mapping.findForward("Last"));
	}
}