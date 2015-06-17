<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
						"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>足し算</title>
</head>
<body>
    <%!
        private int atoi(String str) {
            int ret = 0;
            try {
                ret = Integer.parseInt(str);
            } catch (Exception ex) {
                /* 変換できないときは０とみなす */
            }
            return (ret);
        }
        private int add(int i1, int i2) {
            return (i1 + i2);
        }
    %>
    <%
        String param1 = request.getParameter("param1");
        String param2 = request.getParameter("param2");
        if (param1 != null && param2 != null) {
            int i1 = atoi(param1);
            int i2 = atoi(param2);
    %>
    <h2>
        <%=i1%> + <%=i2%> = <%=add(i1, i2)%>
    </h2>
    <%
        }
    %>
    <form action="add.jsp">
        <input type="text" name="param1" size=6> +
        <input type="text" name="param2" size=6>
        <input type="submit" value="=">
    </form>
</body>
</html>
