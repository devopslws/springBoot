package com.demo.shop._02_seller;

import com.demo.shop.entities.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsRepo extends JpaRepository<Goods, Integer> {
}
