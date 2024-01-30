package com.main.fashionstore.Service;

import com.main.fashionstore.Dao.ColorDao;
import com.main.fashionstore.Entity.Category;
import com.main.fashionstore.Entity.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColorService {
    @Autowired
    ColorDao colorDao;

    public List<Color> findAll() {
        return colorDao.findAll();
    }
     public Color saveColor(Color color){
        return colorDao.save(color);
     }

    public void removeColor(Integer color_id){
        colorDao.deleteById(color_id);
    }

    public Color findById(Integer color_id) {
        Optional<Color> optional = colorDao.findById(color_id);
        return optional.orElse(null);
    }
}
