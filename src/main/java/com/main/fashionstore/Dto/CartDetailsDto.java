package com.main.fashionstore.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDetailsDto {
    private Integer ProductDetailsId;
    private String color;
    private String size;
    private Integer cartId;
    private Integer quantity;
    private Double price;
}
