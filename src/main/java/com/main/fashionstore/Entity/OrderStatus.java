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

    // Nếu quan hệ @OneToMany là với chính nó, hãy chú ý để tránh vòng lặp vô hạn
    @JsonIgnore
    @OneToMany(mappedBy = "parentOrderStatus")
    List<OrderStatus> childOrderStatus;

    @ManyToOne
    @JoinColumn(name = "parent_orderstatus_id")
    OrderStatus parentOrderStatus;

    // Getter và setter cho childOrderStatus và parentOrderStatus
}
