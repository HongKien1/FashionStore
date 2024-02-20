<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
		<!DOCTYPE html>
		<html lang="en">

		<head>
			<title>Shoping Cart</title>
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
			<!--===============================================================================================-->
		</head>

		<body class="animsition">

			<!-- Header -->
			<header class="header-v4">
				<%@include file="../user/components/header.jsp" %>
			</header>

			<!-- Cart -->
			<%@include file="../user/components/cart.jsp" %>
				<%@include file="../user/components/miniCart.jsp" %>

					<!-- breadcrumb -->
					<div class="container">
						<div class="bread-crumb flex-w p-l-25 p-r-15 p-t-30 p-lr-0-lg">
							<a href="index.jsp" class="stext-109 cl8 hov-cl1 trans-04">
								Trang chủ
								<i class="fa fa-angle-right m-l-9 m-r-10" aria-hidden="true"></i>
							</a>

							<span class="stext-109 cl4">
								Giỏ hàng
							</span>
						</div>
					</div>


					<!-- Shoping Cart -->
					<form class="bg0 p-t-75 p-b-85">
						<div class="container">
							<div class="row">
								<div class="col-lg-10 col-xl-7 m-lr-auto m-b-50">
									<div class="m-l-25 m-r--38 m-lr-0-xl">
										<div class="wrap-table-shopping-cart">													
												<table class="table">
													<thead>
														<tr>
															<th>Tên sản phẩm</th>
															<th>Size</th>
															<th>Màu</th>
															<th>Số lượng</th>														
															<th>Giá</th>
															<th>Thành tiền</th>
														</tr>
													</thead>
													<tbody class="table-border-bottom-0">
														<c:forEach items="${cartDetails}" var="cartDetail">
															<tr>
																<td>${cartDetail.productdetails.product.name}</td>
																<td>${cartDetail.productdetails.size.size_name}</td>
																<td>${cartDetail.productdetails.color.color}</td>
																<td>
																	<input type="number" value="${cartDetail.quantity}">  
																	</input>																	
																</td>
																<td>${cartDetail.productdetails.product.price}</td>
																<td>${cartDetail.quantity * cartDetail.productdetails.product.price}</td>
															</tr>
														</c:forEach>
													</tbody>
												</table>											
										</div>

										<div class="flex-w flex-sb-m bor15 p-t-18 p-b-15 p-lr-40 p-lr-15-sm">
											<div class="flex-w flex-m m-r-20 m-tb-5">
												<input class="stext-104 cl2 plh4 size-117 bor13 p-lr-20 m-r-10 m-tb-5"
													type="text" name="coupon" placeholder="Coupon Code">

												<div
													class="flex-c-m stext-101 cl2 size-118 bg8 bor13 hov-btn3 p-lr-15 trans-04 pointer m-tb-5">
													Mã giảm giá
												</div>
											</div>

											<div
												class="flex-c-m stext-101 cl2 size-119 bg8 bor13 hov-btn3 p-lr-15 trans-04 pointer m-tb-10">
												Tiếp tục mua
											</div>
										</div>
									</div>
								</div>

								<div class="col-sm-10 col-lg-7 col-xl-5 m-lr-auto m-b-50">
									<div class="bor10 p-lr-40 p-t-30 p-b-40 m-l-63 m-r-40 m-lr-0-xl p-lr-15-sm">
										<h4 class="mtext-109 cl2 p-b-30 fw-bold">
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

										<div class="flex-w flex-t bor12 p-t-15 p-b-30">
											<div class="size-208 w-full-ssm">
												<span class="stext-110 cl2">
													Phí vận chuyển
												</span>
											</div>

											<div class="size-209 p-r-18 p-r-0-sm w-full-ssm">
												<p class="stext-111 cl6 p-t-2">
													There are no shipping methods available. Please double check your
													address, or contact us if you need any help.
												</p>

												<div class="p-t-15">
													<span class="stext-112 cl8">
														Calculate Shipping
													</span>

													<div class="rs1-select2 rs2-select2 bor8 bg0 m-b-12 m-t-9">
														<select class="js-select2" name="time">
															<option>Select a country...</option>
															<option>USA</option>
															<option>UK</option>
														</select>
														<div class="dropDownSelect2"></div>
													</div>

													<div class="bor8 bg0 m-b-12">
														<input class="stext-111 cl8 plh3 size-111 p-lr-15" type="text"
															name="state" placeholder="State /  country">
													</div>

													<div class="bor8 bg0 m-b-22">
														<input class="stext-111 cl8 plh3 size-111 p-lr-15" type="text"
															name="postcode" placeholder="Postcode / Zip">
													</div>

													<div class="flex-w">
														<div
															class="flex-c-m stext-101 cl2 size-115 bg8 bor13 hov-btn3 p-lr-15 trans-04 pointer">
															Update Totals
														</div>
													</div>

												</div>
											</div>
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

										<a href="/orderDetail"
											class="flex-c-m stext-101 cl0 size-116 bg3 bor14 hov-btn3 p-lr-15 trans-04 pointer">
											Mua hàng
										</a>
									</div>
								</div>
							</div>
						</div>
					</form>




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
						<script src="/user/vendor/MagnificPopup/jquery.magnific-popup.min.js"></script>
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