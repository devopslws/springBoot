package com.demo.shop._02_seller;

import com.demo.shop._01_users.UserRepo;
import com.demo.shop._01_users.models.SignupReqDTO;
import com.demo.shop._02_seller.models.PromoteUserToSellerReqDTO;
import com.demo.shop.entities.Goods;
import com.demo.shop.entities.Sellers;
import jakarta.validation.Valid;
import org.springframework.stereotype.Component;

@Component
public class SellerService {
    private final SellerRepo sellerRepo;
    private final GoodsRepo goodsRepo;

    public SellerService (SellerRepo sellerRepo, GoodsRepo goodsRepo) {
        this.sellerRepo = sellerRepo;
        this.goodsRepo = goodsRepo;
    }

    public int promoteUserToSeller(PromoteUserToSellerReqDTO promoteUserToSellerReqDTO) {
        Sellers newSeller = Sellers.builder()
                .userId(promoteUserToSellerReqDTO.getUserId())
                .storeName(promoteUserToSellerReqDTO.getStoreName())
                .build();

        Sellers seller = sellerRepo.save(newSeller);
        return seller.getSellerId();
    }

    public int registerGoods( SignupReqDTO signupReq) {
    }

    public Goods getGoodsInfoDetail(int id) {
        return goodsRepo
    }
}
