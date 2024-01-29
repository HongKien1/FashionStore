package com.main.fashionstore.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer order_id;

    Integer quantity;

    Double total;

    @Nationalized
    String name;

    @Nationalized
    String address;

    Number phonenumber;

    @Nationalized
    String note;

    @JsonIgnore
    @OneToMany(mappedBy = "order")
    List<OrderDetails> orderDetails;

    @ManyToOne
    @JoinColumn(name = "account")
    Account account;
}
