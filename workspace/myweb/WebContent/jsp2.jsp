<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP2</title>
</head>
<body>
	<%
		String name = request.getParameter("name");
	%>
	<h2>
		現在時刻は<%=new Date()%>です。
	</h2>
	<p>
		<%
			if (name.length() != 0) {
		%>
		<%=name%>さん、こんにちは<br>
		<%
			} else {
		%>
		名前を入力してください<br>
		<%
			}
		%>
	</p>
</body>
</html>