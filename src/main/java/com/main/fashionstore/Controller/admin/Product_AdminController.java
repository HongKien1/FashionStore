package com.main.fashionstore.Controller.admin;

import com.main.fashionstore.Dto.ProductDto;
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
    public String addProduct(@ModelAttribute("product") ProductDto productDto, @RequestParam("image") MultipartFile img)
            throws IllegalStateException, IOException {

        Product product = new Product();

        // Rest of your code
        if (!img.isEmpty()) {
            String filename = img.getOriginalFilename();
            File uploadFolder = new File(app.getRealPath("/images/"));
            if (!uploadFolder.exists()) {
                uploadFolder.mkdirs();
            }
            File destFile = new File(uploadFolder, filename);
            img.transferTo(destFile);

            product.setProduct_id(productDto.getProduct_id());
            product.setName(productDto.getName());
            product.setDescribe(productDto.getDescribe());
            product.setProductType(productDto.getProductType());
            product.setBrand(productDto.getBrand());

            product.setImage(filename); // Set the image property with the filename
        }

        productService.saveProduct(product);

        return "redirect:/admin/Product";
    }

    @GetMapping("/updateProduct")
    public String update() {
        return "admin/product-update";
    }

    @GetMapping("/deleteProduct/{productId}")
    public String deleteProduct(@PathVariable Integer productId) {
        productService.deleteProduct(productId);
        return "redirect:/admin/Product"; // Chuyển hướng sau khi xóa
    }

}