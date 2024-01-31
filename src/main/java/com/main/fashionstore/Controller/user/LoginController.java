package com.main.fashionstore.Controller.user;


import com.main.fashionstore.Dao.AccountDao;
import com.main.fashionstore.Entity.Account;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller

@RequestMapping("account")
public class LoginController {
    @Autowired
    private AccountDao accountDao;

    @Autowired
    private HttpSession session;


        @GetMapping("login")
        public String loginForm() {
            return "user/login";
        }

    @PostMapping("login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam("role") Integer role,
                        RedirectAttributes redirectAttributes) {

        boolean exitByUserName = accountDao.existsByUsernameAndPassword(username, password);

        if(exitByUserName){
            // save account in session when login success
//            Optional<Account> account = accountDao.findByRole(role);

            session.setAttribute("accountLogin", username);//lưu lại phiên đăng nhập
//            if(account.get().getRole() == 1){
//                return "redirect:/admin";
//            }else {
//                return "redirect:/index";
//            }
//            session.setAttribute("accountLogin", username);
            return "user/index";

        }else{
            redirectAttributes.addFlashAttribute("error", "Tài khoản khng ồn tia");
            return "user/login";
        }

    }

    }


