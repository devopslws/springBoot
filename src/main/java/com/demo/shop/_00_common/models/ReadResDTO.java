package com.demo.shop._00_common.models;

public class ReadResDTO {
    private String message = "success";
    private Object data;

    public ReadResDTO (Object o) {
        this.data = o;
    }
}
