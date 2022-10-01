<%-- 
    Document   : newjsp1
    Created on : Sep 20, 2022, 4:05:54 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">

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
            <nav class="navbar-expand bg-white navbar-light">
                <ul class="navbar">
                    <li class="nav-item col-2 d-inline-block">
                        <a href="homePage"><img src="img/logo.png" id="logo" class="col-3"></a>
                    </li>
                    <li class="nav-item col-1 d-inline-block">
                        <a href="shopPage" class="nav-link text-center">Shop</a>
                    </li>
                    <li class="nav-item col-1 d-inline-block">
                        <a href="handbookPage" class="nav-link text-center">Cẩm nang</a>
                    </li>
                    <li class="nav-item col-1 d-inline-block">
                        <a href="aboutPage" class="nav-link text-center">Về chúng tôi</a>
                    </li>
                    <li class="nav-item col-3 d-inline-block text-center">
                        <form action="searchAction" method="get" id="search-form">
                            <button type="submit" class="border-0 bg-transparent"><i class="fas fa-search    "></i></button>
                            <input type="text" class="text-center" placeholder="Tìm kiếm" name="txtSearch" value="">
                        </form>
                    </li>
                    <li class="nav-item col-2 d-inline-block text-center">                      
                        <div id="dropDownMenu" class="d-inline-block position-relative">
                            <i class="fas fa-user me-2"></i>${sessionScope.CUSTOMER.customerName}
                            <div id="dropDownContent" class="d-none bg-white text-start position-absolute shadow">
                                <a href="accountPage" class="nav-link mb-2 text-decoration-none p-2" id="item">Cài đặt tài khoản</a>
                                <a href="logOut" class="nav-link text-decoration-none p-2" id="item">Đăng xuất</a>
                            </div>
                        </div>

                    </li>
                    <li class="nav-item col-1 d-inline-block text-center">
                        <div><a href="cartPage" class="nav-link text-center"><i class="fa-solid fa-cart-shopping"></i></a></div>
                    </li>
                    <li class="nav-item col-1 d-inline-block text-center">
                        <div><a href="voucherPage" class="nav-link text-center current-tab disabled">${sessionScope.CUSTOMER.point} CP</a></div>
                    </li>
                </ul>
            </nav>
        </div>
        <div id="white-board" class="bg-white">
            <h2 class="d-block col-8">Danh sách voucher</h2>
            <div class="row row-cols-4 col-11 m-auto">
                <div id="item" class="d-inline-block col mb-4">
                    <img src="img/voucher.png">
                    <h6 class="mt-4">TÊN VOUCHER</h6>
                    <span>Số lượng còn : <span class="fw-bold">100</span></span><br>
                    <span>Điểm yêu cầu : <span class="fw-bold">100</span></span><br>
                    <a href="buyVoucher"><button id="buy-button" class="col-6">Mua ngay</button></a>
                </div>
                <div id="item" class="d-inline-block col mb-4">
                    <img src="img/voucher.png">
                    <h6 class="mt-4">TÊN VOUCHER</h6>
                    <span>Số lượng còn : <span class="fw-bold">100</span></span><br>
                    <span>Điểm yêu cầu : <span class="fw-bold">100</span></span><br>
                    <a href="buyVoucher"><button id="buy-button" class="col-6">Mua ngay</button></a>
                </div>
                <div id="item" class="d-inline-block col mb-4">
                    <img src="img/voucher.png">
                    <h6 class="mt-4">TÊN VOUCHER</h6>
                    <span>Số lượng còn : <span class="fw-bold">100</span></span><br>
                    <span>Điểm yêu cầu : <span class="fw-bold">100</span></span><br>
                    <a href="buyVoucher"><button id="buy-button" class="col-6">Mua ngay</button></a>
                </div>
                <div id="item" class="d-inline-block col mb-4">
                    <img src="img/voucher.png">
                    <h6 class="mt-4">TÊN VOUCHER</h6>
                    <span>Số lượng còn : <span class="fw-bold">100</span></span><br>
                    <span>Điểm yêu cầu : <span class="fw-bold">100</span></span><br>
                    <a href="buyVoucher"><button id="buy-button" class="col-6">Mua ngay</button></a>
                </div>
                <div id="item" class="d-inline-block col mb-4">
                    <img src="img/voucher.png">
                    <h6 class="mt-4">TÊN VOUCHER</h6>
                    <span>Số lượng còn : <span class="fw-bold">100</span></span><br>
                    <span>Điểm yêu cầu : <span class="fw-bold">100</span></span><br>
                    <a href="buyVoucher"><button id="buy-button" class="col-6">Mua ngay</button></a>
                </div>

            </div>
        </div>
    </body>

</html>