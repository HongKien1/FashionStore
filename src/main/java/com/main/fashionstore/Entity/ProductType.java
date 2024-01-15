package com.main.fashionstore.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "productType")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer productType_id;

    String productType_name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category_id;

    @JsonIgnore
    @OneToMany(mappedBy = "productType")
    List<Product> products;
}
