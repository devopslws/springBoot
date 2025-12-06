package com.demo.shop._02_seller;

import com.demo.shop._01_users.UserRepo;
import com.demo.shop._01_users.models.SignupReqDTO;
import com.demo.shop.entities.Sellers;
import org.springframework.stereotype.Component;

@Component
public class SellerService {



    private final SellerRepo sellerRepo;

    public SellerService (SellerRepo sellerRepo) {
        this.sellerRepo = sellerRepo;
    }

    public int promoteUserToSeller(SignupReqDTO signupReq) {
        Sellers newSeller = Sellers.builder().build();

        Sellers seller = sellerRepo.save(newSeller);
        return seller.getSellerId();
    }
}
