package com.example.digishopkart.mapper;

import com.example.digishopkart.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    //@Mapping(target = "createdAt", ignore = true)
    Product ProductModelToProductEntity(com.example.digishopkart.model.Product product);
    //@Mapping(target = "createdAt", ignore = true)
    com.example.digishopkart.model.Product ProductEntityToProductmodel(Product product);
}
