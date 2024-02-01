package com.main.fashionstore.Dao;

import com.main.fashionstore.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDAO extends JpaRepository<Role, Integer> {
    @Query(value = "SELECT * FROM role r WHERE r.role_name = ?1", nativeQuery = true)
    Role findByRoleName(String roleName);
}
