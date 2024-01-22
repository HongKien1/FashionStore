package com.main.fashionstore.Dto;

import com.main.fashionstore.Entity.Brand;
import com.main.fashionstore.Entity.ProductType;
import lombok.Data;

import java.io.Serializable;

@Data
public class ProductDto implements Serializable {

    Integer product_id;

    String name;

    String describe;

    ProductType productType;

    Brand brand;
}
