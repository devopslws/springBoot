package com.demo.shop._01_users.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Schema(description = "로그인reqDTO")
public class LoginReqDTO {

    @Schema(
            description = "가입시 입력 휴대전화 번호 (형식: 010-XXXX-XXXX)",
            example = "010-1234-5678"
    )
    @NotBlank(message = "전화번호는 필수 입력값입니다.")
    @Pattern(
            regexp = "^010-\\d{4}-\\d{4}$",
            message = "전화번호는 010-xxxx-xxxx 형식이어야 합니다."
    )
    private String hp;

    @Schema(
            description = "가입 id",
            example = "1"
    )
    private String name;
}
