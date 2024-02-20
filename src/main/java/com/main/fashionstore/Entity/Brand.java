package com.main.fashionstore.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.Nationalized;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "brand")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Brand implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer brand_id;

    @NotBlank(message = "Vui lòng nhập tên thương hiệu ")
    @Basic
    @Column(name = "brand_name")
    String brand_name;

    @JsonIgnore
    @OneToMany(mappedBy = "brand")
    List<Product> products;
}
