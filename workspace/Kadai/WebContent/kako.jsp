<%@page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html:html lang="ja">

<head>
	<meta http-equiv="Content-Type" content="text/css; charset=UTF-8">
	<link rel="stylesheet" href="css.css" type="text/css">
	<title>過去の統計</title>
	<style type="text/css">
		:focus { outline:#ffffbc double 5px; }
	</style>
</head>

<body bgcolor="#000000">
	<bean:message key="kadaiTitle" /><br>
	<div id="user_name"><bean:write name="KadaiForm" property="name" /> さんの統計</div><br>
	<br>
	<div id="user_count"><bean:write name="KadaiForm" property="userResultTotal" /> さんの統計</div><br>
	<table align="center" id="table_kako">
		<tr id="tr0"><td><bean:message key="userResultTotal" /><td><bean:message key="space" /><td><bean:write name="KadaiForm" property="userResultTotal" />回
		<tr id="tr1"><td><bean:message key="resultName1" /><td><bean:message key="space" /><td><bean:write name="KadaiForm" property="result1Percent" />
		<tr id="tr2"><td><bean:message key="resultName2" /><td><bean:message key="space" /><td><bean:write name="KadaiForm" property="result2Percent" />
		<tr id="tr3"><td><bean:message key="resultName3" /><td><bean:message key="space" /><td><bean:write name="KadaiForm" property="result3Percent" />
		<tr id="tr4"><td><bean:message key="resultName4" /><td><bean:message key="space" /><td><bean:write name="KadaiForm" property="result4Percent" />
		<tr id="tr5"><td><bean:message key="resultName5" /><td><bean:message key="space" /><td><bean:write name="KadaiForm" property="result5Percent" />
	</table>
	<br>
	<br>
	<div align="center"><html:link href="http://localhost:8080/Kadai/main.jsp">メインへ</html:link></div>
</body>
</html:html>