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
	<div>
		<html:form action="/Login_Nomal" method="POST">
		<table>
			<tr><td colspan="2"><img src="./img/egao.png" alt="eGAOロゴ">
			<tr><td colspan="2" class="Empty">
			<tr><td class="Right"><bean:message key="input.empNum" />
				<td class="Left"><input type="text" name="empNum"  size="15" placeholder="社員番号">
			<tr><td class="Right"><bean:message key="input.empPass" />
				<td class="Left"><input type="text" name="empPass" size="15" placeholder="パスワード">
			<tr><td colspan="2" class="Empty">
			<tr><td class="Right"><html:submit value="Admin" property="Login_Admin" styleClass="button"
									onclick="form.action='Login_Admin.do';return true" />
				<td class="Left"><html:submit value="Login" property="Login_Nomal" styleClass="button" />
			<tr><td colspan="2" class="message">
					<bean:write name="AMForm" property="errorMessage" /><br>
					<html:errors property="empNum"/><br>
					<html:errors property="empPass" />
		</table>
		</html:form>
	</div>
</body>

</html:html>