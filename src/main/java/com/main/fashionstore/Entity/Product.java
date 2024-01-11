package com.main.fashionstore.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer product_id;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    Brand brand;

    String name;

    String describe;

    String image;

    @JsonIgnore
    @OneToMany(mappedBy = "product_id")
    List<Product> products;

    @ManyToOne
    @JoinColumn(name = "productType_id")
    ProductType productType;
}
