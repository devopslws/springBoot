package com.demo.shop.entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.EntityListeners;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass   // 상속받는 엔티티에 컬럼이 매핑됨
@EntityListeners(AuditingEntityListener.class)  // auditing 기능 적용
public abstract class CommonColumn {

    @CreatedDate//입력 시간에 자동으로 맞춰 생성됨
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate//수정시 자동 갱신
    private LocalDateTime updatedAt;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted = false;
}
