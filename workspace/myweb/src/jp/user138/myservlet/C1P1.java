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
@WebServlet("/C1P1")
public class C1P1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public C1P1() {
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
		try {
			String name = request.getParameter("name");
			String mail = request.getParameter("mail");
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter pw = response.getWriter();

			pw.println("<html><head><title>C1P1</title></head><body>");

			if (name.length() == 0) {
				pw.println("<h2>名前を入力してください</h2>");
			} else if (mail.length() == 0) {
				pw.println("<h2>メールアドレスを入力してください</h2>");
			} else {
				pw.println("<table border=\"1\"><tr><td>名　前<td>" + name);
				pw.println("<tr><td>メール<td>" + mail);
				pw.println("</table>");
			}
			pw.println("</body></html>");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
