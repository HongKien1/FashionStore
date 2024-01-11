package com.main.fashionstore.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cartdetails")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer cartdetails_id;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    Cart cart;

    @ManyToOne
    @JoinColumn(name = "productcartdetails_id")
    ProductDetails productcartdetails_id;

    Integer quantity;

    double total;

    @Column(insertable=false, updatable=false)
    Integer cart_id; // Chỉ ánh xạ, không tham gia vào quá trình insert hoặc update
}
