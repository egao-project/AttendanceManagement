package jp.user138.myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet5
 */
@WebServlet("/Servlet5")
public class Servlet5 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet5() {
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

		out.println("<html><body>");

		Cookie cookie[] = request.getCookies();
		Cookie visited = null;

		if (cookie != null) {
			for (int i = 0; i < cookie.length; i++) {
				if (cookie[i].getName().equals("visited")) {
					visited = cookie[i];
					break;
				}
			}
			if (visited != null) {
				int count = Integer.parseInt(visited.getValue()) + 1;
				out.println("<p>" + count + "回目の訪問です</p>");
				visited.setValue(Integer.toString(count));
				visited.setMaxAge(60);
				response.addCookie(visited);
			}
		}

		if (cookie == null || visited == null) {
			out.println("<p>初回の訪問です</p>");
			Cookie newCookie = new Cookie("visited", "1");
			newCookie.setMaxAge(60);
			response.addCookie(newCookie);
		}
		out.println("<a href= 'http://localhost:8080/myweb/Servlet5'>"
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
