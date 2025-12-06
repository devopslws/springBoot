package com.demo.shop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
    AOP처리로 위임하며 에러 코드를 통합 관리
@ResponseStatus(HttpStatus.NOT_FOUND)
* */
public class UserNotfoundExceptions extends RuntimeException{
    public UserNotfoundExceptions(String message) {
        super(message);
    }
}
