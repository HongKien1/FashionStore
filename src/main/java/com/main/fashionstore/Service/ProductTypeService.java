package com.main.fashionstore.Service;

import com.main.fashionstore.Dao.ProductTypeDao;
import com.main.fashionstore.Entity.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductTypeService {

    @Autowired
    ProductTypeDao productTypeService;

    //Hiên thị tất cả loại sản phẩm
    public List<ProductType> getAllProductTypes() {
        return productTypeService.findAll();
    }

    //tìm loại sản phẩm
    public ProductType getProductTypeById(Integer productTypeId) {
        return productTypeService.findById(productTypeId).orElse(null);
    }

    //thêm hoặc lưu sản phẩm
    public void saveProductType(ProductType productType) {
        productTypeService.save(productType);
    }

    // xóa sản phâ
    public void deleteProductType(Integer productTypeId) {
        productTypeService.deleteById(productTypeId);
    }
}

