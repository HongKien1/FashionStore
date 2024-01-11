package com.main.fashionstore.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "productdetails")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer productdetails_id;

    Integer quantity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product_id;

    @ManyToOne
    @JoinColumn(name = "color_id")
    Color color;

    @ManyToOne
    @JoinColumn(name = "Size_id")
    Size size;


    @JsonIgnore
    @OneToMany(mappedBy = "productdetails_id")
    List<OrderDetails> orderDetails;

    @JsonIgnore
    @OneToMany(mappedBy = "productcartdetails_id")
    List<CartDetails> cartDetails;
}
