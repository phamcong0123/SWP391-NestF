<%-- 
    Document   : newjsp2
    Created on : Sep 20, 2022, 4:05:18 PM
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
        <link rel="icon" href="img/logo.png" type="image/x-icon" />
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" rel="stylesheet">
        <link href="css/nestf.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.2.1/js/bootstrap.min.js" integrity="sha512-vyRAVI0IEm6LI/fVSv/Wq/d0KUfrg3hJq2Qz5FlfER69sf3ZHlOrsLriNm49FxnpUGmhx+TaJKwJ+ByTLKT+Yg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
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
                        <div><a href="accountPage" class="nav-link current-tab disabled"><i class="fas fa-user    "></i>${CUSTOMER.customerName}</div>
                    </li>
                    <li class="nav-item col-1 d-inline-block text-center">
                        <div><a href="cartPage" class="nav-link"><i class="fa-solid fa-cart-shopping"></i></a></div>
                    </li>
                    <li class="nav-item col-1 d-inline-block text-center">
                        <div><a href="voucherPage" class="nav-link">${CUSTOMER.point} CP</a></div>
                    </li>
                </ul>
            </nav>
        </div>
        <div id="overall">
            <ul id="options" class="nav nav-tabs" role="tablist">
                <li class="nav-item" role="presentation">
                    <button id="setting-tab" data-bs-target="#account-settings" data-bs-toggle="tab" aria-selected="true" role="tab"  aria-controls="account-settings" aria-current="page" class="nav-link active">Cài đặt tài khoản</button>
                </li>
                <li class="nav-item" role="presentation">
                    <button id="voucher-tab" data-bs-target="#all-voucher" data-bs-toggle="tab" aria-selected="false" role="tab" aria-controls="all-voucher" aria-current="page" class="nav-link">Voucher của bạn</button>
                </li>
            </ul>
            <div class="tab-content">
                <div id="account-settings" class="tab-pane fade show active" role="tabpanel" aria-labelledby="setting-tab">
                    <div id="whiteboard2" class="col-8 bg-light">
                        <span class="d-inline-block col-11 text-start m-3">Cài đặt tài khoản</span>
                        <div class="accordion">
                            <div class="accordion-item col-11 dropdown-setting" id="changeName">
                                <div class="accordion-header">
                                    <button class="accordion-button collapsed" id="dropDownBtn" type="button" data-bs-toggle="collapse" data-bs-target="#collapse1" aria-controls="collapse1">
                                        <img src="img/name.svg">Thay đổi tên hiển thị</i>
                                    </button>
                                </div>
                                <div id="collapse1" class="accordion-collapse collapse hiding">
                                    <div class="accordion-body">
                                        <form action="changeNameAction" method="post" id="changeForm">                                     
                                            <div class="m-3 d-inline-block">Tên hiển thị mới</div><input type="text"
                                                                                                         name="name" class="col-6"><br>
                                            <input type="submit" value="LƯU" id="color-button">
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div class="accordion-item col-11 dropdown-setting" id="changePass">
                                <div class="accordion-header">
                                    <button class="accordion-button collapsed" id="dropDownBtn" type="button" data-bs-toggle="collapse" data-bs-target="#collapse2" aria-controls="collapse2">
                                        <img src="img/lock.svg">Thay đổi mật khẩu</i>
                                    </button>
                                </div>
                                <div id="collapse2" class="accordion-collapse collapse hiding">
                                    <div class="accordion-body">
                                        <form action="changePassAction" method="post" id="changeForm">
                                            <div class="m-3 d-inline-block">Mật khẩu cũ</div><input type="password" name="password"
                                                                                                    class="col-6"><br>
                                            <div class="m-3 d-inline-block">Mật khẩu mới</div><input type="password" name="newPass"
                                                                                                     class="col-6"><br>
                                            <div class="m-3 d-inline-block">Xác nhận mật khẩu mới</div><input type="password"
                                                                                                              name="confirm" class="col-6"><br>
                                            <input type="submit" value="LƯU" id="color-button">
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div class="accordion-item col-11 dropdown-setting" id="changeAddress" role="tabpanel">
                                <div class="accordion-header">
                                    <button class="accordion-button collapsed" id="dropDownBtn" type="button" data-bs-toggle="collapse" data-bs-target="#collapse3" aria-controls="collapse3">
                                        <img src="img/address.svg">Thay đổi địa chỉ giao hàng mặc định</i>
                                    </button>
                                </div>
                                <div id="collapse3" class="accordion-collapse collapse hiding">
                                    <div class="accordion-body">
                                        <form action="changeAddressAction" method="post" id="changeForm">
                                            <div class="m-3 d-inline-block">Địa chỉ cũ :</div><span> ${CUSTOMER.customerAddress}</span><br>
                                            <div class="m-3 d-inline-block">Địa chỉ mới</div><input type="text" name="newAddress"
                                                                                                    class="col-8"><br>
                                            <input type="submit" value="LƯU" id="color-button">
                                        </form>
                                    </div>
                                </div>
                            </div>                                             
                        </div>
                    </div>
                    <div class="col-10 d-flex justify-content-end mb-5"><a href="logOut" class="nav-link"><i class="fa-solid fa-arrow-right-from-bracket"></i>Đăng xuất</a></div>
                </div>
                <div id="all-voucher" class="tab-pane fade" role="tabpanel" aria-labelledby="voucher-tab">
                    <div id="whiteboard2" class="col-8 bg-light">
                        <span class="d-inline-block col-9 m-3 text-start">Voucher của bạn</span><a href="voucherPage" class="nav-link d-inline-block"><i class="fa-solid fa-basket-shopping"></i>Đi mua voucher</a> 
                        <div class="row row-cols-4">
                            <div id="voucher" class="d-inline-block col mb-2">
                                <img src="img/voucher.png"><br>
                                <span>TÊN VOUCHER</span>
                                <p>Hết hạn trong 30 ngày nữa</p>
                            </div>
                            <div id="voucher" class="d-inline-block col mb-2">
                                <img src="img/voucher.png"><br>
                                <span>TÊN VOUCHER</span>
                                <p>Hết hạn trong 30 ngày nữa</p>
                            </div>
                            <div id="voucher" class="d-inline-block col mb-2">
                                <img src="img/voucher.png"><br>
                                <span>TÊN VOUCHER</span>
                                <p>Hết hạn trong 30 ngày nữa</p>
                            </div>
                            <div id="voucher" class="d-inline-block col mb-2">
                                <img src="img/voucher.png"><br>
                                <span>TÊN VOUCHER</span>
                                <p>Hết hạn trong 30 ngày nữa</p>
                            </div>
                            <div id="voucher" class="d-inline-block col mb-2">
                                <img src="img/voucher.png"><br>
                                <span>TÊN VOUCHER</span>
                                <p>Hết hạn trong 30 ngày nữa</p>
                            </div>                     
                        </div>
                    </div>
                </div>            
            </div>
        </div>
    </body>

</html>
