package action;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import util.DBConnect;
import action.form.AM_form;

public class Output extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// アクションフォーム利用の為の定義
		AM_form queryForm = (AM_form) form;

		// メッセージを初期化
		queryForm.setMessage("");
		queryForm.setErrorMessage("");

		/* 保存ダイアログのファイル名（月が一桁なら頭に0を付ける）
		   例）勤怠実績_滝本博昭_201606.csv */
		String csvName = null;
		if (queryForm.getOutput_month() < 10) {
			csvName = "勤怠実績_" + queryForm.getEmpName() + "_"
					+ queryForm.getOutput_year() + "0" + queryForm.getOutput_month() + ".csv";
		} else {
			csvName = "勤怠実績_" + queryForm.getEmpName() + "_"
					+ queryForm.getOutput_year() + queryForm.getOutput_month() + ".csv";
		}

		// CSVの中身に入れるコメント 例）勤怠実績（2015年6月）
		String dateCsv = "勤怠実績（" + queryForm.getOutput_year() + "年" + queryForm.getOutput_month() + "月度）";

		// 検索用結果用の変数(0なら本日のレコード無し、1以上なら有り)
		int count = 0;

		// 指定年月のCSVファイル出力
		try (Connection con = DBConnect.con();) {

			// 入力年月の情報があるか検索
			String countSql = "SELECT COUNT(*) AS emp_no FROM work_info WHERE emp_no = ? and work_year = ? and work_month = ?";
			PreparedStatement pstmt = con.prepareStatement(countSql);
			pstmt.setString(1, queryForm.getEmpNum());
			pstmt.setInt(2, queryForm.getOutput_year());
			pstmt.setInt(3, queryForm.getOutput_month());
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			count = rs.getInt("emp_no");

			// 入力年月が無ければエラーメッセージのセット、あれば出力
			if (count == 0) {
				queryForm.setErrorMessage("入力した年月の情報はありません");
			} else if (count < 0){
				queryForm.setErrorMessage("エラー番号504が発生しました。管理者にお問い合わせ下さい");
			} else if (count >= 1) {

				// OS情報を取得し、文字コード変更
				if(System.getProperty("os.name").startsWith("Win")){	// Windowsの場合
					String filename = new String(csvName.getBytes("Windows-31J"),"ISO-8859-1");
					// HTTPヘッダの出力
					response.setContentType("application/octet-stream;charset=Windows-31J");
					response.setHeader("Content-disposition","attachment; filename=\"" + filename + "\"");
				} else {												// それ以外
					String filename = new String(csvName.getBytes(),"ISO-8859-1");
					// HTTPヘッダの出力
					response.setContentType("application/octet-stream;charset=UTF-8");
					response.setHeader("Content-disposition","attachment; filename=\"" + filename + "\"");
				}

				response.flushBuffer();
				PrintWriter out = response.getWriter();

				// 対象レコードの指定カラムの取得
				String csvSql = "SELECT date, work_start, work_last, real_start, real_last FROM work_info "
						+ "where emp_no = ? AND work_year = ? AND work_month = ?";
				System.out.println(csvSql);
				pstmt = con.prepareStatement(csvSql);
				pstmt.setString(1, queryForm.getEmpNum());
				pstmt.setInt(2, queryForm.getOutput_year());
				pstmt.setInt(3, queryForm.getOutput_month());
				rs = pstmt.executeQuery();
				ResultSetMetaData rsmd = rs.getMetaData();

				// タイトル行の出力
				out.println("株式会社イーガオ");
				out.println(queryForm.getEmpName());
				out.println(dateCsv);
				out.println();
				out.println("日付,開始時刻,終了時刻,出勤時刻,退勤時刻");

				// 各行の内容を繰り返し出力
				while (rs.next()) {
					// 各カラムの内容を繰り返し出力
					for (int i = 1; i <= rsmd.getColumnCount(); i++) {
						out.print(rs.getString(i));
						out.print(i <= rsmd.getColumnCount() ? "," : "");
					}
					out.print(System.getProperty("line.separator"));
				}
				out.flush();
				out.close();
			}

		} catch (NullPointerException e) {
			e.printStackTrace();
			queryForm.setErrorMessage("エラー番号501が発生しました。管理者にお問い合わせ下さい");
		} catch (SQLException e) {
			e.printStackTrace();
			queryForm.setErrorMessage("エラー番号502が発生しました。管理者にお問い合わせ下さい");
		} catch (Exception e) {
			e.printStackTrace();
			queryForm.setErrorMessage("エラー番号503が発生しました。管理者にお問い合わせ下さい");
		}

		// マッピングに値を返す
		if (count == 0) {
			return (mapping.findForward("NG"));
		} else if (count < 0){
			return (mapping.findForward("NG"));
		} else {
			return null;
		}
	}
}