<%@page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html:html lang="ja">

<head>
	<meta http-equiv="Content-Type" content="text/css; charset=UTF-8">
	<link rel="stylesheet" href="css.css" type="text/css">
	<title>後味悪い占い</title>
	<style type="text/css">
		:focus { outline:#ffffbc double 5px; }
	</style>
</head>

<body bgcolor="#000000">
	<html:form action="/Kadai">
		<br>
		<br>
		<br>
		<br>
		<br>
		<bean:message key="kadaiTitle" /><br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<bean:message key="name_in" /><br>
		<bean:message key="attention" /><br>
		<html:text property="name" size="40" /><br>
		<html:errors property="name"/><br>
		<html:submit><bean:message key="fotune" /></html:submit>
	</html:form>
</body>
</html:html>