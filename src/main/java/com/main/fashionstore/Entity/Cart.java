package com.main.fashionstore.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "cart")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer cart_id;


    @OneToOne
    @JoinColumn(name = "account_id")
    Account account;

    @JsonIgnore
    @OneToMany(mappedBy = "cart")
    List<CartDetails> cartDetails;
}
