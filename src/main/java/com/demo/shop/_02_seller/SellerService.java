package com.demo.shop._02_seller;

import com.demo.shop._01_users.UserRepo;
import com.demo.shop._02_seller.models.PromoteUserToSellerReqDTO;
import com.demo.shop._02_seller.models.RegisterGoodsReqDTO;
import com.demo.shop.entities.Goods;
import com.demo.shop.entities.Sellers;
import com.demo.shop.entities.User;
import org.springframework.stereotype.Component;

@Component
public class SellerService {
    private final SellerRepo sellerRepo;
    private final GoodsRepo goodsRepo;
    private final UserRepo userRepo;

    public SellerService (SellerRepo sellerRepo, GoodsRepo goodsRepo, UserRepo ur) {
        this.sellerRepo = sellerRepo;
        this.goodsRepo = goodsRepo;
        this.userRepo = ur;
    }

    public int promoteUserToSeller(PromoteUserToSellerReqDTO promoteUserToSellerReqDTO) {
        User user = userRepo.findById(promoteUserToSellerReqDTO.getUserId()).orElseThrow();
        Sellers newSeller = Sellers.builder()
                .user(user)
                .storeName(promoteUserToSellerReqDTO.getStoreName())
                .build();

        return sellerRepo.save(newSeller).getSellerId();
    }

    public int registerGoods( RegisterGoodsReqDTO rg) {
        Sellers seller = sellerRepo.findById(rg.getSellerId()).orElseThrow();
        return goodsRepo.save(Goods.builder()
                .name(rg.getName())
                .seller(seller)
                .quantity(rg.getQuantity())
                .build()).getGoodsId();
    }

    public Goods getGoodsInfoDetail(int id) {
        return goodsRepo.findById(id).orElseThrow(() -> new RuntimeException("유저가 존재하지 않습니다."));
    }
}
