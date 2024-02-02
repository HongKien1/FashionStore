package com.main.fashionstore.Service;

import com.main.fashionstore.Entity.Account;

import java.util.Optional;

public interface AccountService {
    Optional<Account> getAccountByUsername(String username);
    void updateAccount(Account account);
}
