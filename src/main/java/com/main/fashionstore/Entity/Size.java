package com.main.fashionstore.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "size")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Size implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer size_id;
    String size_name;

    @JsonIgnore
    @OneToMany(mappedBy = "size")
    List<ProductDetails> productDetails;
}
