<%-- 
    Document   : newjsp
    Created on : Sep 20, 2022, 4:05:49 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Nest F</title>
        <link rel="stylesheet" href="css/styleproduct.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
        <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
        crossorigin="anonymous"></script>
        <link rel="icon" type="image/x-icon" href="img/logo.png">
        <link rel="stylesheet" type="text/css"
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
        <link rel="stylesheet"
              href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    </head>
    <body>
        <section>
            <div id="navbar" class="sticky-top">
                <nav class="navbar-expand bg-white navbar-light text-center">
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
                            <c:if test="${not empty sessionScope.CUSTOMER}">
                                <div id="dropDownMenu" class="d-inline-block position-relative">
                                    <i class="fas fa-user me-2"></i>${sessionScope.CUSTOMER.customerName}
                                    <div id="dropDownContent" class="d-none bg-white text-start position-absolute shadow">
                                        <a href="accountPage" class="nav-link mb-2 text-decoration-none p-2" id="item">Cài đặt tài khoản</a>
                                        <a href="logOut" class="nav-link text-decoration-none p-2" id="item">Đăng xuất</a>
                                    </div>
                                </div>
                            </c:if>
                            <c:if test="${empty sessionScope.CUSTOMER}"><div><a href="loginPage" class="nav-link"><i class="fas fa-user    "></i>Đăng nhập</a></div>
                            </c:if>
                        </li>
                        <li class="nav-item col-1 d-inline-block text-center">
                            <div> 
                                <c:if test="${not empty sessionScope.CUSTOMER}">
                                    <a href="cartPage" class="nav-link text-center"><i class="fa-solid fa-cart-shopping position-relative">
                                            <c:if test="${not empty sessionScope.CART}">
                                                <span class="position-absolute top-0 start-100 translate-middle p-1 bg-danger border border-light rounded-circle">
                                                    <span class="visually-hidden">New alerts</span>
                                                </span>
                                            </c:if>
                                        </i>
                                    </a>
                                </c:if> 
                            </div>                                                    
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
            <div class="container shop-container">
                <div class="search-product-content bg-white">
                    <jsp:useBean id="productFunc" class="com.nestf.product.ProductDTO"/>
                    <c:if test="${requestScope.SEARCH_LIST != null}">
                        <c:if test="${not empty requestScope.SEARCH_LIST}">
                            <div class="search-header">
                                <h4 class="search-result-title">Kết quả tìm kiếm cho: <span class="search-result">${param.txtSearch}</span></h4>
                                <div class="search-content">
                                    <div class="row col-11 m-auto">
                                        <c:forEach var="product" items="${requestScope.SEARCH_LIST}">
                                            <c:if test="${product.status}">
                                                <div class="col-lg-3 col-md-4 product-contain-detail">
                                                    <div class="product-image-contain-detail">
                                                        <a href="productDetail?productID=${product.productID}" class="product-detail">
                                                            <img class="img-responsive"
                                                                 src="${product.image}"
                                                                 width="200px" height="200px" alt="..." class="mx-2">
                                                            <p class="image-title">${product.name}<br>
                                                                <c:if test="${product.discountPrice != 0}">
                                                                    <span
                                                                        class="image-price-discout">${productFunc.printPrice(product.price)}
                                                                    </span>
                                                                    <br>
                                                                    <span class="image-price">${productFunc.printPrice(product.discountPrice)}
                                                                    </span>
                                                                </c:if>
                                                                <c:if test="${product.discountPrice == 0}">
                                                                    <br><span class="image-price">${productFunc.printPrice(product.price)}</span>
                                                                </c:if>
                                                            </p>
                                                        </a>
                                                    </div>
                                                    <div class="buynow-btn">
                                                        <a href="#">
                                                            <button class="btn btn-dark">
                                                                <i class="fa-solid fa-cart-shopping"></i> Thêm vào giỏ
                                                            </button>
                                                        </a>
                                                    </div>
                                                </div>
                                            </c:if>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                    </c:if>
                    <c:if test="${requestScope.SEARCH_LIST == null}">
                        <div class="search-empty">
                            <img src="img/search-no-result.png"/>
                            <h4>Không có kết quả nào phù hợp với tìm kiếm của bạn.<br>Vui lòng thử lại.</h4>
                            <a href="ShopPageController" class="btn btn-dark">Tiếp tục</a>
                        </div>
                    </c:if>
                </div>
                <div class="another-suggestion">
                    <div class="another-suggestion-spacing">
                        <div class="suggestion-header-section">
                            <h4>Các gợi ý khác</h4>
                        </div>
                        <div class="suggestion-content-section bg-white">
                            <div class="image-collapse">
                                <c:if test="${requestScope.LIST_RELATE_PRODUCT != null}">
                                    <ul class="another-image-list row">
                                        <c:forEach var="otherProduct" varStatus="counter" items="${requestScope.LIST_RELATE_PRODUCT}">
                                            <c:if test="${counter.count <= 4}">
                                                <li class="image-contain col-lg-3 col-md-6">
                                                    <div class="another-image-contain-section">
                                                        <div class="image-contain-detail">
                                                            <a href="productDetail?productID=${otherProduct.productID}" class="product-detail">
                                                                <img src="${otherProduct.image}"
                                                                     alt="..." class="mx-2">
                                                                <p class="image-title">${otherProduct.name}<br>
                                                                    <c:if test="${otherProduct.discountPrice != 0}">
                                                                        <span
                                                                            class="image-price-discout">${productFunc.printPrice(otherProduct.price)}
                                                                        </span>
                                                                        <br>
                                                                        <span class="image-price">${productFunc.printPrice(otherProduct.discountPrice)}
                                                                        </span>
                                                                    </c:if>
                                                                    <c:if test="${otherProduct.discountPrice == 0}">
                                                                        <br><span class="image-price">${productFunc.printPrice(otherProduct.price)}</span>
                                                                    </c:if>
                                                                </p>
                                                            </a>
                                                        </div>
                                                        <div class="buynow-btn">
                                                            <a href="#">
                                                                <button class="btn btn-dark">
                                                                    <i class="fa-solid fa-cart-shopping"></i> Thêm vào giỏ
                                                                </button>
                                                            </a>
                                                        </div>
                                                    </div>
                                                </li>
                                            </c:if>
                                        </c:forEach>
                                    </ul>
                                </c:if>
                                <a href="shopPage" class="all-product">
                                    Tất cả sản phẩm
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <footer class="d-flex">
                <div class="information">
                    <h2>Nest F</h2>
                    <p>Liên hệ chúng tôi <br>
                        <span>Số điện thoại: 01234123</span><br>
                        <span>Email: nestf@gmail.com</span>
                    </p>
                </div>
                <div class="social-media">
                    <h2>Theo dõi chúng tôi trên</h2>
                    <a href="#">
                        <i class="fa-brands fa-facebook fa-2x"></i>
                    </a>
                    <a href="#">
                        <i class="fa-brands fa-instagram fa-2x"></i>
                    </a>
                </div>
            </footer>
        </section>
    </body>
</html>
