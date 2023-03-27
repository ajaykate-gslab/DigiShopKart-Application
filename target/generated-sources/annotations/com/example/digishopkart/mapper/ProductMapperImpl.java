package com.example.digishopkart.mapper;

import com.example.digishopkart.entity.ProductEntity;
import com.example.digishopkart.entity.VariantEntity;
import com.example.digishopkart.model.Product;
import com.example.digishopkart.model.Variant;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-21T11:26:43+0530",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductEntity ProductModelToProductEntity(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductEntity.ProductEntityBuilder productEntity = ProductEntity.builder();

        if ( product.getId() != null ) {
            productEntity.id( product.getId() );
        }
        productEntity.productName( product.getProductName() );
        productEntity.brand( product.getBrand() );
        if ( product.getProductPrice() != null ) {
            productEntity.productPrice( product.getProductPrice() );
        }
        productEntity.productStatus( product.getProductStatus() );
        productEntity.productCategory( product.getProductCategory() );
        productEntity.variant( variantListToVariantEntityList( product.getVariant() ) );

        return productEntity.build();
    }

    @Override
    public Product ProductEntityToProductmodel(ProductEntity productEntity) {
        if ( productEntity == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( productEntity.getId() );
        product.setProductName( productEntity.getProductName() );
        product.setBrand( productEntity.getBrand() );
        product.setProductPrice( productEntity.getProductPrice() );
        product.setProductCategory( productEntity.getProductCategory() );
        product.setProductStatus( productEntity.getProductStatus() );
        product.setVariant( variantEntityListToVariantList( productEntity.getVariant() ) );

        return product;
    }

    protected VariantEntity variantToVariantEntity(Variant variant) {
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

    protected List<VariantEntity> variantListToVariantEntityList(List<Variant> list) {
        if ( list == null ) {
            return null;
        }

        List<VariantEntity> list1 = new ArrayList<VariantEntity>( list.size() );
        for ( Variant variant : list ) {
            list1.add( variantToVariantEntity( variant ) );
        }

        return list1;
    }

    protected Variant variantEntityToVariant(VariantEntity variantEntity) {
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

    protected List<Variant> variantEntityListToVariantList(List<VariantEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<Variant> list1 = new ArrayList<Variant>( list.size() );
        for ( VariantEntity variantEntity : list ) {
            list1.add( variantEntityToVariant( variantEntity ) );
        }

        return list1;
    }
}
