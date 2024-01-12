package com.main.fashionstore.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "productdetails")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetails implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer productdetails_id;

    Double price;
    Integer quantity;

    @JsonIgnore
    @OneToMany(mappedBy = "productDetail")
    List<OrderDetails> orderDetails;

    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;

    @ManyToOne
    @JoinColumn(name = "color_id")
    Color color;

    @ManyToOne
    @JoinColumn(name = "size_id")
    Size size;

    @JsonIgnore
    @OneToMany(mappedBy = "productdetails")
    List<CartDetails> cartDetails;
}
