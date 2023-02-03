package com.example.digishopkart.mapper;

import com.example.digishopkart.entity.Variant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface VariantMapper {
    VariantMapper INSTANCE = Mappers.getMapper(VariantMapper.class);
    Variant VariantModelToVariantEntity(com.example.digishopkart.model.Variant variant);
    com.example.digishopkart.model.Variant VariantEntityToVariantModel(Variant variant);
}
/*ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    @Mapping(target = "createdAt", ignore = true)
    Product ProductModelToProductEntity(com.example.digishopkart.model.Product product);
    @Mapping(target = "createdAt", ignore = true)
    com.example.digishopkart.model.Product ProductEntityToProductmodel(Product product);
}*/
