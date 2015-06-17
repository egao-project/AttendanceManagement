<%@page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<html:html lang="ja">
<HEAD>
<TITLE>カタログ詳細</TITLE>
</HEAD>
<BODY>
    <TABLE border="1">
        <TR>
            <TH>商品番号</TH>
            <TH>商品名</TH>
            <TH>価格</TH>
        </TR>
        <TR>
            <TD><bean:write name="product" property="id" /></TD>
            <TD><bean:write name="product" property="name" /></TD>
            <TD><bean:write name="product" property="price" /></TD>
        </TR>
        <TR>
            <!-- bean:define タグと html:image タグの組み合わせ -->
            <bean:define id="url">
                <bean:write name="product" property="pictureUrl" />
            </bean:define>

            <TD colspan="3"><html:img page="<%=url%>" /></TD>
        </TR>
    </TABLE>
    <A href="http://localhost:8080/CatalogSample/Catalog.do">戻る</A>
</BODY>
</html:html>
