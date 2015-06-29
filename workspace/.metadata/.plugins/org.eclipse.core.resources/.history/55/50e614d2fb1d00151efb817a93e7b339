package action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import util.DBConnect;
import util.Item;
import action.form.AM_form;

public class Work_Last extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// アクションフォーム・Itemクラス利用の為の定義
		AM_form queryForm = (AM_form) form;
		Item item = new Item();

		// メッセージを初期化
		queryForm.setMessage("");
		queryForm.setErrorMessage("");

		// 対象レコード検索用SQL文
		String countSql = "SELECT COUNT(*) AS emp_no FROM work_info WHERE emp_no = ? and date = ? and work_last IS NULL";

		// 終了時間のUPDATE用SQL文
		String lastSql = "UPDATE attendance_management.work_info SET work_last = ?, real_last = ? WHERE emp_no = ? AND date = ?";

		// 退勤レコード追加
		try (Connection con = DBConnect.con();) {

			// 既存レコードの検索
			PreparedStatement pstmt = con.prepareStatement(countSql);
			pstmt.setString(1, queryForm.getEmpNum());
			pstmt.setString(2, item.getToday());
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			int count = rs.getInt("emp_no"); 		// 検索用結果用の変数(0なら本日のレコード無し、1なら有り)

			// レコードのUPDATE（レコードが有る場合のみ(検索結果のcountが1)）
			if (count == 1) {
				pstmt = con.prepareStatement(lastSql);
				pstmt.setString(1, item.getWorkTime());
				pstmt.setString(2, item.getNowTime());
				pstmt.setString(3, queryForm.getEmpNum());
				pstmt.setString(4, item.getToday());
				pstmt.executeUpdate();
				pstmt.close();
				queryForm.setMessage(item.getNowTime() + "  本日もお疲れ様でした！");
				queryForm.setErrorMessage("");
			} else {
				queryForm.setMessage("");
				queryForm.setErrorMessage("既に退勤が押されています…");
			}

		} catch (ClassNotFoundException e) {
			System.out.println(e + " ドライバのロードに失敗");
		} catch (SQLException e) {
			System.out.println(e + "SQL文が間違っています");
		} catch (Exception e) {
			System.out.println(e + "Exception:" + e.getMessage());
		}

		// マッピングに値を返す
		return (mapping.findForward("Last"));
	}
}