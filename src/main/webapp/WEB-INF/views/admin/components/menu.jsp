<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<aside id="layout-menu" class="layout-menu menu-vertical menu bg-menu-theme">
    <div class="app-brand demo">
        <a href="/admin" class="app-brand-link">

            <span class="app-brand-text text-uppercase  demo menu-text fw-bolder ms-2">FashionStore</span>
        </a>

        <a href="javascript:void(0);" class="layout-menu-toggle menu-link text-large ms-auto d-block d-xl-none">
            <i class="bx bx-chevron-left bx-sm align-middle"></i>
        </a>
    </div>

    <div class="menu-inner-shadow"></div>

    <ul class="menu-inner py-1">
        <!-- Dashboard -->
        <li class="menu-item">
            <a href="/admin" class="menu-link">
                <i class="menu-icon tf-icons bx bx-home-circle"></i>
                <div data-i18n="Analytics">Trang chủ</div>
            </a>
        </li>

        <li class="menu-header small text-uppercase">
            <span class="menu-header-text">Công cụ</span>
        </li>

        <li class="menu-item">
            <a href="/admin/account" class="menu-link">
                <i class="menu-icon tf-icons bx bx-user-circle"></i>
                <div data-i18n="Analytics">Quản lí tài khoản</div>
            </a>
        </li>
        <li class="menu-item">
            <a href="/admin/category" class="menu-link">
                <i class="menu-icon tf-icons  bx bx-list-ul"></i>
                <div data-i18n="Analytics">Quản lí danh mục</div>
            </a>
        </li>
        <li class="menu-item">
            <a href="/admin/productType" class="menu-link">
                <i class="menu-icon tf-icons  bx bx-list-ul"></i>
                <div data-i18n="Analytics">Quản lí loại sản phẩm</div>
            </a>
        </li>
        <li class="menu-item">
            <a href="/admin/brand" class="menu-link">
                <i class="menu-icon tf-icons bx bx-user-circle"></i>
                <div data-i18n="Analytics">Quản lí thương hiệu</div>
            </a>
        </li>
        <li class="menu-item">
            <a href="/admin/size" class="menu-link">
                <i class="menu-icon tf-icons bx bx-user-circle"></i>
                <div data-i18n="Analytics">Quản lí kích cỡ</div>
            </a>
        </li>
        <li class="menu-item">
            <a href="/admin/color" class="menu-link">
                <i class="menu-icon tf-icons bx bx-user-circle"></i>
                <div data-i18n="Analytics">Quản lí màu</div>
            </a>
        </li>
        <li class="menu-item">
            <a href="/admin/Product" class="menu-link">
                <i class="menu-icon tf-icons  bx bxl-product-hunt"></i>
                <div data-i18n="Analytics">Quản lí sản phẩm</div>
            </a>
        </li>
        <li class="menu-item">
            <a href="/admin/productDetail" class="menu-link">
                <i class="menu-icon tf-icons  bx bxl-product-hunt"></i>
                <div data-i18n="Analytics">Quản lí sản phẩm chi tiết</div>
            </a>
        </li>
        <li class="menu-item">
            <a href="/admin/order" class="menu-link">
                <i class="menu-icon tf-icons bx bx-news"></i>
                <div data-i18n="Analytics">Quản lí đơn hàng</div>

            </a>
        </li>


        <!-- Components -->
        <li class="menu-header small text-uppercase"><span class="menu-header-text">Thống kê</span></li>
        <!-- Cards -->
        <li class="menu-item">
            <a href="/admin" class="menu-link">
                <i class="menu-icon tf-icons  bx bx-bar-chart-alt"></i>
                <div data-i18n="Basic">Quản lý thống kê</div>
            </a>
        </li>


    </ul>
</aside>
</body>
</html>