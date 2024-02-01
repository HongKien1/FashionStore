package com.main.fashionstore.Controller.user;

import com.main.fashionstore.Dao.AccountDao;
import com.main.fashionstore.Entity.Account;
import com.main.fashionstore.Entity.Role;
import com.main.fashionstore.Service.AccountService;
import com.main.fashionstore.Service.RoleService;
import com.main.fashionstore.Service.SendMailService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller

@RequestMapping("create")
public class CreateAccountController {
    @Autowired
    private HttpSession session;



    @Autowired
    private AccountDao accountDao;
@Autowired
private RoleService roleService;
    @GetMapping("/account")
    public String showCreateAccountForm(Model model) {
        Account accounts = new Account();
        model.addAttribute("accounts",accounts);
        return "user/create-account";
    }



    @PostMapping("/account")
    public String addAccount(@Validated @ModelAttribute("accounts") Account accounts, BindingResult result,ModelMap model) {
        if (result.hasErrors()) {
            return "user/create-account";
        }

        accounts.setRole( roleService.findByNameRole("USER"));
        accountDao.save(accounts);
        model.addAttribute("message","Tạo tài khoản thành công");
        return "redirect:/product";
    }

    }

 