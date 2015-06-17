package jp.user138.myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class C1P1
 */
@WebServlet("/C1P2")
public class C1P2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public C1P2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String subject = request.getParameter("subject");
			String msg = request.getParameter("msg");

			name = new String(name.getBytes("8859_1"));
			email = new String(email.getBytes("8859_1"));
			subject = new String(subject.getBytes("8859_1"));
			msg = new String(msg.getBytes("8859_1"));

			response.setContentType("text/html; charset=UTF-8");

			PrintWriter pw = response.getWriter();

			pw.println("<html><head><title>C1P2</title></head><body>");
			pw.println("<h1>フォームデータ</h1>");

			if (name.length() == 0) {
				pw.println("<h2>名前を入力してください</h2>");
			} else if (email.length() == 0) {
				pw.println("<h2>メールアドレスを入力してください</h2>");
			} else if (subject.length() == 0) {
				pw.println("<h2>題名を入力してください</h2>");
			} else if (msg.length() == 0) {
				pw.println("<h2>本文を入力してください</h2>");
			} else {
				pw.println("<table border=\"1\"><tr><th>フォーム要素<th>データ");
				pw.println("<tr><td>msg<td>" + msg);
				pw.println("<tr><td>email<td>" + email);
				pw.println("<tr><td>subject<td>" + subject);
				pw.println("<tr><td>name<td>" + name);
				pw.println("</table>");
			}
			pw.println("</body></html>");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
