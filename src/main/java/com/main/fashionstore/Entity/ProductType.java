package com.main.fashionstore.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Nationalized;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "productType")
@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer productType_id;

    @Nationalized
    String productType_name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category_id;

    @JsonIgnore
    @OneToMany(mappedBy = "productType")
    List<Product> products;
}
