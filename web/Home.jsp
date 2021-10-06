<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="my" uri="WEB-INF/tlds/mytag.tld" %>
<!DOCTYPE">
<html>
    <head>
        <title>Shop</title>
        <script type="text/javascript">
            function kt(){
                var s=document.getElementById("sl").value;
                if(isNaN(s) || s<=0)
                    return false;
                return true;
            }
        </script>
        <link href="mycss.css" rel="stylesheet" type="text/css"/>

    </head>
    <body>
        <h1>GIỎ HÀNG</h1>
        
        <my:ShowMenuTagHandler />
        <br>
        <jsp:include page="ShopCart.jsp" />
    </body>
</html>