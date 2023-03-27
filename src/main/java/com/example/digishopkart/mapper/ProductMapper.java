package com.example.digishopkart.mapper;

import com.example.digishopkart.entity.ProductEntity;
import com.example.digishopkart.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    //@Mapping(target = "createdAt", ignore = true)
    ProductEntity ProductModelToProductEntity(Product product);
    //@Mapping(target = "createdAt", ignore = true)
    Product ProductEntityToProductmodel(ProductEntity productEntity);
}
