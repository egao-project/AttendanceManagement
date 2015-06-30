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
	<div>
		<table>
			<tr><td colspan="2"><img src="./img/egao.png" alt="eGAOロゴ">
			<tr><td colspan="2" class="Empty">
			<tr><td colspan="2" class="Name"><bean:write name="AMForm" property="empName" />さん
			<tr><td class="Right"><html:button value="出 勤" property="StartTime" styleClass="button_work"  onclick="location.href='./StartTime.do'"/>
				<td class="Left"><html:button value="退 勤" property="LastTime"  styleClass="button_work"  onclick="location.href='./LastTime.do'"/>
			<tr><td colspan="2" class="Empty">
			<html:form action="/output">
			<tr><td colspan="2"><input type="text" name="output_year"  size="4" maxlength="4" placeholder="2015">年
								<input type="text" name="output_month" size="2" maxlength="2" placeholder="6">月
			<tr><td colspan="2" ><html:submit value="Output" styleClass="button" />
			<tr><td colspan="2" >
					<html:button value="戻る" property="Back" styleClass="button" onclick="location.href='./Back.do'" /></html:form>
			<tr><td colspan="2"><bean:write name="AMForm" property="message" />
					<div class="message"><bean:write name="AMForm" property="errorMessage" /><br>
										<html:errors property="output_year"/><br>
										<html:errors property="output_month"/></div>
		</table>
	</div>
</body>

</html:html>