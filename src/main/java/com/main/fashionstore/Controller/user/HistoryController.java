package com.main.fashionstore.Controller.user;

import com.main.fashionstore.Dao.OrderDao;
import com.main.fashionstore.Dao.OrderDetailsDao;
import com.main.fashionstore.Dao.OrderStatusDao;
import com.main.fashionstore.Entity.Order;
import com.main.fashionstore.Entity.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("history")
public class HistoryController {
    @Autowired
    OrderDetailsDao orderDetailsDao;

    @Autowired
    OrderDao orderDao;

    @GetMapping("")
    public String index(Model model) {
        List<OrderDetails> orderList = orderDetailsDao.findAll();
        model.addAttribute("orderLists", orderList);
        return "redirect:/history";
    }
}
