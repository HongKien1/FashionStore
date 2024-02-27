package com.main.fashionstore.Service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.main.fashionstore.Dao.ProductTypeDao;
import com.main.fashionstore.Entity.Cart;
import com.main.fashionstore.Entity.Order;
import com.main.fashionstore.Entity.ProductType;
import com.main.fashionstore.Entity.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Nationalized;
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