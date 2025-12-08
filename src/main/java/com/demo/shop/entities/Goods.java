package com.demo.shop.entities;
import com.demo.shop.entities.CommonColumn;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;


@Entity
@Table(name = "goods")
@Getter
@SQLDelete(sql = "UPDATE goods SET is_deleted = true WHERE id = ?") //delete 기능을 softDelete로 치환
@SQLRestriction("is_deleted = false") //softDelete가 false인 컬럼만 조회하도록 묵시 적용
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder //간접적인 생성.
public class Goods extends CommonColumn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int goodsId;
    private int storeId;
    private int categoryId;
    private String name;
    private int quantity;
    private int orderProceed;
}
