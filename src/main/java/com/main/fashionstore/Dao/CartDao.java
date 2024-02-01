package com.main.fashionstore.Dao;

import com.main.fashionstore.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDao extends JpaRepository<Cart, Integer> {

    @Query("SELECT c FROM Cart c WHERE c.account.account_id = :accountId")
    Cart findByAccountAccountId(@Param("accountId") Integer accountId);
    
}
