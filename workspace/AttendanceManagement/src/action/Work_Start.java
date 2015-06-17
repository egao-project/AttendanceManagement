package action;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
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

		// AM_form�Ƃ̒�`
		AM_form queryForm = (AM_form) form;

		// �Ј��ԍ���AM_form���擾
		String empNum = queryForm.getEmpNum();

		// ���ݎ��Ԃ̎擾�ƃt�H�[���փZ�b�g
		Calendar now = Calendar.getInstance();
		int nowYear = now.get(Calendar.YEAR); 	// ���� �N
		int nowMonth = now.get(Calendar.MONTH); // ���� ��
		int nowDay = now.get(Calendar.DATE); 	// ���� ��
		int nowHour = now.get(Calendar.HOUR_OF_DAY); // ���� ��
		int nowMinute = now.get(Calendar.MINUTE); // ���� ��
		queryForm.setNowHour(String.valueOf(nowHour)); // ���ݎ���String��AM_form�ɃZ�b�g
		if (nowMinute == 0) { // ���ݕ���String��AM_form�ɃZ�b�g(0�Ȃ�00��)
			String nowMinute_0 = nowMinute + "0";
			queryForm.setNowMinute(nowMinute_0);
		} else {
			queryForm.setNowMinute(String.valueOf(nowMinute));
		}

		// ���ݎ��Ԃ��w��̏����ɂ��� ��)25:59
		String nowTime = String.valueOf(nowHour) + ":" + String.valueOf(nowMinute);

		// �J��グ�p�̎���
		int startHour_i = nowHour; // �J�グ ��
		String startMinute = null; // �J�グ ��

		// 15���P�ʂ̎��ԂɕύX
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

		// 15���P�ʂ̎��Ԃ��w��̏����ɂ��� ��)25:59
		String startTime = String.valueOf(startHour_i) + ":" + startMinute;

		// �o�Ύ��Ԃ�SQL��
		String sql = "INSERT INTO work_info (emp_no, date, work_year, work_month, work_day, work_start, real_start) "
				+ "VALUES ('" + empNum + "',cast( now() as date)," + nowYear + "," + nowMonth + "," + nowDay + ",'" + startTime + "','" + nowTime + "');";

		// DB�ڑ�
		try (Connection con = DBConnect.getConnect();
			Statement stmt = con.createStatement()) {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.err.println(e);
		}

		// �}�b�s���O�ɒl��Ԃ�
		return (mapping.findForward("Start"));
	}
}