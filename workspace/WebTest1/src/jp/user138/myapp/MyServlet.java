package jp.user138.myapp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyServlet() {
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

		// 文字コードの設定
		request.setCharacterEncoding("UTF-8");

		// 名前(=name)の取得
		String name = request.getParameter("name");
		if (name.length() == 0) {
			name = "名無し";
		}

		// 性別(=sex)の取得
		String sex = request.getParameter("sex");
		if (name.length() == 0) {
			name = "male";
		}

		String new_name;

		if ("male".equals(sex)) {
			new_name = "Mr." + name;
		} else {
			new_name = "Ms." + name;
		}

		// 新しい(Mr./Ms.がついた)名前をAttributeで追加
		request.setAttribute("new_name", new_name);

		// HttpSessionの作成
		HttpSession session = request.getSession(true);
		session.setAttribute("prev_name", name);

		// result.jspへ
		getServletConfig().getServletContext()
				.getRequestDispatcher("/result.jsp").forward(request, response);

	}
}
