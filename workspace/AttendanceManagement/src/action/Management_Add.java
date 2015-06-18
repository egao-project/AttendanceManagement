package action;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import action.form.AM_form;

public class Management_Add extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		System.out.println("1����������");

		// AM_form�Ƃ̒�`
		AM_form queryForm = (AM_form) form;
		String eNum = queryForm.getEmpNum();
		System.out.println(eNum);
		String eName = queryForm.getEmpName();
		System.out.println(eName);
		String ePass = queryForm.getEmpPass();
		System.out.println(ePass);

		Connection con = null;
		PrintWriter out = response.getWriter();

		// �{�^�p���ɕύX�I
		String url = "jdbc:mysql://localhost/attendance_management";
		String user = "root";
		String password = "ja0007ks";

		ActionMessages errors = new ActionMessages();
		System.out.println("2����������");
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance(); // �h���C�o�����[�h
			System.out.println("3����������");
			out.println("�h���C�o�̃��[�h�ɐ������܂���"); // �R���\�[���m�F�p
			con = DriverManager.getConnection(url, user, password); // mysql�ɃR�l�N�g
			out.println("�f�[�^�x�[�X�ڑ��ɐ������܂���"); // �m�F�p
			System.out.println("4����������");
			String sql = "insert into employee values (?,?,?) on duplicate key update emp_name=? , emp_pass=?"; // emp_no=?,
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, eNum);
			pstmt.setString(2, ePass);
			pstmt.setString(3, eName);
			// pstmt.setString(2, eNum);
			pstmt.setString(4, eName);
			pstmt.setString(5, ePass);
			pstmt.executeUpdate(); // �L�q�����l�����
			ResultSet rs = pstmt.executeQuery("select*from employee;"); // �ȉ��A���܂Ŋm�F�p
			System.out.println("5����������");

			while (rs.next()) {
				out.println(rs.getString("emp_no"));
				out.println(rs.getString("emp_name"));

			}
			rs.close();
			pstmt.close(); // �����������܂Ŋm�F������
			System.out.println("6����������");

		} catch (ClassNotFoundException e) {
			out.println("�h���C�o�̃��[�h�Ɏ��s���܂���");
			System.out.println("7����������");
		} catch (SQLException e) {
			out.println("SQL�����Ԉ���Ă��܂�");
			System.out.println("8����������");
		} catch (Exception e) {
			out.println("Exception:" + e.getMessage());
			System.out.println("9����������");
		} finally {
			try {
				if (con != null) {
					con.close();
					out.println("�f�[�^�x�[�X�ؒf�ɐ������܂���"); // �m�F�p
					System.out.println("10����������");
				} else {
					out.println("�R�l�N�V����������܂���"); // �m�F�p
					System.out.println("����������");
				}
			} catch (SQLException e) {
				out.println("SQLException:" + e.getMessage());
				System.out.println("����������");
			}
		}

		// �}�b�s���O�ɒl��Ԃ�
		return (mapping.findForward("Add_Employee"));
	}
}