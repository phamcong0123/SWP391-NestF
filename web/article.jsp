<%-- 
    Document   : article
    Created on : Sep 23, 2022, 3:43:02 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
    <c:if test="${empty requestScope.POST}" >
        <c:redirect url="handbookPage"></c:redirect>
    </c:if>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <link rel="icon" href="img/logo.png" type="image/x-icon" />
        <title>${requestScope.POST.title}</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" rel="stylesheet">
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
                        <c:if test="${not empty sessionScope.USER}">
                            <div id="dropDownMenu" class="d-inline-block position-relative">
                                <i class="fas fa-user me-2"></i>${sessionScope.USER.customerName}
                                <div id="dropDownContent" class="d-none bg-white text-start position-absolute shadow">
                                    <a href="accountPage" class="nav-link mb-2 text-decoration-none p-2" id="item">Cài đặt tài khoản</a>
                                    <a href="logOut" class="nav-link text-decoration-none p-2" id="item">Đăng xuất</a>
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${empty sessionScope.USER}"><div><a href="loginPage" class="nav-link"><i class="fas fa-user    "></i>Đăng nhập</a></div>
                        </c:if>
                    </li>
                    <li class="nav-item col-1 d-inline-block text-center">
                        <div> 
                            <c:if test="${not empty sessionScope.USER}">
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
                            <c:if test="${not empty sessionScope.USER}">
                                <a href="voucherPage" class="nav-link text-center">${sessionScope.USER.point} CP</a>
                            </c:if>
                        </div>
                    </li>
                </ul>
            </nav>
        </div>
        <div id="white-board" class="d-flex justify-content-between col-10">
            <div class="bg-white col-8 mt-4 d-inline-block" id="article">  
                <h2 class="pt-4 fw-bold ms-4">${requestScope.POST.title}</h2>
                <div id="author" class="text-start ms-4">   
                    <span class="fs-5">Tác giả : ${requestScope.POST.seller.name}</span><br>
                    <span class="text-muted">Ngày đăng : ${requestScope.POST.dateTime}</span>
                </div><br>
                <div id="content" class="pb-2 pe-4">            
                    <c:import charEncoding="UTF-8" url="${requestScope.POST.filePath}"></c:import>
                    </div>
                </div>
            <c:if test = "${not empty requestScope.RECOMMEND_POST}">
                <div id="other-article" class="bg-white d-inline-block mt-4 h-100 sticky-top">
                    <h2 class="text-center">Bài viết khác</h2>
                    <c:forEach items="${requestScope.RECOMMEND_POST}" var = "post">
                        <c:url var="postLink" value="loadArticle">
                            <c:param name="postID" value="${post.postID}"/>     
                        </c:url>
                        <a href="${postLink}" class="nav-link text-decoration-none" id="article-link">
                            <div class="m-3 d-flex justify-content-start">
                                <img src="${post.image}" class="d-inline-block col-6">
                                <div class="d-inline-block text-start ms-2">
                                    <span>${post.title}</span>
                                </div>            
                            </div>
                        </a>
                    </c:forEach>

                </div>
            </c:if>
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
    </body>

</html>
