<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Account</title>
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
		<%@include file="../user/components/header.jsp"%>
	</header>

	<!-- Cart -->

	<%@include file="../user/components/miniCart.jsp"%>
	<!-- Title page -->
	<section class="bg-img1 txt-center p-lr-15 p-tb-92" style="background-image: url('/user/images/bg-01.jpg');">
		<h2 class="ltext-105 cl0 txt-center">
			Account
		</h2>
	</section>

	<div>
	<!-- Content page -->
		<section class="bg0 p-t-104 p-b-116">
			<div class="container">
				<div class="flex-w flex-tr">
					<div class="size-210 bor10 p-lr-70 p-t-55 p-b-70 p-lr-15-lg w-full-md mx-auto">
						<form>
							<h4 class="mtext-105 cl2 txt-center p-b-30">
								Thông tin tài khoản
							</h4>
							<div class="mb-4">
								<label for="fullname" class="form-label">Họ và tên <span style="color: red">*</span></label>
								<input type="text" class="form-control" id="fullname" name="fullname" value="${account.fullname}" aria-describedby="emailHelp" required>
							</div>
							<div class="mb-4">
								<label for="username" class="form-label">Username <span style="color: red">*</span></label>
								<input type="text" class="form-control" id="username" name="username" value="${account.username}" aria-describedby="emailHelp" required>
							</div>

							<div class="mb-2 d-flex flex-column">
								<label class="form-label mb-2">Giới tính <span style="color: red">*</span></label>
								<div style="margin: 16px" class="row">
									<div class="col-3">
										<div class="form-check ">
											<input class="form-check-input" type="radio" name="gender"
												   id="flexRadioDefault1" ${account.gender == 'Nam' ? 'checked' : ''}  required>
											<label class="form-check-label" for="flexRadioDefault1">
												Nam
											</label>
										</div>
									</div>
									<div class=" col-9">
										<div class="form-check">
											<input class="form-check-input" type="radio" name="gender"
												   id="flexRadioDefault2" ${account.gender == 'Nữ' ? 'checked' : ''} checked required>
											<label class="form-check-label" for="flexRadioDefault2">
												Nữ
											</label>
										</div>
									</div>
								</div>
							</div>
							<div class="mb-4">
								<label for="email" class="form-label">Email <span style="color: red">*</span></label>
								<input type="email" class="form-control" id="email" name="email" value="${account.email}" aria-describedby="emailHelp" required>
							</div>
							<button type="submit" class="btn btn-secondary">Cập nhật</button>
						</form>
					</div>
				</div>
			</div>
		</section>





	</div>
	<!-- Footer -->
	<footer class="bg3 p-t-75 p-b-32">
		<%@include file="../user/components/footer.jsp"%>
	</footer>


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
		$(".js-select2").each(function(){
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
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAKFWBqlKAGCeS1rMVoaNlwyayu0e0YRes"></script>
	<script src="/user/js/map-custom.js"></script>
<!--===============================================================================================-->
	<script src="/user/js/main.js"></script>

</body>
</html>