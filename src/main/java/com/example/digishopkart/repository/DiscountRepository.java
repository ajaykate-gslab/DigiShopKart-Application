package com.example.digishopkart.repository;

import com.example.digishopkart.entity.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<Discount,Integer> {
}
