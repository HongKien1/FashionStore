package com.main.fashionstore.Service;

import com.main.fashionstore.Dao.BrandDao;
import com.main.fashionstore.Entity.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BrandService {

    @Autowired
    BrandDao brandDao;

    // hiển thị tất cả thương hiệu
    public List<Brand> getAllBrands() {
        return brandDao.findAll();
    }

    //tìm thương hiệu
    public Brand getBrandById(Integer brandId) {
        return brandDao.findById(brandId).orElse(null);
    }

    //thêm hoặc lưu thương hiệu
    public void saveBrand(Brand brand) {
        brandDao.save(brand);
    }

    //xóa thương hiệu
    public void deleteBrand(Integer brandId) {
        brandDao.deleteById(brandId);
    }
}

