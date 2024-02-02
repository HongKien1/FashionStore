package com.main.fashionstore.Controller.user;


import com.main.fashionstore.Dao.AccountDao;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
                        RedirectAttributes redirectAttributes) {

        boolean exitByUserName = accountDao.existsByUsernameAndPassword(username, password);

        if (exitByUserName) {
            // Lấy thông tin tài khoản từ cơ sở dữ liệu
            Optional<Account> account = accountDao.findByUsername(username);

            if (account.isPresent()) {
                int role = account.get().getRole().getRole_id();

                // Lưu role vào session
                session.setAttribute("role", role);

                if (role == 1) {
                    // Nếu role là 1 (admin), chuyển hướng đến trang admin
                    return "redirect:/admin";
                } else{
                    // Nếu role là 2 (user), chuyển hướng đến trang user
                    return "redirect:/index";
                }
            }
        }

        // Xử lý trường hợp đăng nhập không thành công
        redirectAttributes.addFlashAttribute("error", "Tài khoản không hợp lệ");
        return "redirect:/account/login";
    }


}


