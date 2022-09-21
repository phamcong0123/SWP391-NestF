<%-- 
    Document   : cart
    Created on : Sep 19, 2022, 10:33:02 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="/img/logo.png" type="image/x-icon" />
    <title>NestF</title>
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>

    <!-- Font awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="/css/style.css">

</head>

<body>
    <div id="header">
        <nav class="navbar navbar-expand-xl bg-light text-dark">
            <div class="container-fluid">
                <ul class="navbar-nav navigation">
                    <a class="nav-link active" href="#"><img src="/img/logo.png" style="width: 60px;" alt=""></a>
                    <li class="nav-item">
                        <a class="nav-link active" href="#">Shop</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="#">Blog</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="#">Về chúng tôi</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="#"><input type="text" placeholder="Tìm kiếm"><i
                                class="fa fa-search search" aria-hidden="true"></i></a>
                    </li>
                    <li class="nav-item">
                        <a href="" class="nav-link active"><i class="fa fa-user-o user" aria-hidden="true"></i> Tài
                            khoản</a>
                    </li>
                    <li class="nav-item">
                        <a href="" class="nav-link active"><i class="fa fa-shopping-cart" aria-hidden="true"></i></a>
                    </li>
                </ul>
                <!-- </div> -->
        </nav>

    </div>
    <div class="main container-fluid">

        <div id="cart">
            
        </div>

        <div id="promotion">

        </div>

        <div id="newproduct">

        </div>
    </div>
</body>

</html>
