package com.demo.shop.entities;

import com.demo.shop.entities.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;


@Entity
@Table(name = "sellers")
@Getter
@SQLDelete(sql = "UPDATE sellers SET is_deleted = true WHERE id = ?") //delete 기능을 softDelete로 치환
@SQLRestriction("is_deleted = false") //softDelete가 false인 컬럼만 조회하도록 묵시 적용
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder //간접적인 생성.
public class Sellers extends CommonColumn{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sellerId;

    private String storeName;

    // FK 값만 들고 있는 실 필드
    @Column(name = "user_id")
    private int userId;

    // 지연 로딩 관계 (insert/update X)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;
}
