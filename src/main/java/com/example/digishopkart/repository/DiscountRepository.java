package com.example.digishopkart.repository;

import com.example.digishopkart.entity.DiscountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends JpaRepository<DiscountEntity,Integer> {
}
