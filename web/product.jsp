<%-- 
    Document   : newjsp1
    Created on : Sep 20, 2022, 4:05:11 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cài đặt tài khoản</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" rel="stylesheet">
        <link href="css/nestf.css" rel="stylesheet">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
                integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
                integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
    </head>

    <body class="text-center">
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
                        <form action="searchAction" method="get" id="search-form">
                            <button type="submit"><i class="fas fa-search    "></i></button>
                            <input type="text" class="text-center" placeholder="Tìm kiếm" name="txtSearch" value="">
                        </form>
                    </li>
                    <li class="nav-item col-2 d-inline-block text-center">
                        <div><a href="account" class="nav-link"><i class="fas fa-user    "></i>Tên customer</a></div>
                    </li>
                    <li class="nav-item col-1 d-inline-block text-center">
                        <div><a href="cart" class="nav-link"><i class="fa-solid fa-cart-shopping"></i></a></div>
                    </li>
                    <li class="nav-item col-1 d-inline-block text-center">
                        <div><a href="voucher" class="nav-link">Điểm tích luỹ</a></div>
                    </li>
                </ul>
            </nav>
        </div>
        <div id="white-board" class="bg-light">
            <div class="d-flex justify-content-between">
                <div class="d-inline-block col-4 m-4">
                    <img src="img/product1.png" class="rounded col-12">
                </div>     
                <div class="d-inline-block col-7">
                    <h2 class="m-4 text-center">Tổ yến thô cao cấp tiêu chuẩn 100g</h2>
                    <span>2,850,000 ₫</span>
                    <c:import charEncoding="UTF-8" url="productHTML/product1.html"></c:import>
                </div>
            </div>
                <br>
            <div class="container-fluid">
                Mô tả chi tiết sp
            </div>
        </div>
    </div>
</body>
</html>