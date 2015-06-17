<%@page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

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
		<table id="table_1">
			<caption>管理ページ</caption>
			<tr>
				<td colspan="2" height="10xp">
			<tr>
				<td>社 員 番 号：
				<td><input type="text" name="EmployeeNumber" maxlength="3" placeholder="010">
			<tr>
				<td colspan="2" height="5xp">
			<tr>
				<td>名 前：
				<td><input type="text" name="EmployeeName" maxlength="10" placeholder="滝本博昭">
			<tr>
				<td colspan="2" height="5xp">
			<tr>
				<td>パスワード ：
				<td><input type="text" name="EmployeePassWord" maxlength="10" placeholder="0a1b2c3d4e">
		</table>
		<br>
		<br>
		<table id="table">
			<tr>
				<td><html:button value="Submit" property="EmployeeAdd" onclick="movePage(EmployeeAdd)" styleId="button" />
				<td width="50px">
				<td><html:button value="Delete" property="EmployeeDel" onclick="movePage(EmployeeDel)" styleId="button" />
			<tr>
				<td colspan="3" height="10xp">
			<tr>
				<td width="50px">
				<td><html:button value="戻る"  property="back" onclick="location.href='./login.jsp'" styleId="button" />
		</table>
	</div>
</body>
</html>