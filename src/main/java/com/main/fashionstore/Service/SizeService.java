package com.main.fashionstore.Service;

import com.main.fashionstore.Dao.BrandDao;
import com.main.fashionstore.Dao.SizeDao;
import com.main.fashionstore.Entity.Brand;
import com.main.fashionstore.Entity.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizeService {

    @Autowired
    SizeDao sizeDao;

    // hiển thị tất cả thương hiệu
    public List<Size> getAllSize() {
        return sizeDao.findAll();
    }

    //tìm thương hiệu
    public Size getSizeById(Integer size) {
        return sizeDao.findById(size).orElse(null);
    }

    //thêm hoặc lưu thương hiệu
    public void saveSize(Size size) {
        sizeDao.save(size);
    }

    //xóa thương hiệu
    public void deleteSize(Integer brandId) {
        sizeDao.deleteById(brandId);
    }
}

