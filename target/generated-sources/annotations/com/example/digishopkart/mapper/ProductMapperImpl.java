package com.example.digishopkart.mapper;

import com.example.digishopkart.entity.Product;
import com.example.digishopkart.entity.Variant;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-02T16:46:45+0530",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product ProductModelToProductEntity(com.example.digishopkart.model.Product product) {
        if ( product == null ) {
            return null;
        }

        Product product1 = new Product();

        if ( product.getProductId() != null ) {
            product1.setProductId( product.getProductId() );
        }
        product1.setProductName( product.getProductName() );
        product1.setProductCode( product.getProductCode() );
        if ( product.getProductPrice() != null ) {
            product1.setProductPrice( product.getProductPrice() );
        }
        product1.setProductStatus( product.getProductStatus() );
        product1.setProductCategory( product.getProductCategory() );
        product1.setVariant( variantToVariant( product.getVariant() ) );

        return product1;
    }

    @Override
    public com.example.digishopkart.model.Product ProductEntityToProductmodel(Product product) {
        if ( product == null ) {
            return null;
        }

        com.example.digishopkart.model.Product product1 = new com.example.digishopkart.model.Product();

        product1.setProductId( product.getProductId() );
        product1.setProductName( product.getProductName() );
        product1.setProductCode( product.getProductCode() );
        product1.setProductPrice( product.getProductPrice() );
        product1.setProductCategory( product.getProductCategory() );
        product1.setProductStatus( product.getProductStatus() );
        product1.setVariant( variantToVariant1( product.getVariant() ) );

        return product1;
    }

    protected Variant variantToVariant(com.example.digishopkart.model.Variant variant) {
        if ( variant == null ) {
            return null;
        }

        Variant variant1 = new Variant();

        if ( variant.getVariantId() != null ) {
            variant1.setVariantId( variant.getVariantId() );
        }
        variant1.setColour( variant.getColour() );
        variant1.setSize( variant.getSize() );

        return variant1;
    }

    protected com.example.digishopkart.model.Variant variantToVariant1(Variant variant) {
        if ( variant == null ) {
            return null;
        }

        com.example.digishopkart.model.Variant variant1 = new com.example.digishopkart.model.Variant();

        variant1.setVariantId( variant.getVariantId() );
        variant1.setColour( variant.getColour() );
        variant1.setSize( variant.getSize() );

        return variant1;
    }
}
