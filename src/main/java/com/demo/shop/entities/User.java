package com.demo.shop.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;


@Entity
@Table(name = "users") //테이블명. user는 예약어라 안됨
@Getter
@SQLDelete(sql = "UPDATE users SET is_deleted = true WHERE id = ?") //delete 기능을 softDelete로 치환
@SQLRestriction("is_deleted = false") //softDelete가 false인 컬럼만 조회하도록 묵시 적용
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder //간접적인 생성.
public class User extends CommonColumn{
    @Id //pk
    @GeneratedValue //autoIncrement
    @Schema(description = "")
    private int id;

    private String name;

    private String hp;
    private String adress;
    private String zipCode;
}
