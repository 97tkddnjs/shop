package com.example.shop.repository;

import com.example.shop.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository interface key에 entity, val 에 p.k <- type
public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByEmail(String email);
}


