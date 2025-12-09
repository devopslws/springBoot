package com.demo.shop._01_users;

import com.demo.shop._00_common.ResponseBuilder;
import com.demo.shop._00_common.models.CreateResDTO;
import com.demo.shop._00_common.models.UpdateResDTO;
import com.demo.shop._01_users.models.SignupReqDTO;
import com.demo.shop._01_users.models.UpdateUserInfoReqDTO;
import com.demo.shop.entities.User;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name="api_1", description = "회원 가입 및 회원 관리 기능")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // ------------------------------
    // 회원 가입
    // ------------------------------
    @Operation(summary = "회원 가입", description = "신규 회원을 생성합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "회원 생성 완료",
                    content = @Content(schema = @Schema(implementation = CreateResDTO.class))),
            @ApiResponse(responseCode = "400", description = "유효성 검증 실패"),
            @ApiResponse(responseCode = "409", description = "중복된 회원 존재")
    })
    @PostMapping("/user")
    public ResponseEntity<CreateResDTO> registerUser(
            @Valid
            @RequestBody(description = "회원 가입 요청 DTO", required = true,
                    content = @Content(schema = @Schema(implementation = SignupReqDTO.class)))
            @org.springframework.web.bind.annotation.RequestBody SignupReqDTO signupReq) {

        int id = userService.registerUser(signupReq);
        return ResponseBuilder.postResponse(String.valueOf(id), new CreateResDTO());
    }

    // ------------------------------
    // 회원 상세 조회
    // ------------------------------
    @Operation(summary = "회원 상세 조회", description = "회원 ID를 통해 상세 정보를 조회합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "조회 성공"),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 회원")
    })
    @GetMapping("/user/{id}")
    public User findUserDetail(
            @Parameter(description = "회원 ID", example = "1")
            @PathVariable int id) {
        return userService.findUserDetail(id);
    }

    // ------------------------------
    // 회원 정보 수정
    // ------------------------------
    @Operation(summary = "회원 정보 수정", description = "회원 정보를 갱신합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "수정 완료",
                    content = @Content(schema = @Schema(implementation = UpdateResDTO.class))),
            @ApiResponse(responseCode = "400", description = "유효성 검증 실패"),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 회원")
    })
    @PutMapping("/user")
    public ResponseEntity<UpdateResDTO> updateUser(
            @Valid
            @RequestBody(description = "회원 수정 요청 DTO", required = true,
                    content = @Content(schema = @Schema(implementation = UpdateUserInfoReqDTO.class)))
            @org.springframework.web.bind.annotation.RequestBody UpdateUserInfoReqDTO updateUserInfoReq) {

        int id = userService.updateUserInfo(updateUserInfoReq);
        return ResponseBuilder.postResponse(String.valueOf(id), new CreateResDTO());
    }

    // ------------------------------
    // 회원 삭제
    // ------------------------------
    @Operation(summary = "회원 삭제", description = "회원 ID를 기반으로 회원을 삭제합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "삭제 성공"),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 회원")
    })
    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteUser(
            @Parameter(description = "회원 ID", example = "1")
            @PathVariable int id) {

        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
