package com.demo.shop._02_seller.models;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PromoteUserToSellerReqDTO {

    @NotBlank(message = "storeName은 필수 입력값입니다.")
    private String storeName;

    @NotBlank(message = "userId는 필수 입력값입니다.")
    private int userId;
}
