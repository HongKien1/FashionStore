package com.main.fashionstore.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Nationalized;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "color")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Color implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "color_id")
    Integer color_id;

    @NotBlank(message = "Vui lòng nhập màu")
    @Basic
    @Column(name = "color")
    String color;

    @JsonIgnore
    @OneToMany(mappedBy = "color")
    List<ProductDetails> productDetails;
}
