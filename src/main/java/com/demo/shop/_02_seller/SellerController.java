package com.demo.shop._02_seller;

import com.demo.shop._00_common.ResponseBuilder;
import com.demo.shop._00_common.models.CreateResDTO;
import com.demo.shop._01_users.UserService;
import com.demo.shop._01_users.models.SignupReqDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name="api_2", description = "판매자 등록 및 상품 등록")
public class SellerController {
    private final SellerService sellerService;

    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }
    @PostMapping("/seller")
    public ResponseEntity<CreateResDTO> promoteUserToSeller(@Valid @RequestBody SignupReqDTO signupReq) {
        int sellerId = sellerService.promoteUserToSeller(signupReq);
        return ResponseBuilder.postResponse(String.valueOf(sellerId), new CreateResDTO());
    }

    @PostMapping("/goods")
    public ResponseEntity<CreateResDTO> registerGoods(@Valid @RequestBody SignupReqDTO signupReq) {
        int id = sellerService.registerGoods(signupReq);
        return ResponseBuilder.postResponse(String.valueOf(id), new CreateResDTO());
    }

    @GetMapping("/goods/{id}")
    public ResponseEntity<CreateResDTO> getGoodsInfoDetail(@PathVariable int id) {
        sellerService.getGoodsInfoDetail(id);
        return ResponseBuilder.postResponse(String.valueOf(id), new CreateResDTO());
    }

    @PutMapping("/goods/{id}")
    public ResponseEntity<CreateResDTO> modifyGoodsInfoDetail(@Valid @RequestBody SignupReqDTO signupReq) {
        int id = sellerService.modifyGoodsInfoDetail(signupReq);
        return ResponseBuilder.postResponse(String.valueOf(id), new CreateResDTO());
    }

    @DeleteMapping("/goods/{id}")
    public ResponseEntity<CreateResDTO> deleteGoods(@PathVariable int id) {
        sellerService.deleteGoods(signupReq);
        return ResponseBuilder.postResponse(String.valueOf(id), new CreateResDTO());
    }
}
