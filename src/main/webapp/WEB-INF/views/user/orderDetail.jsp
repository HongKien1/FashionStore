<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>About</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="/user/images/icons/favicon.png"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/user/vendor/bootstrap/css/bootstrap.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/user/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/user/fonts/iconic/css/material-design-iconic-font.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/user/fonts/linearicons-v1.0.0/icon-font.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/user/vendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/user/vendor/css-hamburgers/hamburgers.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/user/vendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/user/vendor/daterangepicker/daterangepicker.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/user/vendor/slick/slick.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/user/vendor/MagnificPopup/magnific-popup.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/user/vendor/perfect-scrollbar/perfect-scrollbar.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/user/css/util.css">
    <link rel="stylesheet" type="text/css" href="/user/css/main.css">
    <!--===============================================================================================-->
</head>
<body class="animsition">

<!-- Header -->
<header class="header-v4">
    <%@include file="../user/components/header.jsp" %>
</header>

<!-- Cart -->
<%@include file="../user/components/miniCart.jsp" %>


<!-- Title page -->
<section class="bg-img1 txt-center p-lr-15 p-tb-92" style="background-image: url('/user/images/bg-01.jpg');">
    <h2 class="ltext-105 cl0 txt-center">

    </h2>
</section>

<section class="bg0 p-t-104 p-b-116">
    <div class="container">
        <div class="flex-w flex-tr">
            <div class="size-210 bor10 p-lr-70 p-t-55 p-b-70 p-lr-15-lg w-full-md">
                <form>
                    <h4 class="mtext-105 cl2 txt-center p-b-30">
                        Đặt hàng
                    </h4>

                    <label for="address">Tên</label>
                    <div class="bor8 m-b-20 how-pos4-parent">
                        <input class="stext-111 cl2 plh3 size-116 p-l-10 p-r-30" type="text" name="email"
                               placeholder="Nhập tên">
                    </div>
                    <label for="address">Số điện thoại</label>
                    <div class="bor8 m-b-20 how-pos4-parent">
                        <input class="stext-111 cl2 plh3 size-116 p-l-10 p-r-30" type="text" name="email"
                               placeholder="Nhập số điện thoại">
                    </div>

                    <label for="address">Chọn Tỉnh :</label>
                    <select class="form-control mb-4" id="address" name="address">
                        <option value="hn">Hà Nội</option>
                        <option value="hcm">Hồ Chí Minh</option>
                        <option value="dn">Đà Nẵng</option>
                    </select>
                    <label for="address">Chọn huyện :</label>
                    <select class="form-control mb-4" id="" name="address">
                        <option value="hn">Ninh Kiều</option>
                        <option value="hcm">Cái Răng</option>
                        <option value="dn">Đà Nẵng</option>
                    </select>

                    <label for="address">Chi tiết địa chỉ</label>
                    <div class="bor8 m-b-20">
                        <input class="stext-111 cl2 plh3 size-116 p-l-10 p-r-30" type="text" name="email">
                    </div>

                    <div class="bor8 m-b-30">
                        <textarea class="stext-111 cl2 plh3 size-120 p-lr-10 p-tb-25" name="msg"
                                  placeholder="Nhập ghi chú"></textarea>
                    </div>


                </form>
            </div>

            <div class="size-210 bor10 flex-w flex-col-m p-lr-93 p-tb-30 p-lr-15-lg w-full-md">
                <h4 class="mtext-109 cl2 p-b-30">
                    Tổng giỏ hàng
                </h4>

                <div class="flex-w flex-t bor12 p-b-13">
                    <div class="size-208">
								<span class="stext-110 cl2">
									Thành tiền
								</span>
                    </div>

                    <div class="size-209">
								<span class="mtext-110 cl2">
									${totalPrice}
								</span>
                    </div>
                </div>

                <div class="header-cart-content flex-w js-pscroll">
                    <ul class="header-cart-wrapitem w-full">
                        <c:forEach var="cartDetail" items="${cartDetailsPayment}" >
                            <li class="header-cart-item flex-w flex-t m-b-12">
                                <div class="header-cart-item-img">
                                    <img src="/images/${cartDetail.productdetails.product.image}" alt="IMG">
                                </div>

                                <div class="header-cart-item-txt p-t-8">
                                    <a href="#" class="header-cart-item-name m-b-18 hov-cl1 trans-04">
                                        ${cartDetail.productdetails.product.name},
                                        ${cartDetail.productdetails.size.size_name} ,
                                        ${cartDetail.productdetails.color.color}
                                    </a>
                                    <span class="header-cart-item-info"> ${cartDetail.quantity} x ${cartDetail.productdetails.product.price} </span>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>

                </div>

                <div class="flex-w flex-t p-t-27 p-b-33">
                    <div class="size-208">
								<span class="mtext-101 cl2">
									Tổng tiền:
								</span>
                    </div>

                    <div class="size-209 p-t-1">
								<span class="mtext-110 cl2">
									${totalPrice}
								</span>
                    </div>
                </div>

                <a href="#" onclick="handleBuyButtonClick()"
                   class="flex-c-m stext-101 cl0 size-116 bg3 bor14 hov-btn3 p-lr-15 trans-04 pointer js-add-cart-detail">
                    Mua hàng
                </a>
            </div>
        </div>
    </div>
</section>

<%@include file="../user/components/footer.jsp" %>


<!-- Back to top -->
<div class="btn-back-to-top" id="myBtn">
		<span class="symbol-btn-back-to-top">
			<i class="zmdi zmdi-chevron-up"></i>
		</span>
</div>

<!--===============================================================================================-->
<script src="/user/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="/user/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
<script src="/user/vendor/bootstrap/js/popper.js"></script>
<script src="/user/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="/user/vendor/select2/select2.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
<script>
    $(".js-select2").each(function () {
        $(this).select2({
            minimumResultsForSearch: 20,
            dropdownParent: $(this).next('.dropDownSelect2')
        });
    })
</script>
<!--===============================================================================================-->
<script src="/user/vendor/MagnificPopup/jquery.magnific-popup.min.js"></script>
<!--===============================================================================================-->
<script src="/user/vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
<script src="/user/vendor/sweetalert/sweetalert.min.js"></script>
<script>
    $('.js-pscroll').each(function () {
        $(this).css('position', 'relative');
        $(this).css('overflow', 'hidden');
        var ps = new PerfectScrollbar(this, {
            wheelSpeed: 1,
            scrollingThreshold: 1000,
            wheelPropagation: false,
        });

        $(window).on('resize', function () {
            ps.update();
        })
    });
</script>
<script>

    function handleBuyButtonClick() {
        Swal.fire({
            icon: 'success',
            title: 'Mua hàng thành công!',
            showConfirmButton: false,
            timer: 1500
        });
        this.setTimeout(
            function () {
                window.location.href = "/index";
            }, 1500);
    }
</script>

<script>
    $('.js-add-cart-detail').each(function () {
        var nameProduct = $(this).parent().parent().parent().parent().find('.js-name-detail').html();
        $(this).on('click', function () {
            swal(nameProduct, "đã thêm vào giỏ hàng !", "success");
        });
    });
</script>
<!--===============================================================================================-->
<script src="/user/js/main.js"></script>

</body>
</html>