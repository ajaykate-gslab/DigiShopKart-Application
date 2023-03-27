package com.example.digishopkart.repository;

import com.example.digishopkart.entity.CustomerAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerAddressRepository extends JpaRepository<CustomerAddressEntity,Integer> {
}
