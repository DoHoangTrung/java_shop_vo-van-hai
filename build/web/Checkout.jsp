<%@taglib prefix="my" uri="WEB-INF/tlds/mytag.tld" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <link href="mycss.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1 align="center">THANH TOÁN</h1>
        <my:showBillTagHandler />
        <br/>
        <a href="Home.jsp">Nhấn vào đây để mua thêm hàng</a>
    </body>
</html>

