package com.demo.shop._02_seller;

import com.demo.shop._02_seller.models.PromoteUserToSellerReqDTO;
import com.demo.shop._02_seller.models.RegisterGoodsReqDTO;
import com.demo.shop.entities.Goods;
import com.demo.shop.entities.Sellers;
import org.springframework.stereotype.Component;

import java.util.Optional;

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

        return sellerRepo.save(newSeller).getSellerId();
    }

    public int registerGoods( RegisterGoodsReqDTO rg) {
        return goodsRepo.save(Goods.builder()
                .name(rg.getName())
                .storeId(rg.getStoreId())
                .quantity(rg.getQuantity())
                .build()).getGoodsId();
    }

    public Goods getGoodsInfoDetail(int id) {
        return goodsRepo.findById(id).orElseThrow(() -> new RuntimeException("유저가 존재하지 않습니다."));
    }
}
