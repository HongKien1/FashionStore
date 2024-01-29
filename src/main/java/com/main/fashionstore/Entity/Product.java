package com.main.fashionstore.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Nationalized;

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

    @Nationalized
    String name;

    Double price;

    @Nationalized
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
