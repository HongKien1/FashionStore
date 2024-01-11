package com.main.fashionstore.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "productType")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer productType_id;

    String productType_name;

    @JsonIgnore
    @OneToMany(mappedBy = "productType_id")
    List<ProductType> productTypes;

    @ManyToOne
    @JoinColumn(name = "parent_productType_id")
    ProductType parentProductType;

    @Column(insertable=false, updatable=false)
    Integer parent_productType_id; // Chỉ ánh xạ, không tham gia vào quá trình insert hoặc update
}
