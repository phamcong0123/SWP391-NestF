<%-- 
    Document   : newjsp2
    Created on : Sep 20, 2022, 3:59:58 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Đăng ký</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins">
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
                    <li class="nav-item col-3 d-inline-block text-center">                      
                    </li>
                    <li class="nav-item col-2 d-inline-block text-center">
                        <div ><a href="login" class="nav-link"><i class="fas fa-user    "></i>Đăng nhập</a></div>
                    </li>
                    <li class="nav-item col-1 d-inline-block text-center">                      
                    </li>
                    <li class="nav-item col-1 d-inline-block text-center">
                    </li>
                </ul>
            </nav>
        </div>
        <div class="d-inline-block container-fluid text-center" id="register-form">
            <img src="img/account.svg" alt="">
            <h1>Đăng ký</h1>
            <form action="registerAction" method="post">
                <div class="m-3 d-inline-block col-2">Họ và tên</div><input type="text" name="customerName"><br>
                <div class="m-3 d-inline-block col-2">Giới tính</div>          
                <div id="gender">
                    <input type="radio" id="male" name="gender" value="1">
                    <label for="male">Nam&emsp;</label>
                    <input type="radio" id="female" name="gender" value="0">
                    <label for="female">Nữ</label>
                </div><br>
                <div class="m-3 d-inline-block col-2">Số điện thoại</div><input type="text" name="customerPhone"><br>
                <div class="m-3 d-inline-block col-2">Mật khẩu</div><input type="text" name="password"><br>
                <div class="m-3 d-inline-block col-2">Xác nhận mật khẩu</div><input type="text" name="confirm"><br>
                <div class="d-inline-block col-2">Địa chỉ</div><input type="text" name="customerAddress"><br>
                <a href="home"><input type="button" value="HUỶ" id="link-button"></a>
                <input type="submit" value="ĐĂNG KÝ" id="color-button">
            </form>
        </div>
    </body>
</html>
