package com.main.fashionstore.Service;

import com.main.fashionstore.Dao.CategoryDao;
import com.main.fashionstore.Entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryDao categoryDao;

    public List<Category> findAll() {

        return categoryDao.findAll();
    }

    public Category findById(Integer category_id) {
        Optional<Category> optional = categoryDao.findById(category_id);
        return optional.orElse(null);
    }

    public Category save(Category category) {
        return categoryDao.save(category);
    }

    public void remove(Integer category_id) {
        categoryDao.deleteById(category_id);
    }
}
