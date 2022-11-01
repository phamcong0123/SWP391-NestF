<%-- 
    Document   : Forgot Password
    Created on : Oct 31, 2022, 3:18:50 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="SendSmsServlet" method="POST">
            <input type="text" name="phone" placeholder="Nhập số điện thoại"/>
            <input type="submit" name="action" value="Gửi"/>
        </form>
    </body>
</html>
