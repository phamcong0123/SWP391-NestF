<%-- 
    Document   : newjsp1
    Created on : Sep 20, 2022, 4:05:11 PM
    Author     : Admin
--%>

<%@page import="com.nestf.product.ProductDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Nest F</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" type="image/x-icon" href="img/logo.png">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" rel="stylesheet">
        <link href="css/nestf.css" rel="stylesheet">       
    </head>

    <body class="text-center">
        <c:choose>
            <c:when test = "${param.fail eq 'maxAmount'}">
                <span id="trigger" class="d-none" data-bs-toggle="modal" data-bs-target="#notification">                           
                </span>                     
                <div class="modal fade" id="notification" tabindex="-1" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content">  
                            <div class="text-start">
                                <img src="img/success.svg" class="col-3 d-inline-block m-3">
                                <span class="fw-bold d-inline-block fs-2 ms-4">Thành công!</span> 
                            </div>           
                        </div>
                    </div>
                </div>           
            </c:when>
            <c:when test = "${param.fail eq 'false'}">
                <span id="trigger" class="d-none" data-bs-toggle="modal" data-bs-target="#notification">                           
                </span>                     
                <div class="modal fade" id="notification" tabindex="-1" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content">  
                            <div class="text-start">
                                <img src="img/success.svg" class="col-3 d-inline-block m-3">
                                <span class="fw-bold d-inline-block fs-2 ms-4">Thành công!</span> 
                            </div>           
                        </div>
                    </div>
                </div>           
            </c:when>
        </c:choose>
        <div id="navbar" class="sticky-top">
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
        <div id="white-board" class="bg-white w-75">
            <div class="row container-fluid m-0">
                <c:if test="${requestScope.PRODUCT_DETAIL != null}">
                    <c:set var="productDetail" value="${requestScope['PRODUCT_DETAIL']}" scope="page"/>
                    <jsp:useBean id="productFunc" class="com.nestf.product.ProductDTO"/>
                    <div class="d-inline-block col-5 mt-3">
                        <img src="${productDetail.image}" class="rounded col-11">
                    </div>     
                    <div class="d-inline-block col-7">
                        <h2 class="text-center">${productDetail.name}</h2>
                        <span class="d-inline-block pb-3 fs-5 text-danger">
                            <c:if test="${productDetail.discountPrice ne 0}">
                                ${productFunc.printPrice(productDetail.discountPrice)}
                                <span class="text-muted text-decoration-line-through ms-3">
                                    ${productFunc.printPrice(productDetail.price)}
                                </span>
                            </c:if>
                            <c:if test = "${productDetail.discountPrice eq 0}">
                                <span class="text-black">
                                    ${productFunc.printPrice(productDetail.price)}
                                </span>
                            </c:if>
                        </span>
                        <c:import charEncoding="UTF-8" url="${productDetail.productDes}"></c:import>
                        </div>
                </c:if>           
            </div>
            <div id="number-toggle" class="text-center col-7">
                <div class="input-group d-inline-block">
                    <form action="addToCart">
                        <input type="hidden" name="productID" value="${productDetail.productID}"/>
                        <img src="img/plus.svg" data-field="quantity" class="button-plus d-inline-block">
                        <input required id="number-input" type="number" step="1" value="1" min="1" max="${productDetail.quantity}" onblur="minCheck(this), maxCheck(this)" name="quantity" class="quantity-field text-center p-0">
                        <img src="img/minus.svg" data-field="quantity" class="button-minus d-inline-block"><br>
                        <button type="submit" id="buy-button" class="col-3 me-2" value="true" name="buynow">Mua ngay</button>
                        <button type="submit" id="buy-button" class="col-3 ms-2 bg-white text-black border border-dark rounded"><img src="img/cart.svg" class="me-2">Thêm vào giỏ</button>
                    </form>
                </div>
            </div>
            <br>
            <div class="container-fluid">
            </div>
        </div>
        <div id="white-board" class="bg-white w-75">
            <h4 class="text-start pt-4 ms-4">Sản phẩm cùng loại</h4>
            <c:if test="${requestScope.LIST_RELATE_PRODUCT != null}">
                <div class="row col-11 m-auto">
                    <c:forEach var="otherProduct" varStatus="counter" items="${requestScope.LIST_RELATE_PRODUCT}">
                        <c:if test="${counter.count <= 4}">
                            <div id="item" class="col-lg-3 col-md-4 d-inline-block p-3">
                                <a href="productDetail?productID=${otherProduct.productID}" 
                                   style="color: #000;
                                   text-decoration: none">
                                    <img src="${otherProduct.image}" class="mb-2">
                                    <h6 class="product-title">${otherProduct.name}</h6>
                                    <c:if test="${otherProduct.discountPrice != 0}">
                                        <span class="text-muted text-decoration-line-through">${productFunc.printPrice(otherProduct.price)}</span>
                                        <br>
                                        <span class="text-danger">${productFunc.printPrice(otherProduct.discountPrice)}</span><br>
                                    </c:if>
                                    <c:if test="${otherProduct.discountPrice == 0}">
                                        <br><span>${productFunc.printPrice(otherProduct.price)}</span><br>
                                    </c:if>
                                    <a href="addToCart?productID=${otherProduct.productID}&buynow=true"><button id="buy-button" class="col-6">Mua ngay</button></a>
                                </a>
                            </div>
                        </c:if>
                    </c:forEach>
                </div>
            </c:if>
            <a href="ShopPageController" class="nav-link pb-3">Tất cả sản phẩm</a>
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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.2.1/js/bootstrap.min.js" integrity="sha512-vyRAVI0IEm6LI/fVSv/Wq/d0KUfrg3hJq2Qz5FlfER69sf3ZHlOrsLriNm49FxnpUGmhx+TaJKwJ+ByTLKT+Yg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>        
    <script>
                            window.onload = function () {
                                document.getElementById("trigger").click();
                            }
                            $('#trigger').click(function () {
                                setTimeout(function () {
                                    $('#notification').modal('hide');
                                }, 1500);
                            });
    </script>
    <script>
        function incrementValue(e) {
            e.preventDefault();
            var max = document.getElementById("number-input").max;
            var fieldName = $(e.target).data('field');
            var parent = $(e.target).closest('div');
            var currentVal = parseInt(parent.find('input[name=' + fieldName + ']').val(), 10);

            if (!isNaN(currentVal) && currentVal < max) {
                parent.find('input[name=' + fieldName + ']').val(currentVal + 1);
            }
        }

        function decrementValue(e) {
            e.preventDefault();
            var fieldName = $(e.target).data('field');
            var parent = $(e.target).closest('div');
            var currentVal = parseInt(parent.find('input[name=' + fieldName + ']').val(), 10);

            if (!isNaN(currentVal) && currentVal > 1) {
                parent.find('input[name=' + fieldName + ']').val(currentVal - 1);
            } else {
                parent.find('input[name=' + fieldName + ']').val(1);
            }
        }

        $('.input-group').on('click', '.button-plus', function (e) {
            incrementValue(e);
        });

        $('.input-group').on('click', '.button-minus', function (e) {
            decrementValue(e);
        });

        function maxCheck(object) {
            if (object.value > object.max)
                object.value = object.max;
        }

        function minCheck(object) {
            if (object.value == '' || object.value < object.min)
                object.value = object.min;
        }

    </script>   
</body>
</html>