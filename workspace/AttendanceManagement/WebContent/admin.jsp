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
<title>eGAO 就業時間管理 管理ページ</title>

</head>

<body id="body">
	<img src="./img/egao.png" alt="eGAOロゴ" id="rogo">
	<br>
	<br>
	<br>
	<div>
		<html:form action="/EmployeeAdd" method="POST">
			<table id="table_1">
				<caption>管理ページ</caption>
				<tr>
					<td colspan="2" height="10xp">
				<tr>
					<td>社 員 番 号：
					<td><input type="text" name="empNum" maxlength="4" placeholder="社員番号">
				<tr>
					<td colspan="2" height="5xp">
				<tr>
					<td>名 前：
					<td><input type="text" name="empName" maxlength="10" placeholder="名前">
				<tr>
					<td colspan="2" height="5xp">
				<tr>
					<td>パスワード ：
					<td><input type="text" name="empPass" maxlength="10" placeholder="パスワード">
			</table>

				<bean:write name="AMForm" property="message" /><bean:write name="AMForm" property="errorMessage" /><br>
				<html:errors property="empNum" /><br>
				<html:errors property="empName" /><br>
				<html:errors property="empPass" />

			<table id="table">
				<tr>
					<td><html:submit value="Submit" property="EmployeeAdd" styleClass="button" />
					<td width="50px">
					<td><html:submit value="Delete" property="EmployeeDel" styleClass="button"
							onclick="form.action='EmployeeDel.do';return true" />
				<tr>
					<td colspan="3" height="10xp">
				<tr>
					<td width="50px">
					<td><html:button value="戻る" property="back" styleClass="button"
							onclick="location.href='./login.jsp'" />
			</table>
		</html:form>
	</div>
</body>
</html:html>