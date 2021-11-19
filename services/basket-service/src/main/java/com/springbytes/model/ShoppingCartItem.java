package com.springbytes.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class ShoppingCartItem implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer quantity;
    private String color;
    private double price;
    private String productId;
    private String productName;
}
