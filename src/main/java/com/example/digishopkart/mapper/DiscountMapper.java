package com.example.digishopkart.mapper;

import com.example.digishopkart.entity.DiscountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DiscountMapper {

    DiscountMapper INSTANCE= Mappers.getMapper(DiscountMapper.class);
    DiscountEntity DiscountModelToDiscountEntity(com.example.digishopkart.model.Discount discount);
    com.example.digishopkart.model.Discount DiscountEntityToDiscountModel(DiscountEntity discountEntity);

}
