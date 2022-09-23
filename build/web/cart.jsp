<%-- 
    Document   : cart
    Created on : Sep 19, 2022, 10:33:02 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="img/logo.png" type="image/x-icon" />
    <title>NestF</title>
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>

    <!-- Font awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
    <link rel="stylesheet" href="css/style.css">

</head>

<body>
    <div id="header">
        <nav class="navbar navbar-expand-xl bg-light text-dark">
            <div class="container-fluid">
                <ul class="navbar-nav navigation">
                    <a class="nav-link active" href="#"><img src="img/logo.png" style="width: 60px;" alt=""></a>
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
                        <a href="" class="nav-link active"><i class="fa fa-user-o user" aria-hidden="true"></i>Tài
                            khoản</a>
                    </li>
                    <li class="nav-item">
                        <a href="" class="nav-link active"><i class="fa fa-shopping-cart" aria-hidden="true"></i></a>
                    </li>
                </ul>
        </nav>

    </div>
            
    <div class="main container-fluid">
        <div class="cart navbar-nav">
            <ul class="d-flex justify-content-around mb-2 list-unstyled">
                <li class="p-2 nav-item">
                    <h4> <a class="nav-link active" onclick="document.getElementById('cart-item').style.display='flex'"
                            href="">Giỏ hàng</a></h4>
                </li>
                <li class="p-2 nav-item">
                    <h4><a class="nav-link active" href="">Lịch sử mua hàng</a></h4>
                </li>
            </ul>
            <div id="d-lg-none d-xl-none cart-item">
                <section class="h-100">
                    <div class="container h-100">
                        <div class="row d-flex justify-content-center align-items-center h-100">
                            <div class="col-10">

                                <div class="d-flex justify-content-between align-items-center mb-4">
                                    <h5 class="fw-normal mb-0 text-black">Giỏ hàng của bạn</h5>
                                    <div>
                                        <p class="mb-0"><span class="text-muted">Voucher :</span>
                                            <select class="form-select d-xl-inline-block"
                                                aria-label="Default select example">
                                                <option selected>None</option>
                                                <option value="1">One</option>
                                                <option value="2">Two</option>
                                                <option value="3">Three</option>
                                            </select>
                                        </p>
                                    </div>
                                </div>
                                <div class="card rounded-3 mb-4">
                                    <div class="card-body p-4">
                                        <div class="row d-flex justify-content-between align-items-center">
                                            <div class="col-md-2 col-lg-2 col-xl-2">
                                                <img src="https://yensaokhanhhoa.vn/wp-content/uploads/2022/06/yen-tho-cao-cap.png"
                                                    class="img-fluid rounded-3" alt="Tổ yến thô">
                                            </div>
                                            <div class="col-md-3 col-lg-3 col-xl-3">
                                                <p class="lead fw-normal mb-2 fw-bold">TỔ YẾN THÔ <span
                                                        class="text-muted">100g</span></p>

                                                <p><del><span class="text-muted">1000000 đ
                                                        </span></del><span class="fw-bold">20% Off</span><br><span
                                                        class="fw-bold">800000 đ</span></p>
                                                <p>Description: </p>
                                            </div>
                                            <div class="col-md-3 col-lg-3 col-xl-2 d-flex">
                                                <button class="btn btn-link px-2"
                                                    onclick="this.parentNode.querySelector('input[type=number]').stepDown()">
                                                    <i class="fa fa-minus" aria-hidden="true"></i>
                                                </button>

                                                <input id="form1" min="1" name="quantity" value="2" type="number"
                                                    class="form-control form-control-sm" />

                                                <button class="btn btn-link px-2"
                                                    onclick="this.parentNode.querySelector('input[type=number]').stepUp()">
                                                    <i class="fa fa-plus" aria-hidden="true"></i>
                                                </button>
                                            </div>
                                            <div class="col-md-3 col-lg-2 col-xl-2 offset-lg-1">
                                                <h5 class="mb-0">800.000</h5>
                                            </div>
                                            <div class="col-md-1 col-lg-1 col-xl-1 text-end">
                                                <a href="#!" class="text-danger"><i class="fa fa-times fa-lg"
                                                        aria-hidden="true"></i></a>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="card rounded-3 mb-4">
                                    <div class="card-body p-4">
                                        <div class="row d-flex justify-content-between align-items-center">
                                            <div class="col-md-2 col-lg-2 col-xl-2">
                                                <img src="https://yensaokhanhhoa.vn/wp-content/uploads/2022/06/yen-tho-cao-cap.png"
                                                    class="img-fluid rounded-3" alt="Tổ yến thô">
                                            </div>
                                            <div class="col-md-3 col-lg-3 col-xl-3">
                                                <p class="lead fw-normal mb-2 fw-bold">TỔ YẾN THÔ <span
                                                        class="text-muted">100g</span></p>

                                                <p><del><span class="text-muted">1000000 đ
                                                        </span></del><span class="fw-bold">20% Off</span><br><span
                                                        class="fw-bold">800000 đ</span></p>
                                                <p>Description: </p>
                                            </div>
                                            <div class="col-md-3 col-lg-3 col-xl-2 d-flex">
                                                <button class="btn btn-link px-2"
                                                    onclick="this.parentNode.querySelector('input[type=number]').stepDown()">
                                                    <i class="fa fa-minus" aria-hidden="true"></i>
                                                </button>

                                                <input id="form1" min="1" name="quantity" value="2" type="number"
                                                    class="form-control form-control-sm" />

                                                <button class="btn btn-link px-2"
                                                    onclick="this.parentNode.querySelector('input[type=number]').stepUp()">
                                                    <i class="fa fa-plus" aria-hidden="true"></i>
                                                </button>
                                            </div>
                                            <div class="col-md-3 col-lg-2 col-xl-2 offset-lg-1">
                                                <h5 class="mb-0">800.000</h5>
                                            </div>
                                            <div class="col-md-1 col-lg-1 col-xl-1 text-end">
                                                <a href="#!" class="text-danger"><i class="fa fa-times fa-lg"
                                                        aria-hidden="true"></i></a>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="card rounded-3 mb-4">
                                    <div class="card-body p-4">
                                        <div class="row d-flex justify-content-between align-items-center">
                                            <div class="col-md-2 col-lg-2 col-xl-2">
                                                <img src="https://yensaokhanhhoa.vn/wp-content/uploads/2022/06/yen-tho-cao-cap.png"
                                                    class="img-fluid rounded-3" alt="Tổ yến thô">
                                            </div>
                                            <div class="col-md-3 col-lg-3 col-xl-3">
                                                <p class="lead fw-normal mb-2 fw-bold">TỔ YẾN THÔ <span
                                                        class="text-muted">100g</span></p>

                                                <p><del><span class="text-muted">1000000 đ
                                                        </span></del><span class="fw-bold">20% Off</span><br><span
                                                        class="fw-bold">800000 đ</span></p>
                                                <p>Description: </p>
                                            </div>
                                            <div class="col-md-3 col-lg-3 col-xl-2 d-flex">
                                                <button class="btn btn-link px-2"
                                                    onclick="this.parentNode.querySelector('input[type=number]').stepDown()">
                                                    <i class="fa fa-minus" aria-hidden="true"></i>
                                                </button>

                                                <input id="form1" min="1" name="quantity" value="2" type="number"
                                                    class="form-control form-control-sm" />

                                                <button class="btn btn-link px-2"
                                                    onclick="this.parentNode.querySelector('input[type=number]').stepUp()">
                                                    <i class="fa fa-plus" aria-hidden="true"></i>
                                                </button>
                                            </div>
                                            <div class="col-md-3 col-lg-2 col-xl-2 offset-lg-1">
                                                <h5 class="mb-0">800.000</h5>
                                            </div>
                                            <div class="col-md-1 col-lg-1 col-xl-1 text-end">
                                                <a href="#!" class="text-danger"><i class="fa fa-times fa-lg"
                                                        aria-hidden="true"></i></a>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="card mb-4">
                                    <div class="card-body">
                                        <label class="form-label">Thành tiền: 4.800.000</label>
                                        <button type="button" class="btn btn-warning btn-block btn-lg float-end">Thanh
                                            toán</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
            <div id="order-history">

            </div>
        </div>
        <div id="promotion row">

        </div>

        <div id="newproduct">

        </div>

    </div>
</body>

</html>
