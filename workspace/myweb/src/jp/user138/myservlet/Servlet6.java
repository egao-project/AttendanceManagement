package jp.user138.myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet6
 */
@WebServlet("/Servlet6")
public class Servlet6 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet6() {
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

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession(false);

		out.println("<html><body>");

		if (session == null) {
			out.println("<p>初回訪問です</p>");
			session = request.getSession(true);
			session.setAttribute("visited", "1");
			session.setMaxInactiveInterval(10);
		} else {
			String visited = (String) session.getAttribute("visited");
			int count = Integer.parseInt(visited) + 1;
			out.println("<p>訪問回数は" + count + "回目です</p>");
			session.setAttribute("visited", Integer.toString(count));
			out.println("有効期限：" + session.getMaxInactiveInterval() + "秒<br>");
		}
		out.println("<a href= 'http://localhost:8080/myweb/Servlet6'>"
				+ "再表示</a></body></html>");
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
