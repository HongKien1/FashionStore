package com.main.fashionstore.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer product_id;

    String name;

    String describe;

    String image;

    @ManyToOne
    @JoinColumn(name = "productType_id")
    ProductType productType;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    Brand brand;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    List<ProductDetails> productsDetails;
}
