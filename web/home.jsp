<%-- 
    Document   : newjsp1
    Created on : Sep 20, 2022, 3:59:53 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${requestScope.BEST_SELL_LIST == null}">
    <c:redirect url="homeAction"/>
</c:if>
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
    </head>
    <body>
        <section>
            <div id="navbar">
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

            <div class="container">
                <div id="carousel" class="carousel slide" data-bs-ride="carousel">
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img src="https://vuayensao.com.vn/wp-content/uploads/2021/04/banner-1536x480.jpg"
                                 class="d-block w-100 h-100 mx-auto" alt="...">
                        </div>
                        <div class="carousel-item">
                            <img src="https://startnestfoods.com/wp-content/uploads/2020/01/banner-to-yen-2.jpg"
                                 class="d-block mx-auto" alt="...">
                        </div>
                        <div class="carousel-item">
                            <img src="https://nunest.vn/wp-content/uploads/2019/07/banner-3.jpg" class="d-block mx-auto"
                                 alt="...">
                        </div>
                    </div>
                    <button class="carousel-control-prev" type="button" data-bs-target="#carousel" data-bs-slide="prev">
                        <span class="carousel-control-prev-icon bg-opacity-10 bg-dark" aria-hidden="true"></span>
                        <span class="visually-hidden">Previous</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-bs-target="#carousel" data-bs-slide="next">
                        <span class="carousel-control-next-icon bg-opacity-10 bg-dark" aria-hidden="true"></span>
                        <span class="visually-hidden">Next</span>
                    </button>
                </div>

                <jsp:useBean id="proFunc" class="com.nestf.product.ProductDTO"/>
                <c:set var="productList" value="${requestScope['BEST_SELL_LIST']}" scope="page"/>
                <div class="best-sell-container">
                    <div class="bestsell-container-spacing pt-3">
                        <div class="bestsell-header-section ms-3">
                            <h3>Sản phẩm bán chạy</h3>
                        </div>
                        <c:if test="${not empty requestScope.BEST_SELL_LIST}">
                            <div class="bestsell-section-content">
                                <div class="image-collapse">
                                    <ul class="image-list row">
                                        <c:forEach var="product" items="${productList}">
                                            <li class="image-contain col-lg-3 col-md-6">
                                                
                                                <div class="image-contain-section mx-2">
                                                    <div class="image-contain-detail">
                                                        <a href="productDetail?productID=${product.productID}" class="product-detail">
                                                            <img src="${product.image}" alt="Image for ${product.name}" class="mx-2">
                                                            <p class="image-title">${product.name}<br>
                                                                <c:if test="${product.discountPrice != 0}">
                                                                    <span
                                                                        class="image-price-discout">${proFunc.printPrice(product.price)}
                                                                    </span>
                                                                    <br>
                                                                    <span class="image-price">${proFunc.printPrice(product.discountPrice)}
                                                                    </span>
                                                                </c:if>
                                                                <c:if test="${product.discountPrice == 0}">
                                                                    <br><span class="image-price">${proFunc.printPrice(product.price)}</span>
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
                                        </c:forEach>
                                    </ul>
                                </div>
                            </div>
                        </c:if>
                    </div>
                </div>

                <div class="combo-product">
                    <div class="combo-product-spacing d-flex">

                        <div class="combo-product-describe">
                            <h5 class="combo-title">Combo nổi bật</h5>
                            <p>${productList[0].name}: 
                                <c:if test="${productList[0].discountPrice == 0}">
                                    <span class="product-price">${proFunc.printPrice(productList[0].price)}</span>
                                </c:if>
                                <c:if test="${productList[0].discountPrice != 0}">
                                    <span class="product-price">${proFunc.printPrice(productList[0].discountPrice)}</span>
                                </c:if>
                            </p>
                            <p>${productList[1].name}: 
                                <c:if test="${productList[1].discountPrice == 0}">
                                    <span class="product-price">${proFunc.printPrice(productList[1].price)}</span>
                                </c:if>
                                <c:if test="${productList[1].discountPrice != 0}">
                                    <span class="product-price">${proFunc.printPrice(productList[1].discountPrice)}</span>
                                </c:if>
                            </p>
                        </div>
                        <div class="combo-product-image">
                            <img src="${productList[0].image}" alt="Image for ${productList[0].name}" class="ms-2">
                            <span class="plus-product-img">
                                <i class="fa-solid fa-plus"></i>
                            </span>
                            <img src="${productList[1].image}" alt="Image for ${productList[1].name}" class="ms-2">
                        </div>
                        <div class="combo-product-btn">
                            <p>Chỉ với 
                                <c:if test="${productList[0].discountPrice == 0 && productList[1].discountPrice == 0}">
                                    ${proFunc.printPrice(productList[0].price + productList[1].price)}
                                </c:if>
                                <c:if test="${productList[0].discountPrice != 0 && productList[1].discountPrice == 0}">
                                    ${proFunc.printPrice(productList[0].discountPrice + productList[1].price)}
                                </c:if>
                                <c:if test="${productList[0].discountPrice == 0 && productList[1].discountPrice != 0}">
                                    ${proFunc.printPrice(productList[0].price + productList[1].discountPrice)}
                                </c:if>
                                <c:if test="${productList[0].discountPrice != 0 && productList[1].discountPrice != 0}">
                                    ${proFunc.printPrice(productList[0].discountPrice + productList[1].discountPrice)}
                                </c:if>
                            </p>
                            <a href="#">
                                <button class="btn btn-dark">
                                    <i class="fa-solid fa-cart-shopping"></i> Thêm vào giỏ
                                </button>
                            </a>
                        </div>
                    </div>
                </div>

                <div class="another-suggestion">
                    <div class="another-suggestion-spacing">
                        <div class="suggestion-header-section">
                            <h4>Các gợi ý khác</h4>
                        </div>
                        <c:if test="${requestScope.OTHER_PRODUCT_LIST != null}">
                            <div class="suggestion-content-section">
                                <div class="image-collapse">
                                    <ul class="another-image-list row">
                                        <c:forEach var="anotherSuggest" varStatus="counter" items="${requestScope.OTHER_PRODUCT_LIST}">
                                            <c:if test="${counter.count <= 4}">
                                                <li class="image-contain col-lg-3 col-md-6">
                                                    <div class="another-image-contain-section">
                                                        <div class="image-contain-detail">
                                                            <a href="productDetail?productID=${anotherSuggest.productID}" class="product-detail">
                                                                <img src="${anotherSuggest.image}"
                                                                     alt="Image for ${anotherSuggest.name}" class="mx-2">
                                                                <p class="image-title">${anotherSuggest.name}<br>
                                                                    <c:if test="${anotherSuggest.discountPrice != 0}">
                                                                        <span
                                                                            class="image-price-discout">${proFunc.printPrice(anotherSuggest.discountPrice)}</span>
                                                                        <br><span
                                                                            class="image-price">${proFunc.printPrice(anotherSuggest.price)}</span></p>
                                                                    </c:if>
                                                                    <c:if test="${anotherSuggest.discountPrice == 0}">
                                                                    <br><span class="image-price">${proFunc.printPrice(anotherSuggest.price)}</span></p>
                                                                </c:if>
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
                                    <a href="shopPage" class="all-product">
                                        Tất cả sản phẩm
                                    </a>
                                </div>
                            </div>
                        </c:if>
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
