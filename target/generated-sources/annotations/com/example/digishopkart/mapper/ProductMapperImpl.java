package com.example.digishopkart.mapper;

import com.example.digishopkart.entity.Product;
import com.example.digishopkart.entity.Variant;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-02T16:50:36+0530",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product ProductModelToProductEntity(com.example.digishopkart.model.Product product) {
        if ( product == null ) {
            return null;
        }

        Product.ProductBuilder product1 = Product.builder();

        if ( product.getId() != null ) {
            product1.id( product.getId() );
        }
        product1.productName( product.getProductName() );
        product1.brand( product.getBrand() );
        if ( product.getProductPrice() != null ) {
            product1.productPrice( product.getProductPrice() );
        }
        product1.productStatus( product.getProductStatus() );
        product1.productCategory( product.getProductCategory() );
        product1.variant( variantListToVariantList( product.getVariant() ) );

        return product1.build();
    }

    @Override
    public com.example.digishopkart.model.Product ProductEntityToProductmodel(Product product) {
        if ( product == null ) {
            return null;
        }

        com.example.digishopkart.model.Product product1 = new com.example.digishopkart.model.Product();

        product1.setId( product.getId() );
        product1.setProductName( product.getProductName() );
        product1.setBrand( product.getBrand() );
        product1.setProductPrice( product.getProductPrice() );
        product1.setProductCategory( product.getProductCategory() );
        product1.setProductStatus( product.getProductStatus() );
        product1.setVariant( variantListToVariantList1( product.getVariant() ) );

        return product1;
    }

    protected Variant variantToVariant(com.example.digishopkart.model.Variant variant) {
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

    protected List<Variant> variantListToVariantList(List<com.example.digishopkart.model.Variant> list) {
        if ( list == null ) {
            return null;
        }

        List<Variant> list1 = new ArrayList<Variant>( list.size() );
        for ( com.example.digishopkart.model.Variant variant : list ) {
            list1.add( variantToVariant( variant ) );
        }

        return list1;
    }

    protected com.example.digishopkart.model.Variant variantToVariant1(Variant variant) {
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

    protected List<com.example.digishopkart.model.Variant> variantListToVariantList1(List<Variant> list) {
        if ( list == null ) {
            return null;
        }

        List<com.example.digishopkart.model.Variant> list1 = new ArrayList<com.example.digishopkart.model.Variant>( list.size() );
        for ( Variant variant : list ) {
            list1.add( variantToVariant1( variant ) );
        }

        return list1;
    }
}
