package com.demo.shop._02_seller;

import com.demo.shop.entities.Sellers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepo extends JpaRepository<Sellers, Integer> {
}
