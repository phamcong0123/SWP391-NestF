<%-- 
    Document   : newjsp
    Created on : Sep 20, 2022, 3:59:46 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
    <c:if test="${not empty sessionScope.CUSTOMER}">
        <c:redirect url=""></c:redirect>
    </c:if>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Đăng nhập</title>
        <link rel="icon" href="img/logo.png" type="image/x-icon" />
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href=" https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" />
        <link href="css/nestf.css" rel="stylesheet">
    </head>
    <body class="text-center">
        <div id="navbar">
            <nav class="navbar-expand bg-white navbar-light">
                <ul class="navbar">
                    <li class="nav-item col-2 d-inline-block">
                        <a href="homePage"><img src="img/logo.png" id="logo" class="col-3"></a>
                    </li>
                    <li class="nav-item col-1 d-inline-block">
                        <a href="shopPage" class="nav-link">Shop</a>
                    </li>
                    <li class="nav-item col-1 d-inline-block">
                        <a href="handbookPage" class="nav-link">Cẩm nang</a>
                    </li>
                    <li class="nav-item col-1 d-inline-block">
                        <a href="aboutPage" class="nav-link">Về chúng tôi</a>
                    </li>
                    <li class="nav-item col-7 d-inline-block">
                    </li>         
                </ul>
            </nav>
        </div>
        <div class="d-inline-block col-8" id="login-form">
            <h1>Đăng nhập</h1><br>
            <form action="loginAction" method="POST">
                <input type="text" name="customerPhone" value="${param.customerPhone}" required class="col-3" placeholder="Số điện thoại"><br>
                <input type="password" name="password" required class="col-3 mt-3" placeholder="Mật khẩu"><br>   
                <c:if test="${ not empty requestScope.ERROR}"><div class="text-center text-danger mt-2 col-5 d-inline-block">${requestScope.ERROR}</div><br></c:if>
                <a href="forgotPassword" class="nav-link col-3 d-inline-block mt-3 mb-3 text-end text-primary" id="forgetPass">Quên mật khẩu</a><br>
                <a href="registerPage"><input type="button" value="ĐĂNG KÝ" id="link-button"></a>
                <input type="submit" value="ĐĂNG NHẬP"  id="color-button">
            </form>
        </div>
        <div class="d-inline-block" id="sidepic">
            <img
                src="img/loginPic.jpg">
        </div>
    </body>
</html>
