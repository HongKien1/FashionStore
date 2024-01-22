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
@Table(name = "orderstatus")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderStatus implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer orderStatus_id;

    @Nationalized
    String orderStatus_name;

    @JsonIgnore
    @OneToMany(mappedBy = "orderstatus")
    List<OrderDetails> orderDetails;
}
