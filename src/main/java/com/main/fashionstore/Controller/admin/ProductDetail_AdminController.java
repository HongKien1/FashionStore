package com.main.fashionstore.Controller.admin;

import com.main.fashionstore.Entity.ProductDetails;
import com.main.fashionstore.Service.ColorService;
import com.main.fashionstore.Service.ProductDetailsService;
import com.main.fashionstore.Service.ProductService;
import com.main.fashionstore.Service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin/productDetail")
public class ProductDetail_AdminController {

    @Autowired
    ProductDetailsService productDetailsService;

    @Autowired
    ProductService productService;

    @Autowired
    ColorService colorService;

    @Autowired
    SizeService sizeService;

    @GetMapping("")
    public String index(Model model) {
        List<ProductDetails> productDetailList = productDetailsService.getAllProductDetails();
        model.addAttribute("productDetailList", productDetailList);
        return "admin/productDetail";
    }

    @GetMapping("/addProduct")
    public String add(Model model) {
        model.addAttribute("productDetailList", new ProductDetails());
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("colors", colorService.findAll());
        model.addAttribute("sizes", sizeService.getAllSizes());
        return "admin/productDetail-add";
    }

    @PostMapping("/addProduct")
    public String addDetail(@ModelAttribute("productDetails") ProductDetails productDetails){
        productDetailsService.saveProductDetails(productDetails);
        return "redirect:/admin/productDetail";
    }

    @GetMapping("/updateProduct/{id}")
    public String updateProduct(@PathVariable  Integer id, Model model){
        ProductDetails productDetails = productDetailsService.getProductDetailById(id);

        model.addAttribute("productDetails", productDetails);
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("colors", colorService.findAll());
        model.addAttribute("sizes", sizeService.getAllSizes());
        return "admin/productDetail-update";
    }

    @PostMapping("/updateProduct/{id}")
    public String processUpdateProduct(@PathVariable Integer id, @ModelAttribute("productDetails") ProductDetails productDetails, Model model) {
        // Cập nhật thông tin chi tiết sản phẩm
        productDetails.setProductdetails_id(id);
        productDetailsService.saveProductDetails(productDetails);
        // Redirect về trang danh sách hoặc trang chi tiết sản phẩm sau khi cập nhật thành công
        return "redirect:/admin/productDetail";
    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return "redirect:/admin/productDetail";
    }


}