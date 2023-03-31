package com.example.shop.entity;

import com.example.shop.constant.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="orders")
public class Order extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private LocalDateTime orderDate;    //주문일

    @Enumerated(EnumType.ORDINAL)
    private OrderStatus orderStatus;    //주문 상태

    // 영속성을 부모와 같이 따라가도록 만든다.
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL,
            orphanRemoval = true , fetch = FetchType.LAZY)
    private List<OrderItem> orderItems = new ArrayList<>();



}
