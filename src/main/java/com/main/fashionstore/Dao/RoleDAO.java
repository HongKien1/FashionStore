package com.main.fashionstore.Dao;

import com.main.fashionstore.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDAO extends JpaRepository<Role, Integer> {
}
