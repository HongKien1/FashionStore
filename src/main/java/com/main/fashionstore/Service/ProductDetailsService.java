package com.main.fashionstore.Service;

import com.main.fashionstore.Dao.ProductDao;
import com.main.fashionstore.Dao.ProductDetailsDao;
import com.main.fashionstore.Entity.ProductDetails;

import jakarta.persistence.criteria.CriteriaBuilder.In;

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
        return optionalProduct.orElse(null);
    }

    public ProductDetails saveProductDetails(ProductDetails productDetails) {
        return productDetailsDao.save(productDetails);
    }

    public void deleteProductDetails(Integer id) {
        productDetailsDao.deleteById(id);
    }

    public List<ProductDetails> findByProductId(Integer productId) {
        return productDetailsDao.findByProductId(productId);
    }

    public ProductDetails getProductDetailsById(Integer productDetailsId) {
        return productDetailsDao.findById(productDetailsId).orElse(null);
    }

    public ProductDetails findProductDetailsIdByColorSizeProductId(Integer colorId, Integer sizeId, Integer productId) {
        return productDetailsDao.findProductDetailsByColorSizeProductId(colorId, sizeId, productId);
    }
}
