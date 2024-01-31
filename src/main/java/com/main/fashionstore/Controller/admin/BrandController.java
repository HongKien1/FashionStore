package com.main.fashionstore.Controller.admin;

import com.main.fashionstore.Entity.Brand;
import com.main.fashionstore.Entity.Category;
import com.main.fashionstore.Service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("admin/brand")
public class BrandController {
    @Autowired
    BrandService brandService;

    @GetMapping("")
    public String index(Model model) {
        List<Brand> brands = brandService.getAllBrands();
        model.addAttribute("brands", brands);
        return "admin/brand";
    }

    @GetMapping("/addBrand")
    public String add(Model model) {
        model.addAttribute("brand", new Brand());
        return "admin/brand-add";
    }

    @PostMapping("/addBrand")
    public String addBrand(@Validated Brand brand,
                           BindingResult result, Model model) {
        if (!result.hasErrors()) {
            brandService.saveBrand(brand);
            System.out.println(brand.toString());
            model.addAttribute("message", "Thêm thành coong");
            return "redirect:/admin/brand";
        } else {
            model.addAttribute("message", "Vui long nhap du thong tin");
        }
        return "admin/brand-add";
    }

    @GetMapping("/updateBrand/{brand_id}")
    public String update(Model model, @PathVariable("brand_id") Integer brand_id) {
        Brand brand = brandService.getBrandById(brand_id);
        model.addAttribute("brand", brand);
        return "admin/brand-update";
    }

    @PostMapping("/updateBrand/{brand_id}")
    public String updateBrand(@Validated @PathVariable("brand_id") Integer brand_id,
                              Brand brand, BindingResult result, Model model) {
        Brand brand1 = brandService.getBrandById(brand_id);

        brand1.setBrand_id(brand.getBrand_id());
        brand1.setBrand_name(brand.getBrand_name());
        brandService.saveBrand(brand);
        model.addAttribute("success", "Cap nhat thanh cong");
        return "redirect:/admin/brand";
    }

    @GetMapping("/deleteBrand/{brand_id}")
    public String delete(@PathVariable("brand_id") Integer brand_id) {
        brandService.deleteBrand(brand_id);
        return "redirect:/admin/brand";
    }
}