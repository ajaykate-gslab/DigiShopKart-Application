package com.example.digishopkart.repository;

import com.example.digishopkart.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface OrderRepository extends JpaRepository<OrderEntity,Integer> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE orders s SET s.status=:status WHERE s.order_id=:order_id",nativeQuery = true)
    int updateSubscriptionStatus(@Param("status") String status, @Param("order_id") Integer order_id);

}
