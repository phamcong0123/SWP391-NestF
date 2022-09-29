<%-- 
    Document   : newjsp1
    Created on : Sep 20, 2022, 4:05:11 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cài đặt tài khoản</title>
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
                    <li class="nav-item col-3 d-inline-block text-center">
                        <form action="searchAction" method="get" id="search-form">
                            <button type="submit"><i class="fas fa-search    "></i></button>
                            <input type="text" class="text-center" placeholder="Tìm kiếm" name="txtSearch" value="">
                        </form>
                    </li>
                    <li class="nav-item col-2 d-inline-block text-center">
                        <div>
                            <c:if test="${not empty sessionScope.CUSTOMER}">
                                <a href="accountPage" class="nav-link text-center"><i class="fas fa-user    "></i>${sessionScope.CUSTOMER.customerName}</a>
                            </c:if>
                            <c:if test="${empty sessionScope.CUSTOMER}"><a href="loginPage" class="nav-link"><i class="fas fa-user    "></i>Đăng nhập</a>
                            </c:if>
                        </div>
                    </li>
                    <li class="nav-item col-1 d-inline-block text-center">
                        <div> 
                            <c:if test="${not empty sessionScope.CUSTOMER}">
                                <a href="cartPage" class="nav-link text-center"><i class="fa-solid fa-cart-shopping"></i></a></div>
                                </c:if>                              
                    </li>
                    <li class="nav-item col-1 d-inline-block text-center">
                        <div>
                            <c:if test="${not empty sessionScope.CUSTOMER}">
                                <a href="voucherPage" class="nav-link text-center">${sessionScope.CUSTOMER.point} CP</a>
                                </c:if>
                        </div>
                    </li>
                </ul>
            </nav>
        </div>
        <div id="white-board" class="bg-light">
            <div class="row container-fluid m-0">
                <div class="d-inline-block col-5 mt-3">
                    <img src="img/product1.png" class="rounded col-11">
                </div>     
                <div class="d-inline-block col-7">
                    <h2 class="text-center">Tổ yến thô cao cấp tiêu chuẩn 100g</h2>
                    <span>2,850,000 ₫</span>
                    <c:import charEncoding="UTF-8" url="productHTML/product1.html"></c:import>
                </div>             
            </div>
            <div id="number-toggle" class="text-center col-7">
                <div class="input-group d-inline-block">
                    <form>
                        <img src="img/plus.svg" data-field="quantity" class="button-plus d-inline-block">
                        <input required id="number-input" type="number" step="1" value="1" min="1" max="100" onblur="minCheck(this), maxCheck(this)" name="quantity" class="quantity-field text-center p-0">
                        <img src="img/minus.svg" data-field="quantity" class="button-minus d-inline-block"><br>
                        <button type="submit" id="buy-button" class="col-3 me-2" value="buynow">Mua ngay</button>
                        <button type="submit" id="buy-button" class="col-3 ms-2 bg-light text-black border border-dark rounded"><img src="img/cart.svg" class="me-2">Thêm vào giỏ</button>
                    </form>

                </div>
            </div>
            <br>
            <div class="container-fluid">
                Mô tả chi tiết sp
            </div>
        </div>
        <div id="white-board" class="bg-light">
            <h4 class="text-start p-4">Các gợi ý khác</h4>
            <div class="row row-cols-4">
                <div id="voucher" class="d-inline-block col mb-4">
                    <img src="img/voucher.png">
                    <h6>TÊN VOUCHER</h6>
                    <span>Tên sản phẩm : </span><br>
                    <span>Giá sản phẩm</span><br>
                    <a href="buyVoucher"><button id="buy-button" class="col-6">Mua ngay</button></a>
                </div>
                <div id="voucher" class="d-inline-block col mb-4">
                    <img src="img/voucher.png">
                    <h6>TÊN VOUCHER</h6>
                    <span>Tên sản phẩm : </span><br>
                    <span>Giá sản phẩm</span><br>
                    <a href="buyVoucher"><button id="buy-button" class="col-6">Mua ngay</button></a>
                </div>
                <div id="voucher" class="d-inline-block col mb-4">
                    <img src="img/voucher.png">
                    <h6>TÊN VOUCHER</h6>
                    <span>Tên sản phẩm : </span><br>
                    <span>Giá sản phẩm</span><br>
                    <a href="buyVoucher"><button id="buy-button" class="col-6">Mua ngay</button></a>
                </div>
                <div id="voucher" class="d-inline-block col mb-4">
                    <img src="img/voucher.png">
                    <h6>TÊN VOUCHER</h6>
                    <span>Tên sản phẩm : </span><br>
                    <span>Giá sản phẩm</span><br>
                    <a href="buyVoucher"><button id="buy-button" class="col-6">Mua ngay</button></a>
                </div>           
            </div>
            <a href="" class="nav-link pb-3">Tất cả sản phẩm</a>
        </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script src="js/productDetail.js"></script>   
</body>
</html>