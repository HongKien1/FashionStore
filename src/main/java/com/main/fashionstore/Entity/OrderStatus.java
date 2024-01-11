package com.main.fashionstore.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "orderstatus")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer orderStatus_id;

    String orderStatus_name;

    @OneToMany
    @JoinColumn(name = "parent_orderstatus_id")
    OrderDetails orderDetails;

    // Getter và setter cho childOrderStatus và parentOrderStatus
}
