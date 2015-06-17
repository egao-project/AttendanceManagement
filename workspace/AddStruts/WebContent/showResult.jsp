<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>足し算</title>
</head>
<body>
    <H2>
        <bean:write name="QueryForm" property="parm1" scope="request" />
        +
        <bean:write name="QueryForm" property="parm2" scope="request" />
        =
        <bean:write name="QueryForm" property="result" scope="request" />
    </H2>
    <jsp:include page="queryForm.jsp" flush="true" />
</body>
</html>
