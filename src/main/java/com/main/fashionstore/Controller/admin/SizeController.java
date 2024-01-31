package com.main.fashionstore.Controller.admin;


import com.main.fashionstore.Entity.Size;
import com.main.fashionstore.Service.SizeService;
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
@RequestMapping("admin/size")
public class SizeController {

    @Autowired
    SizeService sizeService;

    @GetMapping("")
    public String index(Model model) {
        List<Size> sizes = sizeService.getAllSize();
        model.addAttribute("sizes", sizes);
        return "admin/size";
    }

    @GetMapping("/addSize")
    public String add(Model model) {
        model.addAttribute("size", new Size());
        return "admin/size-add";
    }

    @PostMapping("/addSize")
    public String addSize(@Validated Size size,
                          BindingResult result, Model model) {
        if (!result.hasErrors()) {
            sizeService.saveSize(size);
            System.out.println(size.toString());
            model.addAttribute("message", "Thêm thành coong");
            return "redirect:/admin/size";
        } else {
            model.addAttribute("message", "Vui long nhap du thong tin");
        }
        return "admin/size-add";
    }

    @GetMapping("/updateSize/{size_id}")
    public String update(Model model, @PathVariable("size_id") Integer size_id) {
        Size size = sizeService.getSizeById(size_id);
        model.addAttribute("size", size);
        return "admin/size-update";
    }

    @PostMapping("/updateSize/{size_id}")
    public String updateBrand(@Validated @PathVariable("size_id") Integer size_id,
                             Size size, BindingResult result, Model model) {
        Size size1 = sizeService.getSizeById(size_id);

        size1.setSize_id(size.getSize_id());
        size1.setSize_name(size.getSize_name());
        sizeService.saveSize(size);
        model.addAttribute("success", "Cap nhat thanh cong");
        return "redirect:/admin/size";
    }

    @GetMapping("/deleteSize/{size_id}")
    public String delete(@PathVariable("size_id") Integer size_id) {
        sizeService.deleteSize(size_id);
        return "redirect:/admin/size";
    }

}