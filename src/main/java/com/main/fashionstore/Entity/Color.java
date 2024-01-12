package com.main.fashionstore.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "color")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Color implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer color_id;
    String color;

    @JsonIgnore
    @OneToMany(mappedBy = "color")
    List<ProductDetails> productDetails;
}
