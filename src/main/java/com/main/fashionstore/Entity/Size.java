package com.main.fashionstore.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

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

    @NotBlank(message = "Vui lòng nhập kích cỡ")
    @Basic
    @Column(name = "size_name")
    String size_name;

    @JsonIgnore
    @OneToMany(mappedBy = "size")
    List<ProductDetails> productDetails;
}
