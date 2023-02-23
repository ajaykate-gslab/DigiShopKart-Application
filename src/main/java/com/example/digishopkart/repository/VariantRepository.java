package com.example.digishopkart.repository;

import com.example.digishopkart.entity.Variant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VariantRepository extends JpaRepository<Variant, Integer> {
}
