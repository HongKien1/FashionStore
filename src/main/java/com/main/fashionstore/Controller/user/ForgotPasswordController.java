package com.main.fashionstore.Controller.user;

import com.main.fashionstore.Dao.AccountDao;
import com.main.fashionstore.Entity.Account;
import com.main.fashionstore.Service.SendMailService;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
// Import các package và annotation cần thiết

@Controller
public class ForgotPasswordController {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private HttpSession session;

    @Autowired
    private SendMailService sendMailService;

    @GetMapping("/forgot")
    public String showForgotPasswordForm() {
        return "/user/forgot-password";
    }

    @PostMapping("/confirmemail")
    public ModelAndView nhapMa(ModelMap model, @RequestParam("email") String email) {
        List<Account> accountList = accountDao.findAll();
        for (Account account : accountList) {
            if (email.trim().equals(account.getEmail())) {
                session.removeAttribute("otp");
                int randomOtp = (int) Math.floor(Math.random() * (999999 - 100000 + 1) + 100000);
                session.setAttribute("otp", randomOtp);
                String body = "Mã xác thực của bạn là " + randomOtp;

                sendMailService.sendMail(email, "Quên mật khẩu?", body);
                model.addAttribute("email", email);
                model.addAttribute("message", "Mã xác thực OTP đã được gửi tới Email: " + account.getEmail() +
                        " , hãy kiểm tra Email của bạn!");
                return new ModelAndView("user/nhapotp", model);
            }
        }
        model.addAttribute("error", "Email này chưa đăng ký!");
        return new ModelAndView("user/forgot-password", model);
    }
    @PostMapping("/confirmOtp")
    public ModelAndView confirmOtp(@RequestParam("otp") String otp, ModelMap model,@RequestParam("email") String email){
        if (otp.equals(String.valueOf(session.getAttribute("otp")))) {
            model.addAttribute("email", email);
            return new ModelAndView("user/nhaplaimatkhau");
        }
        model.addAttribute("email", email);
        model.addAttribute("error", "Mã xác thực OTP không đúng, thử lại!");
        return new ModelAndView("user/nhapotp", model);
    }

    @PostMapping("/nhapmkhau")
    public ModelAndView nhapMatkhau(ModelMap model, @RequestParam("newPassword") String newpassword,
                                    @RequestParam("confirmPassword") String confirmPassword,
                                    @RequestParam("email") String email) {
        if(!newpassword.equals(confirmPassword)){
            model.addAttribute("email", email);
            model.addAttribute("error", "Mật khẩu cần giống nhau");
            return new ModelAndView("user/nhaplaimatkhau");
        }
        Account account = accountDao.findAccByEmail(email);
        account.setPassword(newpassword);
        accountDao.save(account);
        model.addAttribute("message", "Đặt lại mật khẩu thành công!");
        session.removeAttribute("otp");
        return new ModelAndView("user/nhaplaimatkhau");
    }
}
