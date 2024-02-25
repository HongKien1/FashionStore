package com.main.fashionstore.Dao;

import com.main.fashionstore.Entity.Account;
import com.main.fashionstore.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@Repository
public interface CartDao extends JpaRepository<Cart, Integer> {

    Optional<Cart> findByAccount(Account account);

    // Lấy tất cả các giỏ hàng của một người dùng
    List<Cart> findByUser(Account account);
    
}
