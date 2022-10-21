<%-- 
    Document   : newjsp2
    Created on : Sep 20, 2022, 3:59:58 PM
    Author     : Admin
--%>

<%@page import="com.nestf.customer.CustomerError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">
    <c:if test="${not empty sessionScope.CUSTOMER}">
        <c:redirect url=""></c:redirect>
    </c:if>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Đăng ký</title>
        <meta name="description" content="">
        <link rel="icon" href="img/logo.png" type="image/x-icon" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins">
        <link href="css/nestf.css" rel="stylesheet">
    </head>
    <body class="text-center">
        <div id="navbar" class="sticky-top">
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
                    <li class="nav-item col-3 d-inline-block">                      
                    </li>
                    <li class="nav-item col-2 d-inline-block">
                        <div ><a href="loginPage" class="nav-link"><i class="fas fa-user    "></i>Đăng nhập</a></div>
                    </li>
                    <li class="nav-item col-1 d-inline-block">                      
                    </li>
                    <li class="nav-item col-1 d-inline-block">
                    </li>
                </ul>
            </nav>
        </div>
        <div class="d-inline-block container-fluid" id="register-form">
            <img src="img/account.svg" alt="">
            <h1>Đăng ký</h1>
            <form action="registerAction" method="POST" id="reg-form">
                <div class="m-3 d-inline-block col-2">Họ và tên</div><input type="text" name="name" required minlength="6" maxlength="30" placeholder="6 - 30 ký tự"><br>
                <div class="m-3 d-inline-block col-2">Giới tính</div>          
                <div id="gender" class="d-inline-block">
                    <input type="radio" id="male" checked="" name="gender" value="1">
                    <label for="male">Nam&emsp;</label>
                    <input type="radio" id="female" name="gender" value="0">
                    <label for="female">Nữ</label>
                </div><br>
                <div class="m-3 d-inline-block col-2">Số điện thoại</div><input type="number" name="phone" required minlength="10" maxlength="11" placeholder="10 - 11 chữ số"><br>
                <div class="m-3 d-inline-block col-2">Mật khẩu</div><input type="password" name="password" required minlength="6" maxlength="20" id="password" placeholder="6 - 20 ký tự"><br>
                <div class="m-3 d-inline-block col-2">Xác nhận mật khẩu</div><input type="password" name="confirm" required minlength="6" maxlength="20" id="confirm" onblur="validate();"><br>
                <div class="d-inline-block col-2 m-3">Địa chỉ</div><input type="text" name="address" required="" minlength="20" maxlength="70" placeholder="20 - 70 ký tự"><br>
                <input type="hidden" name="point" value="0"/>
                <a href="homePage"><input type="button" value="HUỶ" id="link-button"></a>
                <input type="submit" value="ĐĂNG KÝ" id="color-button">
            </form>
        </div>
        <script src="js/nestf.js"></script>
    </body>
</html>
