package com.example.digishopkart.mapper;

import com.example.digishopkart.entity.Product1;
import com.example.digishopkart.model.Product;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-02T16:46:46+0530",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
@Component
public class Product1MapperImpl implements Product1Mapper {

    @Override
    public Product entityProduct1ToModelProduct(Product1 product1) {
        if ( product1 == null ) {
            return null;
        }

        Product product = new Product();

        product.setProductId( product1.getProductId() );
        product.setProductName( product1.getProductName() );
        product.setProductCode( product1.getProductCode() );
        product.setProductPrice( product1.getProductPrice() );
        product.setProductCategory( product1.getProductCategory() );
        product.setProductStatus( product1.getProductStatus() );

        return product;
    }

    @Override
    public Product1 modelProductToEntityProduct1(Product product) {
        if ( product == null ) {
            return null;
        }

        Product1 product1 = new Product1();

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

        return product1;
    }
}
