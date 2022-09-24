<%-- 
    Document   : newjsp1
    Created on : Sep 20, 2022, 4:05:54 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Mua voucher</title>
    <link rel="icon" href="img/logo.png" type="image/x-icon" />
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" rel="stylesheet">
    <link href="css/nestf.css" rel="stylesheet">
</head>

<body class="text-center">
    <div id="navbar">
        <nav class="navbar-expand bg-light navbar-light">
            <ul class="navbar">
                <li class="nav-item col-2 d-inline-block">
                    <a href="home"><img src="img/logo.png" id="logo" class="col-3"></a>
                </li>
                <li class="nav-item col-1 d-inline-block">
                    <a href="shop" class="nav-link text-center">Shop</a>
                </li>
                <li class="nav-item col-1 d-inline-block">
                    <a href="handbook" class="nav-link text-center">Cẩm nang</a>
                </li>
                <li class="nav-item col-1 d-inline-block">
                    <a href="about" class="nav-link text-center">Về chúng tôi</a>
                </li>
                <li class="nav-item col-3 d-inline-block text-center">
                    <form action="searchAction" method="get" id="search-form">
                        <button type="submit"><i class="fas fa-search    "></i></button>
                        <input type="text" class="text-center" placeholder="Tìm kiếm" name="txtSearch" value="">
                    </form>
                </li>
                <li class="nav-item col-2 d-inline-block text-center">
                    <div><a href="account" class="nav-link text-center"><i class="fas fa-user    "></i>Tên customer</a>
                    </div>
                </li>
                <li class="nav-item col-1 d-inline-block text-center">
                    <div><a href="cart" class="nav-link text-center"><i class="fa-solid fa-cart-shopping"></i></a></div>
                </li>
                <li class="nav-item col-1 d-inline-block text-center">
                    <div><a href="voucher" class="nav-link text-center disabled">Điểm tích luỹ</a></div>
                </li>
            </ul>
        </nav>
    </div>
    <div id="white-board" class="bg-light">
        <h2 class="d-block col-8">Danh sách voucher</h2>
        <div class="row row-cols-4">
            <div id="voucher" class="d-inline-block col mb-4">
                <img src="img/voucher.png">
                <h6>TÊN VOUCHER</h6>
                <span>Số lượng còn : </span><br>
                <span>Điểm yêu cầu</span><br>
                <a href="buyVoucher"><button id="buy-button" class="col-6">Mua ngay</button></a>
            </div>
            <div id="voucher" class="d-inline-block col mb-4">
                <img src="img/voucher.png">
                <h6>TÊN VOUCHER</h6>
                <span>Số lượng còn : </span><br>
                <span>Điểm yêu cầu</span><br>
                <a href="buyVoucher"><button id="buy-button" class="col-6">Mua ngay</button></a>
            </div>
            <div id="voucher" class="d-inline-block col mb-4">
                <img src="img/voucher.png">
                <h6>TÊN VOUCHER</h6>
                <span>Số lượng còn : </span><br>
                <span>Điểm yêu cầu</span><br>
                <a href="buyVoucher"><button id="buy-button" class="col-6">Mua ngay</button></a>
            </div>
            <div id="voucher" class="d-inline-block col mb-4">
                <img src="img/voucher.png">
                <h6>TÊN VOUCHER</h6>
                <span>Số lượng còn : </span><br>
                <span>Điểm yêu cầu</span><br>
                <a href="buyVoucher"><button id="buy-button" class="col-6">Mua ngay</button></a>
            </div>
            <div id="voucher" class="d-inline-block col mb-4">
                <img src="img/voucher.png">
                <h6>TÊN VOUCHER</h6>
                <span>Số lượng còn : </span><br>
                <span>Điểm yêu cầu</span><br>
                <a href="buyVoucher"><button id="buy-button" class="col-6">Mua ngay</button></a>
            </div>
            <div id="voucher" class="d-inline-block col mb-4">
                <img src="img/voucher.png">
                <h6>TÊN VOUCHER</h6>
                <span>Số lượng còn : </span><br>
                <span>Điểm yêu cầu</span><br>
                <a href="buyVoucher"><button id="buy-button" class="col-6">Mua ngay</button></a>
            </div>
        </div>
    </div>
</body>

</html>