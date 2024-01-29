<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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

    <title>Cập nhật tài khoản</title>

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

                <div class="card mb-4">
                    <h5 class="card-header">Cập nhật sản phẩm</h5>

                    <div class="card-body">
                            <div class="row g-0">
                                <div class="col-md-4">
                                    <!-- Hiển thị hình ảnh hiện tại nếu có -->
                                    <c:if test="${not empty product.image}">
                                        <img src="<c:url value='/images/${product.image}'/>" alt="image" width="400" height="400" />
                                        <br/>
                                    </c:if>
                                </div>
                                <div class="col-md-7">
                                    <form method="post" action="/admin/Product/updateProduct/${product.product_id}" enctype="multipart/form-data">

                                        <!-- Hiển thị thông tin sản phẩm -->
                                        <div class="mb-3">
                                            <label for="name" class="form-label">Tên sản phẩm</label>
                                            <input class="form-control" type="text" id="name" name="name" value="${product.name}" placeholder="name product" autofocus />
                                            <span class="text-danger"></span>
                                        </div>

                                        <div class="mb-3">
                                            <!-- Chọn hình ảnh mới -->

                                            <label for="image">Chọn Hình Ảnh:</label>

                                            <input type="file" id="image" name="image" />
                                            <br/>

                                        </div>

                                        <div class="mb-3">
                                            <label for="price" class="form-label">Giá</label>
                                            <input class="form-control" type="number" id="price" name="price" value="${product.price}" placeholder="describe" autofocus />
                                            <span class="text-danger"></span>
                                        </div>

                                        <div class="mb-3">
                                            <label for="describe" class="form-label">Mô tả</label>
                                            <input class="form-control" type="text" id="describe" name="describe" value="${product.describe}" placeholder="describe" autofocus />
                                            <span class="text-danger"></span>
                                        </div>


                                        <!-- Hiển thị thông tin sản phẩm và danh sách loại sản phẩm, thương hiệu -->
                                        <div class="mt-3">
                                            <label class="form-label">Thương hiệu</label>
                                            <select class="form-select" id="brand" name="brand.brand_id" required>
                                                <c:forEach var="brand" items="${brands}">
                                                    <option value="${brand.brand_id}" ${brand.brand_id eq product.brand.brand_id ? 'selected' : ''}>${brand.brand_name}</option>
                                                </c:forEach>
                                            </select>
                                        </div>

                                        <div class="mt-3">
                                            <label class="form-label">Loại sản phẩm</label>
                                            <select class="form-select" id="productType" name="productType.productType_id" required>
                                                <c:forEach var="type" items="${productTypes}">
                                                    <option value="${type.productType_id}" ${type.productType_id eq product.productType.productType_id ? 'selected' : ''}>${type.productType_name}</option>
                                                </c:forEach>
                                            </select>
                                        </div>

                                        <div class="row mt-3 ">
                                            <div class="mt-3 col-md-6 d-flex justify-content-start">
                                                <button type="submit" class="btn btn-warning m-2">Cập nhật</button>
                                                <button type="reset" class="btn btn-outline-secondary m-2">Reset</button>
                                            </div>

                                            <div class="mt-3 col-md-6 d-flex justify-content-end">
                                                <a href="/admin/Product" class="btn btn-outline-danger m-2">Trở về</a>
                                            </div>
                                        </div>

                                    </form>
                                </div>

                            </div>
                        <div class="text-success"></div>
                        <!--  start table-->
                    </div>
                    <!-- / Content -->
                </div>


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
</body>
</html>
