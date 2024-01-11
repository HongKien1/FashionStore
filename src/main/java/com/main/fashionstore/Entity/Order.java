package com.main.fashionstore.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_table")  // Thay đổi tên bảng để tránh từ khóa "order"
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer order_id;

    Integer quantity;
    double total;
    String name;
    String address;
    Number phonenumber;
    String note;

    @ManyToOne
    @JoinColumn(name = "account_id")
    Account account;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "parent_order_id")  // Chỉ định tên cột phù hợp
    Order parentOrder;
}
