package com.demo.shop._01_users.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
@Schema(description = "사용자 가입 요청 DTO")
public class UpdateUserInfoReqDTO extends SignupReqDTO{

    @Schema(
            description = "id값",
            example = "1"
    )
    @NotBlank(message = "id는 필수 입력값입니다.")
    private int id;
}