package com.demo.shop._00_common;

import com.demo.shop._01_users.models.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@Tag(name="ping", description = "연결 확인 기능")

public class HealthCheckController {

    @Operation(summary = "healthCheck", description = "이거 안되면 문제 있는거임")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "정상 반환"),
        @ApiResponse(responseCode = "400", description = "잘못된 요청값"),
        @ApiResponse(responseCode = "404", description = "URL잘못됨"),
        @ApiResponse(responseCode = "500", description = "server장애"),

    })
    @GetMapping("/healthCheck")
    public String healthCheck() {
        return "hello";
    }


    /*
        ResponseEntity.ok()          // 200 OK
        ResponseEntity.created()     // 201 Created
        ResponseEntity.noContent()   // 204 No Content
        ResponseEntity.notFound()    // 404 Not Found
    */
}