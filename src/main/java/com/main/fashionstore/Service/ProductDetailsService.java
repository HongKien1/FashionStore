package com.main.fashionstore.Service;

import com.main.fashionstore.Dao.ProductDao;
import com.main.fashionstore.Dao.ProductDetailsDao;
import com.main.fashionstore.Entity.Product;
import com.main.fashionstore.Entity.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductDetailsService {

    @Autowired
    ProductDetailsDao productDetailsDao;

    @Autowired
    ProductDao productDao;

    public List<ProductDetails> getAllProductDetails() {
        return productDetailsDao.findAll();
    }

    public ProductDetails getProductDetailById(Integer id) {
        Optional<ProductDetails> optionalProduct = productDetailsDao.findById(id);
        // Kiểm tra xem có sản phẩm trong Optional không, nếu không thì trả về null hoặc một giá trị mặc định khác
        return optionalProduct.orElse(null);
    }

    public ProductDetails saveProductDetails(ProductDetails productDetails) {
        return productDetailsDao.save(productDetails);
    }

    public void deleteProductDetails(Integer id) {
        productDetailsDao.deleteById(id);
    }

    public List<ProductDetails> findByProductId(Integer productId) {
        // Gọi phương thức của repository để lấy danh sách chi tiết sản phẩm dựa trên productId
        return productDetailsDao.findByProductId(productId);
    }
}
