package com.example.digishopkart.repository;

import com.example.digishopkart.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity,Integer> {
}
