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

<body>
	<div>
		<html:form action="/EmployeeAdd" method="POST">
		<table>
			<tr><td colspan="2"><img src="./img/egao.png" alt="eGAOロゴ">
			<tr><td colspan="2" class="Empty">
			<tr><td colspan="2" class="Name"><bean:message key="admin_page" />
			<tr><td colspan="2" class="Empty">
			<tr><td class="Right"><bean:message key="input.empNum" />
				<td class="Left"><input type="text" name="empNum" maxlength="4" placeholder="社員番号">
			<tr><td class="Right"><bean:message key="input.empName" />
				<td class="Left"><input type="text" name="empName" maxlength="10" placeholder="名前">
			<tr><td class="Right"><bean:message key="input.empPass" />
				<td class="Left"><input type="text" name="empPass" maxlength="15" placeholder="パスワード">
			<tr><td colspan="2" class="Empty">
			<tr><td class="Right"><html:submit value="Submit" property="EmployeeAdd" styleClass="button" />
				<td class="Left"><html:submit value="Delete" property="EmployeeDel" styleClass="button"
									onclick="form.action='EmployeeDel.do';return true" />
			<tr><td colspan="2"><html:button value="戻る" property="Back" styleClass="button" onclick="location.href='./Back.do'" />
			<tr><td colspan="2"><bean:write name="AMForm" property="message" />
								<div class="message"><bean:write name="AMForm" property="errorMessage" /><br>
												<html:errors property="empNum" /><br>
												<html:errors property="empName" /><br>
												<html:errors property="empPass" /></div>
		</table>
		</html:form>
	</div>
</body>

</html:html>