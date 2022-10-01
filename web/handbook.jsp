<%-- 
    Document   : newjsp4
    Created on : Sep 20, 2022, 4:00:09 PM
    Author     : Admin
--%>

<%@page import="java.util.List"%>
<%@page import="com.nestf.post.PostDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">
    <c:if test="${empty requestScope.POST_LIST}" >
        <c:redirect url="handbookLoad"></c:redirect>
    </c:if>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cẩm nang</title>
        <meta name="description" content="">
        <link rel="icon" href="img/logo.png" type="image/x-icon" />
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
                        <a href="handbookPage" class="nav-link text-center current-tab disabled">Cẩm nang</a>
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
        <div id="white-board" class="bg-white">  
            <h2 class="d-block col-8">Cẩm nang</h2>
            <c:if test="${ not empty requestScope.POST_LIST}" >
                <div class="row row-cols-3 container-fluid m-0">
                    <c:forEach items="${requestScope.POST_LIST}" var="post">
                        <c:url var="postLink" value="loadArticle">
                            <c:param name="postID" value="${post.postID}"/>     
                        </c:url>
                        <a href="${postLink}" class="nav-link col mb-4" id="post">
                            <img src="${post.image}" class="col-10"><br>
                            <span class="mt-2 col-10 text-start d-inline-flex">${post.title}</span>
                        </a> 
                    </c:forEach>                    
                </div>
            </c:if>
            <c:if test="${empty requestScope.POST_LIST}">
                <div style="height:50vh;" class="d-flex align-items-center justify-content-center">
                    <h2 class="text-muted text-center pb-5">Chưa có bài viết nào</h2>
                </div>
            </c:if>

        </div>
    </body>

</html>