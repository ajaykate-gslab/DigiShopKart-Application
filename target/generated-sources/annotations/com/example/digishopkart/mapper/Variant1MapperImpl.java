package com.example.digishopkart.mapper;

import com.example.digishopkart.entity.Variant1;
import com.example.digishopkart.model.Variant;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-02T16:46:46+0530",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
@Component
public class Variant1MapperImpl implements Variant1Mapper {

    @Override
    public Variant1 variantModelToVariant1Entity(Variant variant) {
        if ( variant == null ) {
            return null;
        }

        Variant1 variant1 = new Variant1();

        if ( variant.getVariantId() != null ) {
            variant1.setVariantId( variant.getVariantId() );
        }
        variant1.setColour( variant.getColour() );
        variant1.setSize( variant.getSize() );

        return variant1;
    }

    @Override
    public Variant Variant1EntityToVariantModel(Variant1 variant1) {
        if ( variant1 == null ) {
            return null;
        }

        Variant variant = new Variant();

        variant.setVariantId( variant1.getVariantId() );
        variant.setColour( variant1.getColour() );
        variant.setSize( variant1.getSize() );

        return variant;
    }
}
