package com.example.shop.repository;

import com.example.shop.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

// 의문 why interface를 implements가 아닌 extends를 할까?
public interface OrderRepository extends JpaRepository<Order, Long> {
}
