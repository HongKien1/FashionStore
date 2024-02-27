package com.main.fashionstore.Dao;

import com.main.fashionstore.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountDao extends JpaRepository<Account, Integer> {
    Optional<Account> findByUsername(String username);

    boolean existsByUsernameAndPassword (String username, String password);

    // Phương thức để lấy thông tin tài khoản theo ID
    Optional<Account> findById(int accountId);

    // Phương thức để cập nhật thông tin tài khoản
    Account save(Account account);

    @Query("SELECT a FROM Account a where a.email = ?1")
    Account findAccByEmail(String email);


}
