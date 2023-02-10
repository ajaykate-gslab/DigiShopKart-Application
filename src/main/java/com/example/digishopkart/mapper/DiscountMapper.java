package com.example.digishopkart.mapper;

import com.example.digishopkart.entity.Discount;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DiscountMapper {

    DiscountMapper INSTANCE= Mappers.getMapper(DiscountMapper.class);

    Discount DiscountModelToDiscountEntity(com.example.digishopkart.model.Discount discount);
    com.example.digishopkart.model.Discount DiscountEntityToDiscountModel(Discount discount);

}
