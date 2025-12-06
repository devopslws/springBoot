package com.demo.shop._00_common.models;

import lombok.Data;

@Data
public class CreateResDTO {
    private String message = "create success";
    private Object data;
}
