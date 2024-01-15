package com.main.fashionstore.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.cdi.Eager;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "account")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer account_id;

    String username;
    String fullname;
    Boolean gender;
    String email;
    String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    Role role;

    @JsonIgnore
    @OneToMany(mappedBy = "account")
    List<Order> orders;

    @OneToOne
    @JoinColumn(name = "cart_id")
    Cart cart;
}
