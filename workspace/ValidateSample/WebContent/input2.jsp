<%@page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html:html lang="ja">
<BODY>
    <H1>値の検証</H1>
    <!-- html:errorsタグの利用　-->
    <html:errors />
    年齢を入力してください（0以上200以下の整数）
    <html:form action="/CheckAge2">
        年齢<html:text property="age" />
        <!-- html:errorsタグの利用　-->
        <html:errors property="age" />
        <html:submit value="報告" />
    </html:form>
</BODY>
</html:html>
