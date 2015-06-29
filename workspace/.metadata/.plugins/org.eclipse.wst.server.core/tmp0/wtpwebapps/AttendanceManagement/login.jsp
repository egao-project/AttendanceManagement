<%@page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html:html>

<head>
	<meta http-equiv="content-type" content="text/css; charset=UTF-8" />
	<link rel="stylesheet" type="text/css" href="css.css" />
	<meta name="description" content="株式会社イーガオ --もっともっとイイ笑顔--" />
	<meta name="keywords" content="株式会社イーガオ --もっともっとイイ笑顔--" />
	<title>eGAO 就業時間管理 ログインページ</title>
</head>

<body>
	<img src="./img/egao.png" alt="eGAOロゴ" class="TitleRogo">
	<br>
	<br>
	<br>
	<html:form action="/Login_Nomal" method="POST">
		<table>
			<tr>
				<td><bean:message key="input.empNum" />
				<td><input type="text" name="empNum"  size="15" maxlength="4" placeholder="社員番号">
			<tr>
				<td><bean:message key="input.empPass" />
				<td><input type="text" name="empPass" size="15" maxlength="15" placeholder="パスワード">
			<tr>
				<bean:write name="AMForm" property="errorMessage" /><br>
				<html:errors property="empNum"/><br>
				<html:errors property="empPass" />
			<tr>
				<td colspan="2" height="10xp">
			<tr>
				<td><html:submit value="Admin" property="Login_Admin" styleClass="button"
													onclick="form.action='Login_Admin.do';return true" />
				<td><html:submit value="Login" property="Login_Nomal" styleClass="button" />
		</table>
	</html:form>
</body>

</html:html>