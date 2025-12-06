package com.demo.shop._01_users.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Schema(description = "사용자 가입 요청 DTO")
public class SignupReqDTO {

    @Schema(
            description = "사용자 이름",
            example = "홍길동",
            minLength = 2,
            maxLength = 10
    )
    @NotBlank(message = "이름은 필수 입력값입니다.")
    @Size(min = 2, max = 10, message = "이름은 2~10자여야 합니다.")
    private String name;


    @Schema(
            description = "휴대전화 번호 (형식: 010-XXXX-XXXX)",
            example = "010-1234-5678"
    )
    @NotBlank(message = "전화번호는 필수 입력값입니다.")
    @Pattern(
            regexp = "^010-\\d{4}-\\d{4}$",
            message = "전화번호는 010-xxxx-xxxx 형식이어야 합니다."
    )
    private String hp;


    @Schema(
            description = "주소",
            example = "서울특별시 강남구 역삼동 123",
            minLength = 2,
            maxLength = 50
    )
    @NotBlank(message = "주소는 필수 입력값입니다.")
    @Size(min = 2, max = 50, message = "주소는 2~50자여야 합니다.")
    private String address;


    @Schema(
            description = "우편번호 (4~6자리 숫자)",
            example = "06232"
    )
    @Pattern(
            regexp = "^\\d{4,6}$",
            message = "우편번호는 숫자 4~6자리여야 합니다."
    )
    private String zipCode;
}