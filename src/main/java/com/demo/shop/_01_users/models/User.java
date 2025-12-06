package com.demo.shop._01_users.models;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class User {
    @Size(min=2, message="2자 이상 입력")
    String name;

    @Past
    Date toDate;
}
