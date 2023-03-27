package com.example.digishopkart.mapper;

import com.example.digishopkart.entity.VariantEntity;
import com.example.digishopkart.model.Variant;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-21T11:26:43+0530",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
@Component
public class VariantMapperImpl implements VariantMapper {

    @Override
    public VariantEntity VariantModelToVariantEntity(Variant variant) {
        if ( variant == null ) {
            return null;
        }

        VariantEntity variantEntity = new VariantEntity();

        if ( variant.getId() != null ) {
            variantEntity.setId( variant.getId() );
        }
        variantEntity.setName( variant.getName() );
        variantEntity.setValue( variant.getValue() );
        variantEntity.setStatus( variant.getStatus() );

        return variantEntity;
    }

    @Override
    public Variant VariantEntityToVariantModel(VariantEntity variantEntity) {
        if ( variantEntity == null ) {
            return null;
        }

        Variant variant = new Variant();

        variant.setId( variantEntity.getId() );
        variant.setName( variantEntity.getName() );
        variant.setValue( variantEntity.getValue() );
        variant.setStatus( variantEntity.getStatus() );

        return variant;
    }
}
