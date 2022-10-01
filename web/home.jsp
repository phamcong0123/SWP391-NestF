<%-- 
    Document   : newjsp1
    Created on : Sep 20, 2022, 3:59:53 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                <nav class="navbar-expand bg-light navbar-light text-center">
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
                            <div>
                                <c:if test="${not empty sessionScope.CUSTOMER}">
                                    <a href="accountPage" class="nav-link text-center">
                                        <i class="fas fa-user    "></i>${sessionScope.CUSTOMER.customerName}
                                    </a>
                                </c:if>
                                <c:if test="${empty sessionScope.CUSTOMER}"><a href="loginPage" class="nav-link"><i class="fas fa-user    "></i>Đăng nhập</a>
                                </c:if>
                            </div>
                        </li>
                        <li class="nav-item col-1 d-inline-block text-center">
                            <div> 
                                <c:if test="${not empty sessionScope.CUSTOMER}">
                                    <a href="cartPage" class="nav-link text-center"><i class="fa-solid fa-cart-shopping"></i>
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

                <div class="best-sell-container">
                    <div class="bestsell-container-spacing pt-3">
                        <div class="bestsell-header-section ms-3">
                            <h3>Sản phẩm bán chạy</h3>
                        </div>
                        <div class="bestsell-section-content">
                            <div class="image-collapse">
                                <ul class="image-list row">
                                    <li class="image-contain col-lg-3 col-md-6">
                                        <div class="image-contain-section mx-2">
                                            <div class="image-contain-detail">
                                                <a href="productDetail?productID=9" class="product-detail">
                                                    <img src="https://yensaokhanhhoa.vn/wp-content/uploads/2022/06/lifenest-yen-sao-tinh-che-vuong-7-2.jpg"
                                                         alt="..." class="mx-2">
                                                    <p class="image-title">Yến tinh chế vuông đặc biệt 100g<br><span
                                                            class="image-price">3.600.000 đ</span></p>
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
                                    <li class="image-contain col-lg-3 col-md-6">
                                        <div class="image-contain-section mx-2">
                                            <div class="image-contain-detail">
                                                <a href="productDetail?productID=6" class="product-detail">
                                                    <img src="https://yensaokhanhhoa.vn/wp-content/uploads/2022/06/yen-rut-long-kho.png"
                                                         alt="..." class="mx-2">
                                                    <p class="image-title">Tổ yến rút lông khô thượng hạng 100g<br><span
                                                            class="image-price">5.500.000 đ</span></p>
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
                                    <li class="image-contain col-lg-3 col-md-6">
                                        <div class="image-contain-section mx-2">
                                            <div class="image-contain-detail">
                                                <a href="productDetail?productID=8" class="product-detail">
                                                    <img src="https://yensaokhanhhoa.vn/wp-content/uploads/2022/06/chan-yen-tinh-che-dac-biet.jpg"
                                                         alt="..." class="mx-2">
                                                    <p class="image-title">Chân yến tinh chế đặc biệt 100g<br><span
                                                            class="image-price">4.050.000 đ</span></p>
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
                                    <li class="image-contain col-lg-3 col-md-6">
                                        <div class="image-contain-section mx-2">
                                            <div class="image-contain-detail">
                                                <a href="productDetail?productID=10" class="product-detail">
                                                    <img src="https://yensaokhanhhoa.vn/wp-content/uploads/2022/06/70ml-img.jpg"
                                                         alt="..." class="mx-2">
                                                    <p class="image-title">COMBO 6 chai yến chưng tươi 70ml<br><span
                                                            class="image-price">650.000 đ</span></p>
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
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="combo-product">
                    <div class="combo-product-spacing d-flex">
                        <div class="combo-product-describe">
                            <h5 class="combo-title">Combo nổi bật</h5>
                            <p>COMBO 6 chai yến chưng tươi 70ml: <span class="product-price">650.000 đ</span></p>
                            <p>Yến tinh chế vuông đặc biệt 100g <span class="product-price">3.600.000 đ</span></p>
                        </div>
                        <div class="combo-product-image">
                            <img src="https://yensaokhanhhoa.vn/wp-content/uploads/2022/06/70ml-img.jpg" alt="..."
                                 class="ms-2">
                            <span class="plus-product-img">
                                <i class="fa-solid fa-plus"></i>
                            </span>
                            <img src="https://yensaokhanhhoa.vn/wp-content/uploads/2022/06/lifenest-yen-sao-tinh-che-vuong-7-2.jpg"" alt="..."
                                 class="ms-2">
                        </div>
                        <div class="combo-product-btn">
                            <p>Chỉ với 2.000.000 VNĐ</p>
                            <a href="#">
                                <button class="btn btn-dark">
                                    <i class="fa-solid fa-cart-shopping"></i> Thêm vào giỏ
                                </button>
                            </a>
                        </div>
                    </div>
                </div>

                <div class="another-suggestion mb-3">
                    <div class="another-suggestion-spacing">                       
                        <div class="suggestion-content-section pt-3 pb-3">
                            <div class="suggestion-header-section ms-3">
                                <h4>Các gợi ý khác</h4>
                            </div>
                            <div class="image-collapse">
                                <ul class="another-image-list row">
                                    <li class="image-contain col-lg-3 col-md-6">
                                        <div class="another-image-contain-section">
                                            <div class="image-contain-detail">
                                                <a href="#" class="product-detail">
                                                    <img src="https://yensaokhanhhoa.vn/wp-content/uploads/2022/06/yen-tho-cao-cap.png"
                                                         alt="..." class="mx-2">
                                                    <p class="image-title">Tổ yến thô cao cấp tiêu chuẩn 100g<br><span
                                                            class="image-price">1.000.000 VNĐ</span></p>
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
                                    <li class="image-contain col-lg-3 col-md-6">
                                        <div class="another-image-contain-section">
                                            <div class="image-contain-detail">
                                                <a href="#" class="product-detail">
                                                    <img src="https://yensaokhanhhoa.vn/wp-content/uploads/2022/06/Tinh-che-dac-biet.png"
                                                         alt="..." class="mx-2">
                                                    <p class="image-title">Tổ yến tinh chế đặc biệt 100g<br><span
                                                            class="image-price">1.000.000 VNĐ</span></p>
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
                                    <li class="image-contain col-lg-3 col-md-6">
                                        <div class="another-image-contain-section">
                                            <div class="image-contain-detail">
                                                <a href="#" class="product-detail">
                                                    <img src="https://yensaokhanhhoa.vn/wp-content/uploads/2022/06/yen-tho-dac-biet.png"
                                                         alt="..." class="mx-2">
                                                    <p class="image-title">Tổ yến thô đặc biệt tiêu chuẩn 100g<br><span
                                                            class="image-price">1.000.000 VNĐ</span></p>
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
                                    <li class="image-contain col-lg-3 col-md-6">
                                        <div class="another-image-contain-section">
                                            <div class="image-contain-detail">
                                                <a href="#" class="product-detail">
                                                    <img src="https://yensaokhanhhoa.vn/wp-content/uploads/2022/06/tinh-che-soi-cao-cap.png"
                                                         alt="..." class="mx-2">
                                                    <p class="image-title">Tổ yến tinh chế cao cấp 100g<br><span
                                                            class="image-price">1.000.000 VNĐ</span></p>
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
                                </ul>
                                <a href="ShopPageController" class="all-product">
                                    Tất cả sản phẩm
                                </a>
                            </div>
                        </div>
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
