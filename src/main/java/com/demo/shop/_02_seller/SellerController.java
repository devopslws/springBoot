package com.demo.shop._02_seller;

import com.demo.shop._00_common.ResponseBuilder;
import com.demo.shop._00_common.models.CreateResDTO;
import com.demo.shop._00_common.models.ReadResDTO;
import com.demo.shop._02_seller.models.PromoteUserToSellerReqDTO;
import com.demo.shop._02_seller.models.RegisterGoodsReqDTO;
import com.demo.shop.entities.Goods;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "api_2", description = "판매자 등록 및 상품 등록 APIs")
public class SellerController {

    private final SellerService sellerService;

    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @Operation(
            summary = "일반 사용자를 판매자로 변경",
            description = "회원의 기본 정보를 기반으로 판매자 권한을 추가 합니다.",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "판매자 전환 성공",
                            content = @Content(schema = @Schema(implementation = CreateResDTO.class))
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "유효성 검증 실패",
                            content = @Content
                    )
            }
    )
    @PostMapping("/seller")
    public ResponseEntity<CreateResDTO> promoteUserToSeller(
            @Valid
            @RequestBody
            @Parameter(description = "판매자로 승급하기 위한 사용자 정보", required = true)
            PromoteUserToSellerReqDTO promoteUserToSellerReqDTO
    ) {
        Integer sellerId = sellerService.promoteUserToSeller(promoteUserToSellerReqDTO);
        return ResponseBuilder.postResponse(String.valueOf(sellerId), new ReadResDTO(sellerId));
    }

    @Operation(
            summary = "상품 등록",
            description = "판매자가 새로운 상품을 등록합니다.",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "상품 등록 성공",
                            content = @Content(schema = @Schema(implementation = CreateResDTO.class))
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "입력 값 검증 실패",
                            content = @Content
                    )
            }
    )
    @PostMapping("/goods")
    public ResponseEntity<CreateResDTO> registerGoods(
            @Valid
            @RequestBody
            @Parameter(description = "상품 등록 요청 데이터", required = true)
            RegisterGoodsReqDTO registerGoods
    ) {
        int id = sellerService.registerGoods(registerGoods);
        return ResponseBuilder.postResponse(String.valueOf(id), new CreateResDTO());
    }

    @Operation(
            summary = "상품 상세 조회",
            description = "상품 ID를 기준으로 상품의 상세 정보를 조회합니다.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "상품 조회 성공",
                            content = @Content(schema = @Schema(implementation = Goods.class))
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "상품을 찾을 수 없음",
                            content = @Content
                    )
            }
    )
    @GetMapping("/goods/{id}")
    public Goods getGoodsInfoDetail(
            @Parameter(description = "조회하고자 하는 상품 ID", example = "1")
            @PathVariable int id
    ) {
        return sellerService.getGoodsInfoDetail(id);
    }
}
