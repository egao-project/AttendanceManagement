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
	<title>eGAO 就業時間管理 メインページ</title>
</head>

<body>
	<script type="text/javascript">
		function goServletB(){
		document.getElementById('form').action = '/LastTime';
		}
		function goServletC(){
		document.getElementById('form').action = '/output';
		}
	</script>

	<img src="./img/egao.png" alt="eGAOロゴ" id="rogo">
	<br>
	<br>
	<form id="form" name="form" action="/StartTime">
	<div>
		<table id="table_main">
			<caption>滝本博昭 さん</caption>
			<tr>
				<td><html:submit value="出 勤" property="StartTime" styleClass="button_work" />
				<td width="50px">
				<td><html:submit value="退 勤" property="LastTime" onclick="goServletB();" styleClass="button_work" />
			<tr>
				<td colspan="3" height="10xp">
			<tr>
				<td>8:45
				<td colspan="2" >本日もお願いします！
			<tr>
				<td colspan="3" >
			<tr>
				<td colspan="2">
				<td><input type="text" name="year"  size="1" maxlength="4" placeholder="2015">年
					<input type="text" name="month" size="1" maxlength="2" placeholder="6">月
			<tr>
				<td><html:button value="戻る"  property="back" onclick="location.href='./login.jsp'" styleId="button" styleClass="button" />
				<td width="50px">
				<td><html:submit value="Output" property="output" onclick="goServletC();" styleClass="button" />
		</table>
	</div></form>
</body>
</html:html>