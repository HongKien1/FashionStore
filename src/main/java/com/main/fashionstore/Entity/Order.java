package com.main.fashionstore.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "order_table")  // Thay đổi tên bảng để tránh từ khóa "order"
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer order_id;

    Integer quantity;
    Double total;
    String name;
    String address;
    Number phonenumber;
    String note;

    @JsonIgnore
    @OneToMany(mappedBy = "order")
    List<OrderDetails> orderDetails;

    @ManyToOne
    @JoinColumn(name = "account")
    Account account;
}
