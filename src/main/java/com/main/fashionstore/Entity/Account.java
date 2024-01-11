package com.main.fashionstore.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.cdi.Eager;

@Entity
@Table(name = "account")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
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
    Role roles;

    @OneToOne(mappedBy = "account")
    Cart cart;
}
