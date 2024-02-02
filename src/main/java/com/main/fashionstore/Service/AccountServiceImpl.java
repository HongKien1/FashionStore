package com.main.fashionstore.Service;

import com.main.fashionstore.Dao.AccountDao;
import com.main.fashionstore.Entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public Optional<Account> getAccountByUsername(String username) {
        return accountDao.findByUsername(username);
    }


    @Override
    public void updateAccount(Account account) {
        // Cập nhật thông tin tài khoản trong cơ sở dữ liệu
        accountDao.save(account);
    }
}
