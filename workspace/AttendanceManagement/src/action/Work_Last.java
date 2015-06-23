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
		if (nowMinute == 0) { 							// 分が0の時に00とし、フォームに格納
			String nowMinute_0 = nowMinute + "0";
			queryForm.setNowMinute(nowMinute_0);
		} else {
			queryForm.setNowMinute(String.valueOf(nowMinute));
		}

		// 年月日 例)2015-06-17
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(now.getTime());

		// 現在日時 例)23:59
		String nowTime = String.valueOf(nowHour) + ":" + String.valueOf(nowMinute);

		// 終了時間
		int lastHour_i = nowHour; // 終了 時
		String lastMinute = null; // 終了 分

		// 15分単位に変換
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

		// 15分単位のString 例)18:45
		String lastTime = String.valueOf(lastHour_i) + ":" + lastMinute;

		// 終了時間のUPDATE SQL文
		String sql = "UPDATE attendance_management.work_info SET work_last = ?, real_last = ? WHERE emp_no = ? AND date = ?";

		// 対象レコード検索用SQL文
		String countSql =  "SELECT COUNT(*) AS emp_no FROM work_info "
				+ "WHERE emp_no = '" + empNum + "' and date = '" + today + "' and work_last IS NULL;";

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

			// 対象レコードの検索
			rs = stmt.executeQuery(countSql);
			rs.next();
			count = rs.getInt("emp_no");
			System.out.println(3);

			// UPDATE文の発行
			if (count == 1){
				pstmt.setString(1, lastTime);
				pstmt.setString(2, nowTime);
				pstmt.setString(3, empNum);
				pstmt.setString(4, today);
				pstmt.executeUpdate();
				pstmt.close();
				queryForm.setMessage1(nowTime + "  お疲れ様でした！");
				System.out.println("ok");
			} else {
				queryForm.setErrorMessage("既に帰社しています");
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