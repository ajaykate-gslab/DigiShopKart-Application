package com.example.digishopkart.mapper;

import com.example.digishopkart.entity.Product1;
import com.example.digishopkart.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface Product1Mapper {
    public Product1Mapper INSTANCE = Mappers.getMapper(Product1Mapper.class);
    Product entityProduct1ToModelProduct(Product1 product1);
    Product1 modelProductToEntityProduct1(Product product);
}
