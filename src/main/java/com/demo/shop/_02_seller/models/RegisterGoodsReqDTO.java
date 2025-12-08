package com.demo.shop._02_seller.models;

import lombok.Data;

@Data
public class RegisterGoodsReqDTO {
    private String name;
    private int quantity;
    private int sellerId;
}
