<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>

<!-- =========================================================
* Sneat - Bootstrap 5 HTML Admin Template - Pro | v1.0.0
==============================================================

* Product Page: https://themeselection.com/products/sneat-bootstrap-html-admin-template/
* Created by: ThemeSelection
* License: You must have a valid license purchased in order to legally use the theme for your project.
* Copyright ThemeSelection (https://themeselection.com)

=========================================================
 -->
<!-- beautify ignore:start -->
<html xmlns:th="http://www.thymeleaf.org"
      lang="en"
      class="light-style layout-menu-fixed"
      dir="ltr"
      data-theme="theme-default"
      data-assets-path="/assets/"
      data-template="vertical-menu-template-free"
>
<head>
    <meta charset="utf-8"/>
    <meta
            name="viewport"
            content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0"
    />

    <title>Quản lý sản phẩm</title>

    <meta name="description" content=""/>

    <!-- Favicon -->
    <link rel="icon" type="image/x-icon" href="/admin/assets/img/favicon/favicon.ico"/>

    <!-- Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com"/>
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin/>
    <link
            href="https://fonts.googleapis.com/css2?family=Public+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap"
            rel="stylesheet"
    />

    <!-- Icons. Uncomment required icon fonts -->
    <link rel="stylesheet" href="/admin/assets/vendor/fonts/boxicons.css"/>

    <!-- Core CSS -->
    <link rel="stylesheet" href="/admin/assets/vendor/css/core.css"
          class="template-customizer-core-css"/>
    <link rel="stylesheet" href="/admin/assets/vendor/css/theme-default.css"
          class="template-customizer-theme-css"/>
    <link rel="stylesheet" href="/admin/assets/css/demo.css"/>

    <!-- Vendors CSS -->
    <link rel="stylesheet" href="/admin/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.css"/>

    <!-- Page CSS -->

    <!-- Helpers -->
    <script src="/admin/assets/vendor/js/helpers.js"></script>

    <!--! Template customizer & Theme config files MUST be included after core stylesheets and helpers.js in the <head> section -->
    <!--? Config:  Mandatory theme config file contain global vars & default theme options, Set your preferred theme option in this file.  -->
    <script src="/admin/assets/js/config.js"></script>
</head>

<body>
<!-- Layout wrapper -->
<div class="layout-wrapper layout-content-navbar">
    <div class="layout-container">
        <!-- Menu -->
        <%@include file="../admin/components/menu.jsp"%>
        <!-- / Menu -->

        <!-- Layout container -->
        <div class="layout-page">
            <!-- Navbar -->

            <%@include file="../admin/components/nav.jsp"%>
            <!-- / Navbar -->

            <!-- Content wrapper -->
            <div class="content-wrapper">
                <!-- Content -->

                <div class="card m-3 ">

                    <div class="card-body">

                        <!-- Hiển thị thông báo thành công -->
                        <c:if test="${not empty successMessage}">
                            <div class="alert alert-success">
                                <p>${successMessage}</p>
                            </div>
                        </c:if>

                        <!-- Hiển thị thông báo lỗi -->
                        <c:if test="${not empty errorMessage}">
                            <div class="alert alert-danger">
                                <p>${errorMessage}</p>
                            </div>
                        </c:if>


                        <!-- Rest of your JSP content -->

                        <div class="table-responsive mt-5">
                            <a href="/admin/Product/addProduct">
                                <button type="submit" class="btn btn-info float-end" style="margin-right: 40px">Thêm</button>
                            </a>
                            <h5 class="fw-bold py-3 mb-4">Danh sách sản phẩm</h5>
<!--                            <div class="alert alert-success" role="alert"></div>-->
<!--                            <div class="alert alert-success" role="alert"></div>-->
<!--                            <div  class="alert alert-danger" role="alert"></div>-->

                            <table class="table">
                                <thead>
                                    <tr>
                                        <th class="text-center">STT</th>
                                        <th class="text-center">Ảnh sản phẩm</th>
                                        <th class="text-center">Tên sản phẩm</th>
                                        <th class="text-center">Thương hiệu</th>
                                        <th class="text-center">Loại sản phẩm</th>
                                        <th class="text-center">Mô tả</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody class="table-border-bottom-0">

                                    <c:forEach var="product" items="${products}" varStatus="loop">
                                        <tr>
                                            <td class="text-center">${loop.index + 1}</td> <!-- Số thứ tự tăng dần -->
                                            <td class="image" data-title="image" width="150px" height="150px">
                                                <img  style="height: 100%" src="/images/${product.image}">
                                            </td>
                                            <td class="text-center">${product.name}</td>
                                            <td class="text-center">${product.brand.brand_name}</td>
                                            <td class="text-center">${product.productType.productType_name}</td>
                                            <td class="text-center">${product.describe}</td>
                                            <td>
                                                <a href="/admin/Product/updateProduct/${product.product_id}">
                                                    <button type="submit" class="btn btn-warning m-2">Cập nhật</button>
                                                </a>

                                                <a href="/admin/Product/deleteProduct/${product.product_id}" onclick="return confirm('Bạn có chắc chắn muốn xóa sản phẩm này?')">
                                                    <button type="submit" class="btn btn-danger m-2">Xóa</button>
                                                </a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <!--  end table-->
                    </div>
                    <!-- / Content -->


                    <div class="content-backdrop fade"></div>
                </div>
                <!-- Content wrapper -->
            </div>
            <!-- / Layout page -->
        </div>

        <!-- Overlay -->
        <div class="layout-overlay layout-menu-toggle"></div>
    </div>
    <!-- / Layout wrapper -->
</div>

    <!-- Core JS -->
    <!-- build:js assets/vendor/js/core.js -->
    <script src="/admin/assets/vendor/libs/jquery/jquery.js"></script>
    <script src="/admin/assets/vendor/libs/popper/popper.js"></script>
    <script src="/admin/assets/vendor/js/bootstrap.js"></script>
    <script src="/admin/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.js"></script>

    <script src="/admin/assets/vendor/js/menu.js"></script>
    <!-- endbuild -->

    <!-- Vendors JS -->

    <!-- Main JS -->
    <script src="/admin/assets/js/main.js"></script>

    <!-- Page JS -->

    <script src="/admin/assets/js/form-basic-inputs.js"></script>

    <!-- Place this tag in your head or just before your close body tag. -->
    <script async defer src="https://buttons.github.io/buttons.js"></script>
    <script>
        function confirmDelete(productId) {
            Swal.fire({
                title: 'Cảnh báo !',
                text: "Bạn có chắc muốn xóa tài khoản này không ?",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Đồng ý',
                cancelButtonText: 'Hủy'
            }).then((result) => {
                if (result.isConfirmed) {
                    window.location.href = '/admin/account/delete/' + productId;
                }
            })
        }
    </script>
</body>
</html>
