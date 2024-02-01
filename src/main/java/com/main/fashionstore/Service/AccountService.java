package com.main.fashionstore.Service;

import com.main.fashionstore.Dao.AccountDao;
import com.main.fashionstore.Entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountDao accountDao;

    public void createAccount(Account account){
        accountDao.save(account);
    }

}
