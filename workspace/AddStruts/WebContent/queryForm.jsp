<%@page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<html:form action="/add" focus="parm1">
  <html:text property="parm1" size="6"/>+
  <html:text property="parm2" size="6"/>
  <html:submit property="submit" value="="/>
</html:form>
