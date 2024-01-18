<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <!-- Meta Data -->

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Comercio - Fashion Shop Ecommerce HTML Template</title>

    <!-- Fav Icon -->
    <link rel="apple-touch-icon" sizes="180x180" href="/login/assets/img/fav-icons/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="/login/assets/img/fav-icons/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="/login/assets/img/fav-icons/favicon-16x16.png">

    <!-- Dependency Styles -->
    <link rel="stylesheet" href="/login/dependencies/bootstrap/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="/login/dependencies/fontawesome/css/fontawesome-all.min.css" type="text/css">
    <link rel="stylesheet" href="/login/dependencies/owl.carousel/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="/login/dependencies/owl.carousel/css/owl.theme.default.min.css" type="text/css">
    <link rel="stylesheet" href="/login/dependencies/flaticon/css/flaticon.css" type="text/css">
    <link rel="stylesheet" href="/login/dependencies/wow/css/animate.css" type="text/css">
    <link rel="stylesheet" href="/login/dependencies/jquery-ui/css/jquery-ui.css" type="text/css">
    <link rel="stylesheet" href="/login/dependencies/venobox/css/venobox.css" type="text/css">
    <link rel="stylesheet" href="/login/dependencies/slick-carousel/css/slick.css" type="text/css">

    <!-- Site Stylesheet -->
    <link rel="stylesheet" href="/login/assets/css/app.css" type="text/css">

    <!-- Site Stylesheet -->
    <link rel="stylesheet" href="/login/assets/css/app.css" type="text/css">

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

</head>

<body class="animsition">
<header class="header-v4">
    <%@include file="../user/components/header.jsp"%>
</header>

<!-- Cart -->
<%@include file="../user/components/cart.jsp"%>
<%@include file="../user/components/miniCart.jsp"%>


<section class="contact-area">
    <div class="container-fluid custom-container">
        <div class="section-heading pb-30">
            <h3>ĐĂNG <span>NHẬP</span></h3>
        </div>
        <div class="row justify-content-center">
            <div class="col-sm-9 col-md-8 col-lg-6 col-xl-4">
                <div class="contact-form login-form">
                    <form action="#">
                        <div class="row">
                            <div class="col-xl-12">
                                <input type="text" placeholder="Email*">
                            </div>
                            <div class="col-xl-12">
                                <input type="text" placeholder="Mật khẩu*">

                            </div>
                            <div class="col-xl-12">
                                <input type="submit" value="ĐĂNG NHẬP">
                                <br>

                                <a href="/forgot" class="">Quên mật khẩu?</a>

                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- /.row end -->
    </div>
    <!-- /.container-fluid end -->
</section>
<!-- /.contact-area end -->

<section class="login-now">
    <div class="container-fluid custom-container">
        <div class="col-12">
            <span>Không có tài khoản</span>
            <a href="/create" class="btn-two">ĐĂNG KÝ</a>
        </div>
        <!-- /.col-12 -->
    </div>
    <!-- /.container-fluid -->
</section>
<!-- /.login-now -->
<%@include file="../user/components/footer.jsp"%>

<script data-cfasync="false" src="../../cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script><script src="dependencies/jquery/jquery.min.js"></script>
<script src="/login/dependencies/popper.js/popper.min.js"></script>
<script src="/login/dependencies/bootstrap/js/bootstrap.min.js"></script>
<script src="/login/dependencies/owl.carousel/js/owl.carousel.min.js"></script>
<script src="/login/dependencies/wow/js/wow.min.js"></script>
<script src="/login/dependencies/isotope-layout/js/isotope.pkgd.min.js"></script>
<script src="/login/dependencies/imagesloaded/js/imagesloaded.pkgd.min.js"></script>
<script src="/login/dependencies/jquery.countdown/js/jquery.countdown.min.js"></script>
<script src="/login/dependencies/gmap3/js/gmap3.min.js"></script>
<script src="/login/dependencies/venobox/js/venobox.min.js"></script>
<script src="/login/dependencies/slick-carousel/js/slick.js"></script>
<script src="/login/dependencies/headroom/js/headroom.js"></script>
<script src="/login/dependencies/jquery-ui/js/jquery-ui.min.js"></script>
<!--Google map api -->
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBsBrMPsyNtpwKXPPpG54XwJXnyobfMAIc"></script>


<!-- Site Scripts -->
<script src="/login/assets/js/app.js"></script>


<!--===============================================================================================-->
<script src="/user/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="/user/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
<script src="/user/vendor/bootstrap/js/popper.js"></script>
<script src="/user/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="/user/vendor/select2/select2.min.js"></script>
<script>
    $(".js-select2").each(function(){
        $(this).select2({
            minimumResultsForSearch: 20,
            dropdownParent: $(this).next('.dropDownSelect2')
        });
    })
</script>
<!--===============================================================================================-->
<script src="/user/vendor/daterangepicker/moment.min.js"></script>
<script src="/user/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
<script src="/user/vendor/slick/slick.min.js"></script>
<script src="/user/js/slick-custom.js"></script>
<!--===============================================================================================-->
<script src="/user/vendor/parallax100/parallax100.js"></script>
<script>
    $('.parallax100').parallax100();
</script>
<!--===============================================================================================-->
<script src="/user/vendor/MagnificPopup/jquery.magnific-popup.min.js"></script>
<script>
    $('.gallery-lb').each(function() { // the containers for all your galleries
        $(this).magnificPopup({
            delegate: 'a', // the selector for gallery item
            type: 'image',
            gallery: {
                enabled:true
            },
            mainClass: 'mfp-fade'
        });
    });
</script>
<!--===============================================================================================-->
<script src="/user/vendor/isotope/isotope.pkgd.min.js"></script>
<!--===============================================================================================-->
<script src="/user/vendor/sweetalert/sweetalert.min.js"></script>
<script>
    $('.js-addwish-b2, .js-addwish-detail').on('click', function(e){
        e.preventDefault();
    });

    $('.js-addwish-b2').each(function(){
        var nameProduct = $(this).parent().parent().find('.js-name-b2').html();
        $(this).on('click', function(){
            swal(nameProduct, "đã thêm vào danh sách yêu thích !", "success");

            $(this).addClass('js-addedwish-b2');
            $(this).off('click');
        });
    });

    $('.js-addwish-detail').each(function(){
        var nameProduct = $(this).parent().parent().parent().find('.js-name-detail').html();

        $(this).on('click', function(){
            swal(nameProduct, "đã thêm vào danh sách yêu thích !", "success");

            $(this).addClass('js-addedwish-detail');
            $(this).off('click');
        });
    });

    /*---------------------------------------------*/

    $('.js-addcart-detail').each(function(){
        var nameProduct = $(this).parent().parent().parent().parent().find('.js-name-detail').html();
        $(this).on('click', function(){
            swal(nameProduct, "đã thêm vào giỏ hàng !", "success");
        });
    });

</script>
<!--===============================================================================================-->
<script src="/user/vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
<script>
    $('.js-pscroll').each(function(){
        $(this).css('position','relative');
        $(this).css('overflow','hidden');
        var ps = new PerfectScrollbar(this, {
            wheelSpeed: 1,
            scrollingThreshold: 1000,
            wheelPropagation: false,
        });

        $(window).on('resize', function(){
            ps.update();
        })
    });
</script>
<!--===============================================================================================-->
<script src="/user/js/main.js"></script>

</body>
</html>