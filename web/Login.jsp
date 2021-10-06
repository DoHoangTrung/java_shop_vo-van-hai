
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trang dang nhap</title>
    </head>
    <body>
        <form method="post" action="login">
            <table>
                <tr>
                    <td>
                        <label for="username">Tên đăng nhập</label>
                    </td>
                    <td>
                        <input type="text" name="username" id="username" placeholder="">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="password">Mật khẩu</label>
                    </td>
                    <td>
                        <input type="password" name="password" id="password" placeholder="">
                    </td>
                </tr>
            </table>
            <input type="submit" value="Đăng nhập">
        </form>
    </body>
</html>
