package com.main.fashionstore.Controller.admin;

import com.main.fashionstore.Entity.Category;
import com.main.fashionstore.Entity.Color;
import com.main.fashionstore.Service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin/color")
public class ColorController {
    @Autowired
    ColorService colorService;

    @GetMapping("")
    public String index(Model model) {
        List<Color> colors = colorService.findAll();
        model.addAttribute("colors", colors);
        return "admin/color";
    }

    @GetMapping("/addColor")
    public String add(Model model) {
        model.addAttribute("color", new Color());
        return "admin/color-add";
    }

    @PostMapping("/addColor")
    public String addColor(@RequestParam("color") String color,
                           Model model) {

        Color save = new Color();
        save.setColor(color);
        colorService.saveColor(save);
        return "redirect:/admin/color";
    }


    @GetMapping("/updateColor/{color_id}")
    public String update(@PathVariable("color_id") Integer color_id,
                         Model model) {
        Color color = colorService.findById(color_id);
        model.addAttribute("color", color);
        return "admin/color-update";
    }

    @PostMapping("/updateColor/{color_id}")
    public String updateColor(@RequestParam("color") String color,
                              @PathVariable("color_id") Integer color_id,
                              Model model) {

        Color existingColor = colorService.findById(color_id);
        if (existingColor != null) {
            existingColor.setColor(color);
            colorService.saveColor(existingColor);
        }
//        model.addAttribute("success", "Cap nhat thanh cong");
        return "redirect:/admin/color";
    }

    @GetMapping("/deleteColor/{color_id}")
    public String delete(@PathVariable("color_id") Integer color_id) {
        colorService.removeColor(color_id);
        return "redirect:/admin/color";
    }
}