<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>C2P1</title>
</head>
<body>
	<%
		String name  = request.getParameter("name");
		String email = request.getParameter("email");
	%>
	<p>
		<%
			if (name.length() == 0) {
		%>
			名前を入力してください
		<%
			} else if (email.length() == 0){
		%>
			メールアドレスを入力して下さい
		<%
			} else {
		%>
		<table border="1">
			<tr><td>名　前<td><%= name %>
			<tr><td>メール<td><%= email %>
		</table>
		<%
			}
		%>
</body>
</html>