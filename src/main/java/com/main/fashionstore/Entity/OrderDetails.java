package com.main.fashionstore.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "orderdetail")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetails implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer orderdetail_id;

    @ManyToOne
    @JoinColumn(name = "orderstatus_id")
    OrderStatus orderstatus;


    Integer quantity;

    @OneToOne
    @JoinColumn(name = "order_id")
    Order order;

    @ManyToOne
    @JoinColumn(name = "productDetails")
    ProductDetails productDetail;
}
