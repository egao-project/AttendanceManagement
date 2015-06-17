<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>はじめてのJSP</title>
</head>
<body>
	<h2></h2>
	<p>
		今
		<%=new java.util.Date()%>です<br>
		<%="Hello World!"%>
	</p>
	<p>
		<%!int max = 5;%>
		サイズ<%=max%>の三角形を描きます。<br>
		<%
			for (int row = 1; row <= max; row++) {
				for (int col = 1; col <= row; col++) {
					out.print("* ");
				}
				out.print("<br>");
			}
		%>
	</p>
</body>
</html>