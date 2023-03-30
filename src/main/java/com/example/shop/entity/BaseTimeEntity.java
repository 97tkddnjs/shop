package com.example.shop.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;


@EntityListeners(value = {AuditingEntityListener.class}) // 익명 클래스, 람다 개념
@MappedSuperclass   // 부모에 있는 클래스를 상속 받는 자식 클래스에 매핑 정보만 제공
@Getter
@Setter
public class BaseTimeEntity {


    @CreatedDate
    @Column(updatable = false)
    private String regTime;

    @LastModifiedBy
    private String updateTime;
}
