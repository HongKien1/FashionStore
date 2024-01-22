package com.main.fashionstore.Controller.admin;

import com.main.fashionstore.Entity.Product;
import com.main.fashionstore.Service.BrandService;
import com.main.fashionstore.Service.ProductService;
import com.main.fashionstore.Service.ProductTypeService;
import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("admin/Product")
public class Product_AdminController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductTypeService productTypeService;

    @Autowired
    BrandService brandService;

    @Autowired
    ServletContext app;

    //hiển thị sản phẩm
    @GetMapping("")
    public String index(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "admin/Product";
    }

    //thêm sản phẩm
    @GetMapping("/addProduct")
    public String add(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("productTypes", productTypeService.getAllProductTypes());
        model.addAttribute("brands", brandService.getAllBrands());
        return "admin/product-add";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute Product product, @RequestParam("image") MultipartFile img)
            throws IllegalStateException, IOException {
        // Lưu trữ file vào thư mục images nếu có file được chọn
        if (!img.isEmpty()) {
            String filename = img.getOriginalFilename();
            // Kiểm tra và tạo thư mục images nếu nó không tồn tại
            File uploadFolder = new File(app.getRealPath("/images/"));
            if (!uploadFolder.exists()) {
                uploadFolder.mkdirs();
            }
            // Tạo file trong thư mục images
            File destFile = new File(uploadFolder, filename);
            // Lưu trữ file vào thư mục đã xác định
            img.transferTo(destFile);
            // Lưu tên file vào trường image của đối tượng Product
            product.setImage(filename);
        }
        // Lưu thông tin sản phẩm vào cơ sở dữ liệu
        productService.saveProduct(product);

        return "redirect:/admin/product-add";
    }



    @GetMapping("/updateProduct")
    public String update() {
        return "admin/product-update";
    }

    @GetMapping("/deleteProduct/{productId}")
    public String deleteProduct(@PathVariable Integer productId) {
        productService.deleteProduct(productId);
        return "redirect:admin/Product";
    }
}