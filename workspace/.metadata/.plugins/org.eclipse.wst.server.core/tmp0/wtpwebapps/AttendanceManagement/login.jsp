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
	<title>eGAO 就業時間管理 ログインページ</title>
</head>

<body id="body">
	<script type="text/javascript">
    	function nextFocus(elm, max) {
        	var next_elm = eval(elm+1);
        	if (document.zip.elements[elm].value.length >= max) {
            	/* テキストボックスにmaxlength文字入力されていたら */
            	/* 次のテキストボックスへ移動 */
            	document.zip.elements[next_elm].focus();
        	}
    	}
    	function movePage(path){
    		document.frm.action = path + ".do";
    		document.frm.submit();
    	}
	</script>
	<img src="./img/egao.png" alt="eGAOロゴ" id="rogo">
	<br>
	<br>
	<br>
	<div>
		<table id="table">
			<tr>
				<td>社 員 番 号：
				<td><input type="text" name="empNum" onkeyup="nextFocus(0,maxLength)"
						size="15" maxlength="3" placeholder="010">
			<tr>
				<td>パスワード ：
				<td><input type="text" name="empPass" onkeyup="nextFocus(1,maxLength)"
						size="15" maxlength="15" placeholder="0a1b2c3d4e">
			<tr>
				<td colspan="2">エラーメッセージ
			<tr>
				<td colspan="2" height="10xp">
			<tr>
				<td><html:button value="Login" property="Login_Nomal" onclick="movePage(Login_Nomal)" styleId="button" />
				<td><html:button value="Admin" property="Login_Admin" onclick="movePage(Login_Admin)" styleId="button" />
		</table>
	</div>
</body>

</html>