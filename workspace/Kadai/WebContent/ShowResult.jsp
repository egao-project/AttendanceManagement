<%@page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html:html lang="ja">

<head>
	<meta http-equiv="Content-Type" content="text/css; charset=UTF-8">
	<link rel="stylesheet" href="css.css" type="text/css">
	<title>結果</title>
	<style type="text/css">
		:focus { outline:#ffffbc double 5px; }
	</style>
</head>

<body bgcolor="#000000">
	<bean:message key="kadaiTitle" /><br>
	<div id="user_name">
		<bean:write name="KadaiForm" property="name" /> さん
	</div><br>
	<br>
	<div id="resultmessage">
		<bean:message key="resultmessage" />
	</div><br>
	<div id="result">
		<bean:write name="KadaiForm" property="result" />
	</div><br>
	<div id="comment">
		<bean:write name="KadaiForm" property="comment" />
	</div><br>
	<br>
	<div id="ShowResult_html">
		<div id="kako_link"><html:link href="http://localhost:8080/Kadai/kako.do">過去の統計へ</html:link></div>
		<div id="main_link"><html:link href="http://localhost:8080/Kadai/main.jsp">メインへ</html:link></div>
	</div>
</body>
</html:html>