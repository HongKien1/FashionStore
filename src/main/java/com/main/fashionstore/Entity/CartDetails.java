package com.main.fashionstore.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "cartdetails")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartDetails implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer cartdetails_id;

    Integer quantity;

    Double total;

    @ManyToOne
    @JoinColumn(name = "productdetails_id")
    ProductDetails productdetails;

    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    Cart cart;
}
