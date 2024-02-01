package com.main.fashionstore.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Nationalized;

import java.io.Serializable;
import java.util.List;
@SuppressWarnings("serial")
@Entity
@Table(name = "account")
@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer account_id;

    @Nationalized
    String username;

    @Nationalized
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

    @JsonIgnore
    @OneToOne(mappedBy = "account")
    Cart cart;

}
