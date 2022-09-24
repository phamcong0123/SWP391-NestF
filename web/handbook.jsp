<%-- 
    Document   : newjsp4
    Created on : Sep 20, 2022, 4:00:09 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

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
        <nav class="navbar-expand bg-light navbar-light">
            <ul class="navbar">
                <li class="nav-item col-2 d-inline-block">
                    <a href="home"><img src="img/logo.png" id="logo" class="col-3"></a>
                </li>
                <li class="nav-item col-1 d-inline-block">
                    <a href="shop" class="nav-link text-center">Shop</a>
                </li>
                <li class="nav-item col-1 d-inline-block">
                    <a href="handbook" class="nav-link text-center current-tab disabled">Cẩm nang</a>
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
                    <div><a href="voucher" class="nav-link text-center">Điểm tích luỹ</a></div>
                </li>
            </ul>
        </nav>
    </div>
    <div id="white-board" class="bg-light">  
        <h2 class="d-block col-8">Cẩm nang</h2>  
        <div class="row row-cols-4">
            <a href="article" class="nav-link col mb-4" id="post">
                <img src="img/post1.jpg" class="col-10">
                <h5 class="mt-2">Title</h5>
            </a>         
            <a href="article" class="nav-link col mb-4" id="post">
                <img src="img/post2.jpg" class="col-10">
                <h5 class="mt-2">Title</h5>
            </a>
            <a href="article" class="nav-link col mb-4" id="post">
                <img src="img/post3.jpg" class="col-10">
                <h5 class="mt-2">Title</h5>
            </a>
            <a href="article" class="nav-link col mb-4" id="post">
                <img src="img/post4.jpg" class="col-10">
                <h5 class="mt-2">Title</h5>
            </a>
            <a href="article" class="nav-link col mb-4" id="post">
                <img src="img/post1.jpg" class="col-10">
                <h5 class="mt-2">Title</h5>
            </a>                
        </div>
    </div>
</body>

</html>