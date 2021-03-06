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
import action.form.AM_form;

public class Management_Del extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// アクションフォームに値を格納する為に定義
		AM_form queryForm = (AM_form) form;

		// 入力された社員番号と一致するレコードを取得のSQL文
		String sql = "SELECT * FROM employee WHERE emp_no = ?";

		// 入力された社員番号と一致するレコードを削除するSQL文
		String newsql = "DELETE FROM employee WHERE emp_no = ?";

		// 認証処理用の変数
		int count = 0;

		// DB接続
		try (Connection con = DBConnect.con();) {

			// 入力された社員番号と一致するレコードを取得
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, queryForm.getEmpNum());
			ResultSet rs = pstmt.executeQuery();

			// 認証処理
			while (rs.next()) {
				count++;
				if (count == 1) {
					// 一致したら削除
					if (queryForm.getEmpNum().equals(rs.getString("emp_no"))) {
						pstmt = con.prepareStatement(newsql);
						pstmt.setString(1, queryForm.getEmpNum());
						pstmt.executeUpdate();
						queryForm.setMessage("削除しました");
					} else {
						queryForm.setErrorMessage("エラー番号405が発生しました。管理者にお問い合わせ下さい");
					}
				} else if ( !((count == 0) && (count == 1)) ){
					queryForm.setErrorMessage("エラー番号404が発生しました。管理者にお問い合わせ下さい");
				}
			}

			// 一致するレコードが無ければ認証失敗
			if (count == 0) {
				queryForm.setErrorMessage("登録がありません。");
			} else {
				queryForm.setErrorMessage("エラー番号404が発生しました。管理者にお問い合わせ下さい");
			}

		} catch (NullPointerException e) {
			e.printStackTrace();
			queryForm.setErrorMessage("エラー番号401が発生しました。管理者にお問い合わせ下さい");
		} catch (SQLException e) {
			e.printStackTrace();
			queryForm.setErrorMessage("エラー番号402が発生しました。管理者にお問い合わせ下さい");
		} catch (Exception e) {
			e.printStackTrace();
			queryForm.setErrorMessage("エラー番号403が発生しました。管理者にお問い合わせ下さい");
		}

		// マッピングに値を返す
		return (mapping.findForward("Del_Employee"));
	}
}