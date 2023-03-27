package com.example.digishopkart.mapper;

import com.example.digishopkart.entity.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderMapper INSTANCE= Mappers.getMapper(OrderMapper.class);
    //@Mappings({@Mapping(target = "activatedAt", source = "activatedAt")})
    OrderEntity OrderModelToOrderEntity(com.example.digishopkart.model.Order order);

    //@Mappings({@Mapping(target = "activatedAt", source = "activatedAt")})
    com.example.digishopkart.model.Order OrderEntityToOrderModel(OrderEntity orderEntity);

}
