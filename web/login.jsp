<%-- 
    Document   : newjsp
    Created on : Sep 20, 2022, 3:59:46 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Đăng nhập</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href=" https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" />
        <link href="css/nestf.css" rel="stylesheet">
    </head>
    <body>
        <div id="navbar">
            <nav class="navbar-expand bg-light navbar-light">
                <ul class="navbar">
                    <li class="nav-item col-2 d-inline-block">
                        <a href="home"><img src="img/logo.png" id="logo" class="col-3"></a>
                    </li>
                    <li class="nav-item col-1 d-inline-block">
                        <a href="shop" class="nav-link">Shop</a>
                    </li>
                    <li class="nav-item col-1 d-inline-block">
                        <a href="handbook" class="nav-link">Cẩm nang</a>
                    </li>
                    <li class="nav-item col-1 d-inline-block">
                        <a href="about" class="nav-link">Về chúng tôi</a>
                    </li>
                    <li class="nav-item col-7 d-inline-block text-center">
                    </li>         
                </ul>
            </nav>
        </div>
        <div class="d-inline-block col-8" id="login-form">
            <h1 class="text-center">Đăng nhập</h1><br>
            <form action="loginAction" method="post">
                <div class="m-3 d-inline-block col-2">Số điện thoại</div><input type="text" name="customerPhone" class="col-3"><br>
                <div class="m-3 d-inline-block col-2">Mật khẩu</div><input type="text"name="password" class="col-3"><br>   
                <c:if test=""></c:if>
                <a href="forgotPassword" class="nav-link col-5 d-inline-block " id="forgetPass">Quên mật khẩu</a><br>
                <a href="register"><input type="button" value="ĐĂNG KÝ" id="link-button"></a>
                <input type="submit" value="ĐĂNG NHẬP" id="color-button">
            </form>
        </div>
        <div class="d-inline-block" id="sidepic">
            <img
                src="img/loginPic.jpg">
        </div>
    </body>
</html>