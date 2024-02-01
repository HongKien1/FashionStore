package com.main.fashionstore.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.main.fashionstore.Service.ProductTypeService;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "role")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer role_id;

    @Nationalized
    String role_name;

    @JsonIgnore
    @OneToMany(mappedBy ="role")
    List<ProductTypeService.Account> accounts;
}
