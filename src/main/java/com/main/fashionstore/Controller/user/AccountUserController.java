package com.main.fashionstore.Controller.user;

import com.main.fashionstore.Dao.AccountDao;
import com.main.fashionstore.Entity.Account;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("account")
public class AccountUserController {

    @Autowired
    AccountDao accountDao;
    @Autowired
    HttpSession session;

    @GetMapping("")
    public String index(Model model) {
        // Lấy thông tin tài khoản từ cơ sở dữ liệu và đưa vào model để hiển thị
        String username = (String) session.getAttribute("account");
        Optional<Account> accountUser = accountDao.findByUsername(username);
        model.addAttribute("account", accountUser.get());
        return "user/account";
    }

    @GetMapping("edit")
    public String edit(Model model) {
        // Lấy thông tin tài khoản từ cơ sở dữ liệu và đưa vào model để hiển thị trong form chỉnh sửa
        // Thay vị trí này bằng cách lấy ID tài khoản của user từ phiên làm việc hoặc thông tin người dùng đã đăng nhập
        String username = (String) session.getAttribute("account");
        Optional<Account> accountUser = accountDao.findByUsername(username);
        model.addAttribute("account", accountUser.get());
        return "user/account_edit";
    }

    @PostMapping("/update")
    public String updateAccountInfo(@RequestParam String fullname, Model model) {
        // Lấy thông tin tài khoản từ cơ sở dữ liệu
        // Thay vị trí này bằng cách lấy ID tài khoản của user từ phiên làm việc hoặc thông tin người dùng đã đăng nhập
        int accountId = 1; // Ví dụ: giả sử ID tài khoản của user là 1
        Account account = accountDao.findById(accountId).orElse(null);

        // Cập nhật thông tin cá nhân từ dữ liệu đầu vào
        account.setFullname(account.getFullname());
        // Cập nhật thông tin các tham số khác
        // Code các tham số khác cần cập nhật

        // Lưu thông tin cập nhật vào cơ sở dữ liệu
        accountDao.save(account);

        // Sau khi cập nhật thành công, chuyển hướng về trang hiển thị thông tin cá nhân
        return "redirect:/account";
    }
}
