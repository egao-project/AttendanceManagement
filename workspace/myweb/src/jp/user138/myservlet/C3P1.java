package jp.user138.myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class C3P1
 */
@WebServlet("/C3P1")
public class C3P1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public C3P1() {
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

		out.println("<html><body><p>");

		Cookie cookie[] = request.getCookies();

		if (cookie != null) {
			out.print("クッキーの一覧を表示します<br>");
			for (int i=0;i<cookie.length;i++) {
				String k= URLDecoder.decode(cookie[i].getName(),"UTF-8");
				String v= URLDecoder.decode(cookie[i].getValue(),"UTF-8");
				out.println("key=" + k + "  val=" + v + "<br>");
			}
		} else {
			out.println("クッキーが存在しません");
		}

		String key = request.getParameter("key");
		String val = request.getParameter("val");

		if(key.length() != 0 && val.length() != 0){
			out.println("key=" + key + "  val=" + val + " を追加します<br>");
			key = URLEncoder.encode(key,"UTF-8");
			val = URLEncoder.encode(val,"UTF-8");
			Cookie newCookie = new Cookie(key, val);
			response.addCookie(newCookie);
		}

		out.println("<a href= 'http://localhost:8080/myweb/C3P1.html'>戻る</a></body></html>");
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
