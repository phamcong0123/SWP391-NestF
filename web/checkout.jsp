<%-- 
    Document   : cart
    Created on : Sep 19, 2022, 10:33:02 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" href="img/logo.png" type="image/x-icon" />
        <title>Thanh toán</title>
        <!-- Latest compiled and minified CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" rel="stylesheet">
        <link href="css/nestf.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.2.1/js/bootstrap.min.js" integrity="sha512-vyRAVI0IEm6LI/fVSv/Wq/d0KUfrg3hJq2Qz5FlfER69sf3ZHlOrsLriNm49FxnpUGmhx+TaJKwJ+ByTLKT+Yg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    </head>

    <body class="text-center">
        <div id="navbar" class="sticky-top">
            <nav class="navbar-expand bg-white navbar-light">
                <ul class="navbar">
                    <li class="nav-item col-2 d-inline-block">
                        <a href="home"><img src="img/logo.png" id="logo" class="col-3"></a>
                    </li>
                    <li class="nav-item col-1 d-inline-block">
                        <a href="shop" class="nav-link text-center">Shop</a>
                    </li>
                    <li class="nav-item col-1 d-inline-block">
                        <a href="handbook" class="nav-link text-center">Cẩm nang</a>
                    </li>
                    <li class="nav-item col-1 d-inline-block">
                        <a href="about" class="nav-link text-center">Về chúng tôi</a>
                    </li>
                    <li class="nav-item col-3 d-inline-block text-center">
                        <form action="searchAction" method="get" id="search-form">
                            <button type="submit" class="border-0 bg-transparent"><i class="fas fa-search    "></i></button>
                            <input type="text" class="text-center" placeholder="Tìm kiếm" name="txtSearch" value="">
                        </form>
                    </li>
                    <li class="nav-item col-2 d-inline-block text-center">
                        <div id="dropDownMenu" class="d-inline-block position-relative">
                            <i class="fas fa-user me-2"></i>${sessionScope.USER.name}
                            <div id="dropDownContent" class="d-none bg-white text-start position-absolute shadow">
                                <a href="account" class="nav-link mb-2 text-decoration-none p-2" id="item">Cài đặt tài khoản</a>
                                <a href="logOut" class="nav-link text-decoration-none p-2" id="item">Đăng xuất</a>
                            </div>
                        </div>
                    </li>
                    <li class="nav-item col-1 d-inline-block text-center">
                        <div> 
                            <c:if test="${not empty sessionScope.USER}">
                                <a href="cart" class="nav-link text-center"><i class="fa-solid fa-cart-shopping position-relative">
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
                        <div><a href="voucher" class="nav-link text-center">${sessionScope.USER.point} CP</a></div>
                    </li>
                </ul>
            </nav>
        </div>
        <div id="whiteboard2" class="bg-white w-75">
            <h2 class="p-4">Xác nhận thanh toán</h2>
            <form action="confirmPayment">
                <div class="fs-5 p-5">
                    <p><span>Địa chỉ giao hàng : </span><input id = "address" class = "col-6" type="text" name="address" placeholder="${sessionScope.USER.address}"/>
                        <br>
                        <font color="red" class="fs-6">(Lưu ý: Đơn hàng sẽ được giao theo địa chỉ trên/địa chỉ mặc định của quý khách, địa chỉ giao hàng Paypal sẽ không được sử dụng)</font>
                    </p>                  
                    <jsp:useBean id="formatter" class="com.nestf.util.FormatPrinter"/>
                    <c:set var = "totalInUSD" value="${formatter.toUSD(requestScope.TOTAL)}"/>
                    <span>Thành tiền : <b>$${totalInUSD}</b> (quy đổi từ ${formatter.printMoney(requestScope.TOTAL)})</span>
                </div>
                <div id="paypalButtonContainer" class="m-auto col-6"></div>
            </form>

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
        <script src="js/nestf.js"></script>   
        <script src="https://www.paypal.com/sdk/js?client-id=AeJ5oAA7OGoD8dlZNG6MWDNJqDoV2MQaaldDD1xNoq0upDs938zsUah_a2tjlplqHCutIojCuLwYJK__&currency=USD"></script>
        <script>
            paypal.Buttons({
                // Sets up the transaction when a payment button is clicked
                createOrder: (data, actions) => {
                    return actions.order.create({
                        purchase_units: [{
                                amount: {
                                    value: '${totalInUSD}' // Can also reference a variable or function
                                }
                            }]
                    });
                },
                // Finalize the transaction after payer approval
                onApprove: (data, actions) => {
                    return actions.order.capture().then(function (orderData) {
                        // Successful capture! For dev/demo purposes:
                        const transaction = orderData.purchase_units[0].payments.captures[0];                      
                        // When ready to go live, remove the alert and show a success message within this page. For example:
                        // const element = document.getElementById('paypal-button-container');
                        // element.innerHTML = '<h3>Thank you for your payment!</h3>';
                        // Or go to another URL:  actions.redirect('thank_you.html');
                        var url = 'confirmCheckOut?transactionID='+transaction.id+'&address=';
                        url+=document.getElementById("address").value;
                        url+="&total=${requestScope.TOTAL}";
            <c:if test = "${not empty requestScope.VOUCHERID}">
                        url += "&voucherID=${requestScope.VOUCHERID}";
            </c:if>
                        window.location.replace(url);
                    });
                }
            }).render('#paypalButtonContainer');
        </script>
    </body>

</html>
