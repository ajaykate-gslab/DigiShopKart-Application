package com.example.digishopkart.mapper;

import com.example.digishopkart.entity.OrderEntity;
import com.example.digishopkart.model.Order;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-21T11:26:42+0530",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderEntity OrderModelToOrderEntity(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderEntity orderEntity = new OrderEntity();

        if ( order.getOrderId() != null ) {
            orderEntity.setOrderId( order.getOrderId() );
        }
        orderEntity.setActivatedAt( order.getActivatedAt() );
        orderEntity.setUpdatedAt( order.getUpdatedAt() );
        orderEntity.setOrderStatus( order.getOrderStatus() );

        return orderEntity;
    }

    @Override
    public Order OrderEntityToOrderModel(OrderEntity orderEntity) {
        if ( orderEntity == null ) {
            return null;
        }

        Order order = new Order();

        order.setOrderId( orderEntity.getOrderId() );
        order.setActivatedAt( orderEntity.getActivatedAt() );
        order.setUpdatedAt( orderEntity.getUpdatedAt() );
        order.setOrderStatus( orderEntity.getOrderStatus() );

        return order;
    }
}
