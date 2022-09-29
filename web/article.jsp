<%-- 
    Document   : article
    Created on : Sep 23, 2022, 3:43:02 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <link rel="icon" href="img/logo.png" type="image/x-icon" />
        <title>Title bài viết</title>
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
        <div id="white-board" class="d-flex justify-content-between">
            <div class="bg-light col-8 mt-4 d-inline-block" id="article">  
                <h2 class="pt-4">Title bài viết</h2>
                <div id="author">           
                </div>
                <div id="content" class="pb-2 pe-4">            
                    <c:import charEncoding="UTF-8" url="postHTML/post5.html"></c:import>
                </div>
            </div>
            <div id="other-article" class="bg-light d-inline-block mt-4 h-100 sticky-top">
                <h2 class="text-center">Bài viết khác</h2>
                <a href="article" class="nav-link" id="article-link">
                    <div class="m-3 d-flex justify-content-start">
                        <img src="img/post1.jpg" class="d-inline-block col-6">
                        <div class="d-inline-block text-start ms-2">
                            <h5>Title</h5>
                            <span>Nội dung...</span>
                        </div>            
                    </div>
                </a>
                <a href="article" class="nav-link" id="article-link">
                    <div class="m-3 d-flex justify-content-start">
                        <img src="img/post1.jpg" class="d-inline-block col-6">
                        <div class="d-inline-block text-start ms-2">
                            <h5>Title</h5>
                            <span>Nội dung...</span>
                        </div>            
                    </div>
                </a>
                <a href="article" class="nav-link" id="article-link">
                    <div class="m-3 d-flex justify-content-start">
                        <img src="img/post1.jpg" class="d-inline-block col-6">
                        <div class="d-inline-block text-start ms-2">
                            <h5>Title</h5>
                            <span>Nội dung...</span>
                        </div>            
                    </div>
                </a>
            </div>
        </div>
        <div id="white-board" class="bg-light">
            <h4 class="text-start p-4">Các gợi ý khác</h4>
            <div class="row row-cols-4">
                <div id="voucher" class="d-inline-block col mb-4">
                    <img src="img/voucher.png">
                    <h6>TÊN VOUCHER</h6>
                    <span>Giá sản phẩm</span><br>
                    <a href="buyVoucher"><button id="buy-button" class="col-6">Mua ngay</button></a>
                </div>
                <div id="voucher" class="d-inline-block col mb-4">
                    <img src="img/voucher.png">
                    <h6>TÊN VOUCHER</h6>
                    <span>Giá sản phẩm</span><br>
                    <a href="buyVoucher"><button id="buy-button" class="col-6">Mua ngay</button></a>
                </div>
                <div id="voucher" class="d-inline-block col mb-4">
                    <img src="img/voucher.png">
                    <h6>TÊN VOUCHER</h6>
                    <span>Giá sản phẩm</span><br>
                    <a href="buyVoucher"><button id="buy-button" class="col-6">Mua ngay</button></a>
                </div>
                <div id="voucher" class="d-inline-block col mb-4">
                    <img src="img/voucher.png">
                    <h6>TÊN VOUCHER</h6>
                    <span>Giá sản phẩm</span><br>
                    <a href="buyVoucher"><button id="buy-button" class="col-6">Mua ngay</button></a>
                </div>           
            </div>
        </div>
    </body>

</html>
