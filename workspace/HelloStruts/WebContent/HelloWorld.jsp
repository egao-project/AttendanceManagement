<%@page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<html:html lang="ja">
   <body>
         <bean:message key="welcome" />
         <bean:write name="HelloWorldForm" property="name" /> さん
   </body>
</html:html>
