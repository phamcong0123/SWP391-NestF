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
        <title>Giỏ hàng</title>
        <!-- Latest compiled and minified CSS -->
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
                            <button type="submit"><i class="fas fa-search    "></i></button>
                            <input type="text" class="text-center" placeholder="Tìm kiếm" name="txtSearch" value="">
                        </form>
                    </li>
                    <li class="nav-item col-2 d-inline-block text-center">
                        <div><a href="accountPage" class="nav-link text-center"><i class="fas fa-user    "></i>${sessionScope.CUSTOMER.customerName}</a>
                        </div>
                    </li>
                    <li class="nav-item col-1 d-inline-block text-center">
                        <div><a href="cartPage" class="nav-link text-center current-tab disabled"><i class="fa-solid fa-cart-shopping"></i></a></div>
                    </li>
                    <li class="nav-item col-1 d-inline-block text-center">
                        <div><a href="voucherPage" class="nav-link text-center">${sessionScope.CUSTOMER.point} CP</a></div>
                    </li>
                </ul>
            </nav>
        </div>
        <div id="overall">
            <ul id="options" class="nav nav-tabs" role="tablist">
                <li class="nav-item" role="presentation">
                    <button id="cart-tab" data-bs-target="#customer-cart" data-bs-toggle="tab" aria-selected="true" role="tab"  aria-controls="customer-cart" aria-current="page" class="nav-link active">Giỏ hàng</button>
                </li>
                <li class="nav-item" role="presentation">
                    <button id="history-tab" data-bs-target="#order-history" data-bs-toggle="tab" aria-selected="false" role="tab" aria-controls="order-history" aria-current="page" class="nav-link">Lịch sử mua hàng</button>
                </li>
            </ul>
            <div class="tab-content">
                <div id="customer-cart" class="tab-pane fade show active" role="tabpanel" aria-labelledby="cart-tab">
                    <div id="whiteboard2" class="col-8 bg-light">                     
                        <span class="d-inline-block col-7 mt-4 mb-4 text-start">Giỏ hàng của bạn</span>                      
                        <div class="d-inline-block col-4 mt-4 mb-4 text-end">
                            <span>Voucher : <span class="nav-link text-muted d-inline-block col-4" data-bs-toggle="modal" data-bs-target="#voucherModal">
                                    Chọn voucher                                  
                                </span></span>                       
                            <div class="modal fade" id="voucherModal" tabindex="-1" aria-labelledby="choose1Voucher" aria-hidden="true">
                                <div class="modal-dialog modal-xl">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title m-3" id="choose1Voucher">Chọn voucher quý khách muốn sử dụng</h5>
                                            <button type="button" class="btn-close m-3" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            <div class="row row-cols-4 container-fluid m-0">
                                                <div id="voucher" class="d-inline-block col mb-4 text-center">
                                                    <img src="img/voucher.png">
                                                    <h6 class="text-center">TÊN VOUCHER</h6>
                                                    <a><button type="button" id="buy-button" class="col-6" data-bs-dismiss="modal">Sử dụng</button></a>
                                                </div>
                                                <div id="voucher" class="d-inline-block col mb-4 text-center">
                                                    <img src="img/voucher.png">
                                                    <h6 class="text-center">TÊN VOUCHER</h6>
                                                    <a><button type="button" id="buy-button" class="col-6" data-bs-dismiss="modal">Sử dụng</button></a>
                                                </div>
                                                <div id="voucher" class="d-inline-block col mb-4 text-center">
                                                    <img src="img/voucher.png">
                                                    <h6 class="text-center">TÊN VOUCHER</h6>
                                                    <a><button type="button" id="buy-button" class="col-6" data-bs-dismiss="modal">Sử dụng</button></a>
                                                </div>
                                                <div id="voucher" class="d-inline-block col mb-4 text-center">
                                                    <img src="img/voucher.png">
                                                    <h6 class="text-center">TÊN VOUCHER</h6>
                                                    <a><button type="button" id="buy-button" class="col-6" data-bs-dismiss="modal">Sử dụng</button></a>
                                                </div>
                                                <div id="voucher" class="d-inline-block col mb-4 text-center">
                                                    <img src="img/voucher.png">
                                                    <h6 class="text-center">TÊN VOUCHER</h6>
                                                    <a><button type="button" id="buy-button" class="col-6" data-bs-dismiss="modal">Sử dụng</button></a>
                                                </div>                                                   
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Huỷ</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <c:forEach items="${sessionScope.CART}" var="product">
                            <div id="cart-item" class="rounded col-11 m-auto mb-3">
                                <div class="row container-fluid m-0">
                                    <div class="d-inline-block col-2 text-start">
                                        <img src="${product.img}" class="rounded w-100">
                                    </div>     
                                    <div class="d-inline-block col-8 text-start ms-5 mt-4">
                                        <h4 class="fw-bold">${product.productName}</h4>
                                        <span>
                                            <c:if test="${not empty product.discountPrice}">
                                                ${product.discountPrice}&nsbp;<span class="text-danger text-decoration-line-through">${product.price}</span>
                                            </c:if>
                                            <c:if test="${empty product.discountPrice}">${product.price}</c:if>
                                        </span>                                       
                                        <div id="number-toggle" class="text-end">
                                            <div class="input-group d-inline-block">
                                                <form>
                                                    <img src="img/plus.svg" data-field="quantity" class="button-plus d-inline-block">
                                                    <input required id="number-input" type="number" step="1" value="1" min="1" max="100" onblur="minCheck(this), maxCheck(this)" name="quantity" class="quantity-field text-center p-0">
                                                    <img src="img/minus.svg" data-field="quantity" class="button-minus d-inline-block"><br>                                    
                                                    <h5 class="fw-bold text-end mt-1">2,850,000</h5>
                                                </form>                                          
                                            </div>
                                        </div>
                                    </div> 
                                    <div class="d-inline-block col-1 ms-auto">
                                        <a href="" class="mt-3 nav-link"><i class="fa-solid fa-xmark fa-2xl me-0"></i></a>
                                    </div>
                                </div>  
                            </div>
                        </c:forEach>

                        <div id="cart-item" class="rounded col-11 m-auto mb-3">
                            <div class="row container-fluid m-0">
                                <div class="d-inline-block col-2 text-start">
                                    <img src="img/product1.png" class="rounded w-100">
                                </div>     
                                <div class="d-inline-block col-8 text-start ms-5 mt-4">
                                    <h4 class="fw-bold">Tổ yến thô cao cấp tiêu chuẩn 100g</h4>
                                    <span>2,850,000 ₫</span>
                                    <div id="number-toggle" class="text-end">
                                        <div class="input-group d-inline-block">
                                            <form>
                                                <img src="img/plus.svg" data-field="quantity" class="button-plus d-inline-block">
                                                <input required id="number-input" type="number" step="1" value="1" min="1" max="100" onblur="minCheck(this), maxCheck(this)" name="quantity" class="quantity-field text-center p-0">
                                                <img src="img/minus.svg" data-field="quantity" class="button-minus d-inline-block"><br>                                    
                                                <h5 class="fw-bold text-end mt-1">2,850,000</h5>
                                            </form>                                          
                                        </div>
                                    </div>
                                </div> 
                                <div class="d-inline-block col-1 ms-auto">
                                    <a href="" class="mt-3 nav-link"><i class="fa-solid fa-xmark fa-2xl me-0"></i></a>
                                </div>
                            </div>  
                        </div>                      
                        <div class="fs-4 d-flex justify-content-between pb-3">
                            <span class="ms-5 d-inline-block align-self-center">Thành tiền :<span class="fw-bold"> 100$</span></span> 
                            <form action="checkOutAction" method="POST">
                                <input type="hidden" value="" id="voucher-use">
                                <button id="buy-button" class="btn ms-auto mt-0 me-5">Thanh toán</button>
                            </form>
                        </div>
                    </div>
                </div>
                <div id="order-history" class="tab-pane fade" role="tabpanel" aria-labelledby="history-tab">
                    <div id="whiteboard2" class="col-8 bg-light">
                        <ul id="options" class="nav nav-tabs border-0 p-3" role="tablist">
                            <li class="nav-item w-25 m-0" role="presentation">
                                <button id="delivering-tab" data-bs-target="#delivering" data-bs-toggle="tab" aria-selected="true" role="tab"  aria-controls="delivering" aria-current="page" class="nav-link active container-fluid">Đang giao</button>
                            </li>
                            <li class="nav-item w-25 m-0" role="presentation">
                                <button id="delivered-tab" data-bs-target="#delivered" data-bs-toggle="tab" aria-selected="false" role="tab" aria-controls="delivered" aria-current="page" class="nav-link container-fluid">Đã giao / Đã huỷ</button>
                            </li>
                        </ul>
                        <div class="tab-content">
                            <div id="delivering" class="tab-pane fade show active pb-3" role="tabpanel" aria-labelledby="delivering-tab">                              
                                <div id="cart-item" class="rounded col-11 m-auto mb-3">
                                    <div class="row container-fluid m-0">
                                        <div class="d-inline-block col-2 text-start">
                                            <img src="img/product1.png" class="rounded w-100">
                                        </div>     
                                        <div class="d-inline-block col-8 text-start ms-5 mt-4">
                                            <h4 class="fw-bold">Tổ yến thô cao cấp tiêu chuẩn 100g</h4>
                                            <font color="green"> Chờ xác nhận</font>
                                            <p class="mt-1 mb-0">Số lượng : <span class="fw-bold">3</span></p>
                                            <p>Thành tiền : <span class="fw-bold">2,850,000đ</span></p>
                                        </div> 
                                        <div class="d-inline-block col-1 ms-auto">
                                            <a href="" class="mt-3 nav-link"><i class="fa-solid fa-xmark fa-2xl me-0"></i></a>
                                        </div>
                                    </div>  
                                </div>
                                <div id="cart-item" class="rounded col-11 m-auto mb-3">
                                    <div class="row container-fluid m-0">
                                        <div class="d-inline-block col-2 text-start">
                                            <img src="img/product1.png" class="rounded w-100">
                                        </div>     
                                        <div class="d-inline-block col-8 text-start ms-5 mt-4">
                                            <h4 class="fw-bold">Tổ yến thô cao cấp tiêu chuẩn 100g</h4>
                                            <font color="green"> Chờ xác nhận</font>
                                            <p class="mt-1 mb-0">Số lượng : <span class="fw-bold">3</span></p>
                                            <p>Thành tiền : <span class="fw-bold">2,850,000đ</span></p>
                                        </div> 
                                        <div class="d-inline-block col-1 ms-auto">
                                            <a href="" class="mt-3 nav-link"><i class="fa-solid fa-xmark fa-2xl me-0"></i></a>
                                        </div>
                                    </div>  
                                </div>
                                <div id="cart-item" class="rounded col-11 m-auto mb-3">
                                    <div class="row container-fluid m-0">
                                        <div class="d-inline-block col-2 text-start">
                                            <img src="img/product1.png" class="rounded w-100">
                                        </div>     
                                        <div class="d-inline-block col-8 text-start ms-5 mt-4">
                                            <h4 class="fw-bold">Tổ yến thô cao cấp tiêu chuẩn 100g</h4>
                                            <font color="green"> Chờ xác nhận</font>
                                            <p class="mt-1 mb-0">Số lượng : <span class="fw-bold">3</span></p>
                                            <p>Thành tiền : <span class="fw-bold">2,850,000đ</span></p>
                                        </div> 
                                        <div class="d-inline-block col-1 ms-auto">
                                            <a href="" class="mt-3 nav-link"><i class="fa-solid fa-xmark fa-2xl me-0"></i></a>
                                        </div>
                                    </div>  
                                </div> 
                            </div>
                            <div id="delivered" class="tab-pane fade pb-3" role="tabpanel" aria-labelledby="delivered-tab">
                                <div id="cart-item" class="rounded col-11 m-auto mb-3">
                                    <div class="row container-fluid m-0">
                                        <div class="d-inline-block col-2 text-start">
                                            <img src="img/product1.png" class="rounded w-100">
                                        </div>     
                                        <div class="d-inline-block col-8 text-start ms-5 mt-4">
                                            <h4 class="fw-bold">Tổ yến thô cao cấp tiêu chuẩn 100g</h4>
                                            <p class="mt-1 mb-0">Số lượng : <span class="fw-bold">3</span></p>
                                            <p>Thành tiền : <span class="fw-bold">2,850,000đ</span></p>
                                            <font color="red">(Đã huỷ)</font>
                                        </div> 
                                    </div>  
                                </div>
                                <div id="cart-item" class="rounded col-11 m-auto mb-3">
                                    <div class="row container-fluid m-0">
                                        <div class="d-inline-block col-2 text-start">
                                            <img src="img/product1.png" class="rounded w-100">
                                        </div>     
                                        <div class="d-inline-block col-8 text-start ms-5 mt-4">
                                            <h4 class="fw-bold">Tổ yến thô cao cấp tiêu chuẩn 100g</h4>
                                            <p class="mt-1 mb-0">Số lượng : <span class="fw-bold">3</span></p>
                                            <p>Thành tiền : <span class="fw-bold">2,850,000đ</span></p>
                                        </div> 
                                    </div>  
                                </div>
                                <div id="cart-item" class="rounded col-11 m-auto mb-3">
                                    <div class="row container-fluid m-0">
                                        <div class="d-inline-block col-2 text-start">
                                            <img src="img/product1.png" class="rounded w-100">
                                        </div>     
                                        <div class="d-inline-block col-8 text-start ms-5 mt-4">
                                            <h4 class="fw-bold">Tổ yến thô cao cấp tiêu chuẩn 100g</h4>
                                            <p class="mt-1 mb-0">Số lượng : <span class="fw-bold">3</span></p>
                                            <p>Thành tiền : <span class="fw-bold">2,850,000đ</span></p>
                                        </div> 
                                    </div>  
                                </div>
                            </div>
                        </div>            
                    </div>
                </div>
            </div>            
        </div>

    </div> 
    <div id="whiteboard2" class="bg-light col-8 accordion">
        <h4 class="text-start p-4">Các gợi ý khác</h4>
        <div class="row row-cols-4">
            <div id="voucher" class="d-inline-block col mb-4">
                <img src="img/voucher.png">
                <h6>TÊN VOUCHER</h6>
                <span>Giá sản phẩm</span><br>
                <a href="buyVoucher"><button id="buy-button" class="col-6">Mua ngay</button></a>
            </div>
            <div id="voucher" class="d-inline-block col mb-4">
                <img src="img/voucher.png">
                <h6>TÊN VOUCHER</h6>
                <span>Giá sản phẩm</span><br>
                <a href="buyVoucher"><button id="buy-button" class="col-6">Mua ngay</button></a>
            </div>
            <div id="voucher" class="d-inline-block col mb-4">
                <img src="img/voucher.png">
                <h6>TÊN VOUCHER</h6>
                <span>Giá sản phẩm</span><br>
                <a href="buyVoucher"><button id="buy-button" class="col-6">Mua ngay</button></a>
            </div>
            <div id="voucher" class="d-inline-block col mb-4">
                <img src="img/voucher.png">
                <h6>TÊN VOUCHER</h6>
                <span>Giá sản phẩm</span><br>
                <a href="buyVoucher"><button id="buy-button" class="col-6">Mua ngay</button></a>
            </div>           
        </div>
    </div>
    <script src="js/productDetail.js"></script>   
</body>

</html>
