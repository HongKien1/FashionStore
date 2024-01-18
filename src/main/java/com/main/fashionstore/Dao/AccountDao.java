package com.main.fashionstore.Dao;

import com.main.fashionstore.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDao extends JpaRepository<Account, Integer> {
}
