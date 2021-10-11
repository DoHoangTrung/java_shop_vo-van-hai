<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="my" uri="WEB-INF/tlds/mytag.tld" %>
<!DOCTYPE">
<html>
    <head>
        <title>Shop</title>
        <script type="text/javascript">
            function kt() {
                var s = document.getElementById("sl").value;
                if (isNaN(s) || s <= 0)
                    return false;
                return true;
            }
        </script>
        <script src="jquery-3.5.1.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <link href="mycss.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>CỬA HÀNG</h1>

        <my:ShowMenu/>
        <br>
        <jsp:include page="ShopCart.jsp" />

        <script>
            $(document).ready(() => {
                $(".muaButton").bind("click", (event) => {
                    var id = event.target.getAttribute("data-id");
                    var soluong = $("#soLuong" + id).val();
                    if (soluong > 0) {
                        var data = {action: "muahang",
                            monhang: id,
                            soluong: soluong};

                        $.post("ControllerServlet", data, function (res) {
                            location.reload()
                        })
                    }
                })
            })
        </script>
    </body>
</html>