package com.main.fashionstore.Service;

import com.main.fashionstore.Dao.ProductDao;
import com.main.fashionstore.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductDao productDao;

    // Hiển thị tất cả sản phẩm
    public List<Product> getAllProducts() {
        return productDao.findAll();
    }

    // tìm sản phẩm có hay khng
    public Optional<Product> getProductById(Integer productId) {
        return productDao.findById(productId);
    }

    // thêm hoặc lưu sản phẩm
    public Product saveProduct(Product product) {
        return productDao.save(product);
    }

    //xóa sản phẩm
    public void deleteProduct(Integer productId) {
        productDao.deleteById(productId);
    }

}
