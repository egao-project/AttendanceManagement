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
import org.apache.struts.action.ActionMessages;

import util.DBConnect;
import action.form.AM_form;

public class Management_Add extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		System.out.println("1");

		// �A�N�V�����t�H�[���ɒl���i�[����ׂɒ�`
		AM_form queryForm = (AM_form) form;
		String eNum = queryForm.getEmpNum();
		System.out.println(eNum);
		String eName = queryForm.getEmpName();
		System.out.println(eName);
		String ePass = queryForm.getEmpPass();
		System.out.println(ePass);

		Connection con = null;
		int count = 0;

		// 本運用時に変更！
		String url = "jdbc:mysql://localhost/attendance_management";
		String user = "root";
		String password = "ja0007ks";

		ActionMessages errors = new ActionMessages();
		System.out.println("2");
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance(); // ドライバをロード
			System.out.println("ドライバのロードに成功しました"); // コンソール確認用
			con = DBConnect.getConnect();// mysqlにコネクト
			System.out.println("データベース接続に成功しました"); // 確認用
			String sql = "select* from employee";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(); // 以下、※まで確認用
			queryForm.setMessage2("登録完了");
			System.out.println("4.5");
			System.out.println("5");

			while (rs.next()) {
				count++;
				if (count > 0) {
					if (eNum.equals(rs.getString("emp_no"))) {
						queryForm.setMessage2("修正完了");
					}
				}
			}

			String newsql = "insert into employee values (?,?,?) on duplicate key update emp_name=? , emp_pass=?";
			pstmt = con.prepareStatement(newsql);
			pstmt.setString(1, eNum);
			pstmt.setString(2, eName);
			pstmt.setString(3, ePass);
			pstmt.setString(4, eName);
			pstmt.setString(5, ePass);
			pstmt.executeUpdate(); // 記述した値を入力

			rs.close();
			pstmt.close(); // ※※※ここまで確認※※※
			System.out.println("6");

		} catch (ClassNotFoundException e) {
			System.out.println("ドライバのロードに失敗しました");
		} catch (SQLException e) {
			System.out.println("SQL文が間違っています");
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
		} finally {
			try {
				if (con != null) {
					con.close();
					System.out.println("データベース切断に成功しました"); // 確認用
				} else {
					System.out.println("コネクションがありません"); // 確認用
				}
			} catch (SQLException e) {
				System.out.println("SQLException:" + e.getMessage());
			}
		}

		// �}�b�s���O�ɒl��Ԃ�
		return (mapping.findForward("Add_Employee"));
	}
}