package com.main.fashionstore.Service;

import com.main.fashionstore.Dao.SizeDao;
import com.main.fashionstore.Entity.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SizeService {

    @Autowired
    SizeDao sizeDao;

    public List<Size> getAllSizes() {
        return sizeDao.findAll();
    }

    public Optional<Size> getSizeById(Integer id) {
        return sizeDao.findById(id);
    }

    public Size saveSize(Size size) {
        return sizeDao.save(size);
    }

    public void deleteSize(Integer id) {
        sizeDao.deleteById(id);
    }
}
