package com.main.fashionstore.Controller.admin;

import com.main.fashionstore.Entity.Category;
import com.main.fashionstore.Entity.ProductType;
import com.main.fashionstore.Service.CategoryService;
import com.main.fashionstore.Service.ProductTypeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/productType")
public class ProductTypeController {
    @Autowired
    private ProductTypeService productTypeService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public String index(Model model) {
        List<ProductType> productTypeList = productTypeService.getAllProductTypes();
        model.addAttribute("listProType",productTypeList);
        return "admin/productType";
    }

    @GetMapping("/addProductType")
    public String add(Model model) {
        List<Category> cboCategory = categoryService.findAll();
        model.addAttribute("cboCate",cboCategory);
        return "admin/productType-add";
    }

    @PostMapping("/addProductType")
    public String addPro(@ModelAttribute("productType")  ProductType productType, Model model, BindingResult result) { //Dùng ModelAttribute để ánh xạ các trường name trên form
        if(result.hasErrors()){
            model.addAttribute("error","Thêm thất bại");
            return "forward:/admin/productType/addProductType";
        }
        productTypeService.saveProductType(productType);
        model.addAttribute("success","Thêm thành công");
        return "redirect:/admin/productType";
    }
    @GetMapping("/delete/{id}")
    public String deleteProType(@PathVariable("id") Integer id,Model model){
        if(id==null){model.addAttribute("error","Lỗi xóa");
        return "forward:/admin/productType";
    }
        productTypeService.deleteProductType(id);
        return "redirect:/admin/productType";
    }
    @GetMapping("/updateProductType/{id}")
    public String update(@PathVariable("id") Integer id,Model model) {
        if(id == null){
            model.addAttribute("error","Không tìm thấy id");
            return "forward:/admin/productType";
        }
        ProductType detail = productTypeService.getProductTypeById(id);
        model.addAttribute("proTypeDetail",detail);
        model.addAttribute("cboCateDetail",detail.getCategory_id().getCategory_name());
        model.addAttribute("cboCate", categoryService.findAll());
        return "admin/productType-update";
    }
    @PostMapping("/updateProduct")
    public String updatePType(@ModelAttribute("productType") ProductType productType,BindingResult result,Model model){
        ProductType productTypeold = productTypeService.getProductTypeById(productType.getProductType_id());
        productTypeold.setProductType_name(productType.getProductType_name());
        productTypeold.setCategory_id(productType.getCategory_id());
        productTypeService.saveProductType(productTypeold);
        model.addAttribute("updataSuccess","Cập nhập thành công");
        return "redirect:/admin/productType";
    }
}