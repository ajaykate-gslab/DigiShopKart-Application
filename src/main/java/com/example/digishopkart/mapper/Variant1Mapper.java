package com.example.digishopkart.mapper;

import com.example.digishopkart.entity.Variant1;
import com.example.digishopkart.model.Variant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface Variant1Mapper {
    public Variant1Mapper INSTANCE = Mappers.getMapper(Variant1Mapper.class);

    Variant1 variantModelToVariant1Entity(Variant variant);

    Variant Variant1EntityToVariantModel(Variant1 variant1);
}

