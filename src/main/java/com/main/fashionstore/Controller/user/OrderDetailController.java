package com.main.fashionstore.Controller.user;

import com.main.fashionstore.Dao.OrderDao;
import com.main.fashionstore.Dao.OrderDetailsDao;
import com.main.fashionstore.Dao.OrderStatusDao;
import com.main.fashionstore.Entity.*;
import com.main.fashionstore.Service.CartDetailsService;
import com.main.fashionstore.Service.OrderService;
import com.main.fashionstore.Service.ParamService;
import com.main.fashionstore.Service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("orderDetail")
public class OrderDetailController {
    @Autowired
    CartDetailsService cartDetailsService;

    @Autowired
    ParamService paramService;

    @Autowired
    SessionService sessionService;

    @Autowired
    OrderService orderService;

    @Autowired
    OrderDao orderDao;

    @Autowired
    OrderDetailsDao orderDetailsDao;

    @Autowired
    OrderStatusDao orderStatusDao;

    @GetMapping("")
    public String index(Model model) {
        Account account = sessionService.get(("account"));
        // Lấy danh sách các chi tiết giỏ hàng từ dịch vụ hoặc repository
        List<CartDetails> cartDetails = cartDetailsService.getAllCartDetails();

        // Khởi tạo biến tổng tiền
        double totalPrice = 0;

        // Duyệt qua từng chi tiết giỏ hàng và tính tổng tiền
        for (CartDetails cartDetail : cartDetails) {
            totalPrice += cartDetail.getTotal(); // Giả sử có một phương thức getTotal() trong lớp CartDetails để lấy tổng giá của mỗi sản phẩm
        }

        // Thêm danh sách chi tiết giỏ hàng và tổng tiền vào mô hình để truyền vào view
        model.addAttribute("account", account);
        model.addAttribute("cartDetailsPayment", cartDetails);
        model.addAttribute("totalPrice", totalPrice);

        // Trả về tên view để hiển thị
        return "user/orderDetail";
    }

    @PostMapping("/order")
    public String order(Model model) {
        String name = paramService.getString("name", "");
        String address = paramService.getString("address", "");
        String note = paramService.getString("note", "");
        String numberPhone = paramService.getString("numberPhone", "");


        Account account = sessionService.get("account");

        // Lấy danh sách chi tiết giỏ hàng
        List<CartDetails> cartDetails = cartDetailsService.getAllCartDetails();
        double totalPrice = 0;

        // Tính tổng tiền
        for (CartDetails cartDetail : cartDetails) {
            totalPrice += cartDetail.getTotal(); // Giả sử có một phương thức getTotal() trong lớp CartDetails để lấy tổng giá của mỗi sản phẩm
        }

        // Tạo đơn hàng mới và lưu vào cơ sở dữ liệu
        Order order = new Order();
        order.setName(name);
        order.setAddress(address);
        order.setNote(note);
        order.setTotal(totalPrice);
        order.setPhonenumber(numberPhone);
        order.setAccount(account);
        orderDao.save(order);

        // Lưu thông tin chi tiết đơn hàng vào cơ sở dữ liệu
        for (CartDetails cartDetail : cartDetails) {
            OrderDetails orderDetails = new OrderDetails();
            orderDetails.setQuantity(cartDetail.getQuantity());
            orderDetails.setProductDetail(cartDetail.getProductdetails()); // Giả sử có một phương thức getProductdetails() trong lớp CartDetails để lấy chi tiết sản phẩm
            // Thiết lập trạng thái đơn hàng cho mỗi chi tiết đơn hàng - Đây là nơi bạn cần cung cấp thông tin về trạng thái đơn hàng
            orderDetails.setOrder(order); // Thiết lập đơn hàng cho mỗi chi tiết đơn hàng

            // Đặt giá trị mặc định cho trường orderstatus
            OrderStatus defaultOrderStatus = new OrderStatus();
            defaultOrderStatus.setOrderStatus_id(1); // Giả sử id của trạng thái mặc định là 1
            orderDetails.setOrderstatus(defaultOrderStatus);

            orderDetailsDao.save(orderDetails);
        }

        return "user/historyOrder";
    }


}