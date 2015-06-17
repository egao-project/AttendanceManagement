<%@page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html:html lang="ja">
<!-- Beanが存在する場合の処理 -->
<logic:present name="isCancel">
    <bean:message key="cancel" />
</logic:present>
<body>
    <table border="1">
        <tr>
            <th>name</th>
            <td><bean:write name="VariousInputForm" property="name" /></td>
        </tr>
        <tr>
            <th>password</th>
            <td><bean:write name="VariousInputForm" property="password" /></td>
        </tr>
        <tr>
            <th>etc</th>
            <td><bean:write name="VariousInputForm" property="etc" /></td>
        </tr>
        <tr>
            <th>check1</th>
            <td><bean:write name="VariousInputForm" property="check1" /></td>
        </tr>
        <tr>
            <th>check2</th>
            <td><bean:write name="VariousInputForm" property="check2" /></td>
        </tr>
        <tr>
            <th>multi1(複数選択可能)NG表示</th>
            <td><bean:write name="VariousInputForm" property="multi1" /></td>
        </tr>
        <tr>
            <th>multi1(複数選択可能)OK表示</th>
            <!-- 配列を表示する方法 -->
            <td><logic:iterate id="seleach" name="VariousInputForm"    property="multi1">
                <bean:write name="seleach" />
            </logic:iterate></td>
        </tr>
        <tr>
            <th>radio1</th>
            <td><bean:write name="VariousInputForm" property="radio1" /></td>
        </tr>
        <tr>
            <th>select1</th>
            <td><bean:write name="VariousInputForm" property="select1" /></td>
        </tr>
        <tr>
            <th>select2(複数選択可能)NG表示</th>
            <td><bean:write name="VariousInputForm" property="select2" /></td>
        </tr>
        <tr>
            <th>select2(複数選択可能)OK表示</th>
            <!-- 配列を表示する方法 -->
            <td><logic:iterate id="seleach" name="VariousInputForm" property="select2">
                <bean:write name="seleach" />
            </logic:iterate></td>
        </tr>
        <tr>
            <th>hiddenタグの値</th>
            <td><bean:write name="VariousInputForm" property="hidden1" /></td>
        </tr>
    </table>
</body>
</html:html>
