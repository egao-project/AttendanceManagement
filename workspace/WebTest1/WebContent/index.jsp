<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSPとHTMLの連携</title>
</head>
<body>
<p>
<% String prev_name;
if(session != null){
	prev_name = (String)session.getAttribute("prev_name");
	if(prev_name != null){
%>
	<span style="color:red">
		以前、あなたはアクセスしたことがあります<br>
	</span>
	お久しぶりです <%= prev_name %> さん<br>
<%	}
}
%>
</p>

<h2>名前、性別、年齢を入力してください</h2>

<form action="/WebTest1/MyServlet" method="POST">
	氏名：<input type="text" name="name"><br>
	性別：<br>
	<input type="radio" name="sex" value="male" checked>男性<br>
	<input type="radio" name="sex" value="female">女性<br>
	年齢：<input type="text" name="age"><br>
	<input type="submit" value="submit">
</form>
</body>
</html>