<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
		<!DOCTYPE html>
		<html lang="en">

		<head>
			<title>Product Details</title>
			<meta charset="UTF-8">
			<meta name="viewport" content="width=device-width, initial-scale=1">
			<!--===============================================================================================-->
			<link rel="icon" type="image/png" href="/user/images/icons/favicon.png" />
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

			<!-- SweetAlert2 CSS -->
			<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11.1.0/dist/sweetalert2.min.css">

			<!-- SweetAlert2 JS -->
			<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.1.0/dist/sweetalert2.min.js"></script>

			<!--===============================================================================================-->


			<style>
				.radio-group label {
					display: inline-block;
					margin-right: 20px;
					/* Khoảng cách giữa radio button và chữ */
					vertical-align: middle;
					/* Canh chỉnh chữ theo chiều dọc của radio button */
				}

				.form-group {
					display: flex;
					align-items: center;
					margin-bottom: 10px;
				}

				.form-group label {
					width: 100px;
					/* Chiều rộng của nhãn */
					margin-right: 10px;
					/* Khoảng cách giữa nhãn và input */
				}
			</style>
		</head>

		<body class="animsition">

			<!-- Header -->
			<header class="header-v4">
				<%@include file="../user/components/header.jsp" %>
			</header>

			<!-- Cart -->

			<%@include file="../user/components/miniCart.jsp" %>



				<section class="sec-product-detail bg0 p-t-65 p-b-60">
					<div class="container">
						<form action="/product/addToCart" method="post">
							<input type="hidden" name="productId" value="${pro_id}">

							<div class="wrap-pic-w pos-relative">
								<img src="/images/${detail_image}" alt="IMG-PRODUCT" style="height: 250px; width: 250px" >
							</div>

							<div class="radio-group">
								<label for="size">Size:</label>
								<c:forEach var="size" items="${sizes}">
									<label>
										<input type="radio" id="size${size.sizeId}" name="size" value="${size.sizeId}">
										${size.sizeName}
									</label>
								</c:forEach>
							</div>

							<div class="radio-group">
								<label for="size">Size:</label>
								<c:forEach var="color" items="${colors}">
									<label>
										<input type="radio" id="color${color.colorId}" name="color"
											value="${color.colorId}">
										${color.colorName}
									</label>
								</c:forEach>
							</div>

							<div class="form-group">
								<label for="qty">Quantity:</label>
								<input type="number" id="qty" name="qty" value="1" min="1">
							</div>

							<button type="submit">Add to Cart</button>
						</form>

					</div>
				</section>


				<!-- Footer -->

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
					<script>
						$(".js-select2").each(function () {
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
						$('.gallery-lb').each(function () { // the containers for all your galleries
							$(this).magnificPopup({
								delegate: 'a', // the selector for gallery item
								type: 'image',
								gallery: {
									enabled: true
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
						$('.js-addwish-b2, .js-addwish-detail').on('click', function (e) {
							e.preventDefault();
						});

						$('.js-addwish-b2').each(function () {
							var nameProduct = $(this).parent().parent().find('.js-name-b2').html();
							$(this).on('click', function () {
								swal(nameProduct, "đã thêm vào danh sách yêu thích !", "success");

								$(this).addClass('js-addedwish-b2');
								$(this).off('click');
							});
						});

						$('.js-addwish-detail').each(function () {
							var nameProduct = $(this).parent().parent().parent().find('.js-name-detail').html();

							$(this).on('click', function () {
								swal(nameProduct, "đã thêm vào danh sách yêu thích !", "success");

								$(this).addClass('js-addedwish-detail');
								$(this).off('click');
							});
						});

						/*---------------------------------------------*/

						$('.js-addcart-detail').each(function () {
							var nameProduct = $(this).parent().parent().parent().parent().find('.js-name-detail').html();
							$(this).on('click', function () {
								swal(nameProduct, "đã thêm vào giỏ hàng !", "success");
							});
						});

					</script>
					<!--===============================================================================================-->
					<script src="/user/vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
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
					<!--===============================================================================================-->


					<script src="/user/js/main.js"></script>

		</body>

		</html>