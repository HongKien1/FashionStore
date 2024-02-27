package com.main.fashionstore.Service;

import com.main.fashionstore.Dao.RoleDAO;
import com.main.fashionstore.Entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    RoleDAO roleDAO;

    public Role findById(Integer id){
        return roleDAO.findById(id).get();
    }
    public Role findByNameRole(String roleName){
        return roleDAO.findByRoleName(roleName);
    }
}