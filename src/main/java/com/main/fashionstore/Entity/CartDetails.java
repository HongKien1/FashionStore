package com.main.fashionstore.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "cartdetails")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDetails implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer cartdetails_id;

    Integer quantity;

    Double total;

    Double price;

    @ManyToOne
    @JoinColumn(name = "productdetails_id")
    ProductDetails productdetails;
}
