<%@page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<html:html lang="ja">
<!-- 複数のFormやアクションからなるのでリクエストパラメータから取り出す -->
<bean:parameter id="result" name="age" />
<BODY>
    <H1>値の検証</H1>
    あなたの年齢は
    <bean:write name="result" />
    です。
</BODY>
</html:html>
