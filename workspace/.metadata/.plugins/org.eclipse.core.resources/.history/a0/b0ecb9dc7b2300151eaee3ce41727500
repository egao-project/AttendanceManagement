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

public class Work_Start extends Action {

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

		// 既存レコード有無検索用のSQL文
		String countSql =  "SELECT COUNT(*) AS emp_no FROM work_info WHERE emp_no = ? AND date = ?";

		// 出勤レコード追加のSQL文
		String startSql = "INSERT INTO work_info (emp_no, date, work_year, work_month, work_day, work_start, real_start) "
						+ "VALUES (?, ?, ?, ?, ?, ?, ?);";

		// 出勤レコード追加
		try (Connection con = DBConnect.con();) {

			// 既存レコードの検索
			PreparedStatement pstmt = con.prepareStatement(countSql);
			pstmt.setString(1, queryForm.getEmpNum());
			pstmt.setString(2, item.getToday());
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			int count = rs.getInt("emp_no");		// 検索用結果用の変数(0なら本日のレコード無し、1なら有り)

			// レコード追加（レコードが無い場合のみ(検索結果のcountが0)）
			if (count == 0){
				pstmt = con.prepareStatement(startSql);
				pstmt.setString(1, queryForm.getEmpNum());
				pstmt.setString(2, item.getToday());
				pstmt.setInt(3, Item.nowYear);
				pstmt.setInt(4, Item.nowMonth);
				pstmt.setInt(5, Item.nowDay);
				pstmt.setString(6, item.getWorkTime());
				pstmt.setString(7, item.getNowTime());
				pstmt.executeUpdate();
				pstmt.close();
				queryForm.setMessage(item.getNowTime() + "  本日もお願いします！");
				queryForm.setErrorMessage("");
			} else {
				queryForm.setMessage("");
				queryForm.setErrorMessage("既に出勤が押されています…");
				System.out.println("レコード追加 失敗");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			queryForm.setMessage("");
			queryForm.setErrorMessage("エラー番号701が発生しました。管理者にお問い合わせ下さい");
		} catch (Exception e) {
			e.printStackTrace();
			queryForm.setMessage("");
			queryForm.setErrorMessage("エラー番号702が発生しました。管理者にお問い合わせ下さい");
		}

		// マッピングに値を返す
		return (mapping.findForward("Start"));
	}
}