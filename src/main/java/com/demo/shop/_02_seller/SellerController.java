package com.demo.shop._02_seller;

import com.demo.shop._00_common.ResponseBuilder;
import com.demo.shop._00_common.models.CreateResDTO;
import com.demo.shop._00_common.models.ReadResDTO;
import com.demo.shop._02_seller.models.PromoteUserToSellerReqDTO;
import com.demo.shop._02_seller.models.RegisterGoodsReqDTO;
import com.demo.shop.entities.Goods;
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
    public ResponseEntity<CreateResDTO> promoteUserToSeller(@Valid @RequestBody PromoteUserToSellerReqDTO promoteUserToSellerReqDTO) {
        Integer sellerId = sellerService.promoteUserToSeller(promoteUserToSellerReqDTO);
        return ResponseBuilder.postResponse(String.valueOf(sellerId), new ReadResDTO(sellerId));
    }

    @PostMapping("/goods")
    public ResponseEntity<CreateResDTO> registerGoods(@Valid @RequestBody RegisterGoodsReqDTO registerGoods) {
        int id = sellerService.registerGoods(registerGoods);
        return ResponseBuilder.postResponse(String.valueOf(id), new CreateResDTO());
    }

    @GetMapping("/goods/{id}")
    public Goods getGoodsInfoDetail(@PathVariable int id) {
        return sellerService.getGoodsInfoDetail(id);
    }


}
