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
                    <h5 class="card-header">Cập nhật loại sản phẩm</h5>

                    <div class="card-body">
                        <form method="POST">
                            <div class="row">
                                <div class="row">

                                    <div class="mb-3">tui
                                        <label for="username" class="form-label">Tên loại</label>
                                        <input
                                                class="form-control"
                                                type="text"
                                                id="username"
                                                name="username"
                                                value="áo sơ mi"
                                                autofocus
                                        />
                                        <span class="text-danger"></span>

                                    </div>
                                    <div class="mt-3">
                                        <label class="form-label">Danh mục</label>
                                        <select class="form-select">
                                            <option>Quần</option>
                                            <option>Áo</option>
                                        </select>
                                    </div>


                                </div>

                                <div class="mt-3">
                                    <button type="submit" class="btn btn-warning m-2">Cập nhât</button>
                                    <button type="reset" class="btn btn-outline-secondary m-2">Cancel</button>
                                </div>
                            </div>
                        </form>
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
