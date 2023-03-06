package com.example.digishopkart.mapper;

import com.example.digishopkart.entity.Variant;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-03T19:20:04+0530",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
@Component
public class VariantMapperImpl implements VariantMapper {

    @Override
    public Variant VariantModelToVariantEntity(com.example.digishopkart.model.Variant variant) {
        if ( variant == null ) {
            return null;
        }

        Variant variant1 = new Variant();

        if ( variant.getId() != null ) {
            variant1.setId( variant.getId() );
        }
        variant1.setName( variant.getName() );
        variant1.setValue( variant.getValue() );
        variant1.setStatus( variant.getStatus() );

        return variant1;
    }

    @Override
    public com.example.digishopkart.model.Variant VariantEntityToVariantModel(Variant variant) {
        if ( variant == null ) {
            return null;
        }

        com.example.digishopkart.model.Variant variant1 = new com.example.digishopkart.model.Variant();

        variant1.setId( variant.getId() );
        variant1.setName( variant.getName() );
        variant1.setValue( variant.getValue() );
        variant1.setStatus( variant.getStatus() );

        return variant1;
    }
}
