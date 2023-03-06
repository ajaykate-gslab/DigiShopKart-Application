package com.example.digishopkart.mapper;

import com.example.digishopkart.model.Discount;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-03T19:20:04+0530",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
@Component
public class DiscountMapperImpl implements DiscountMapper {

    @Override
    public com.example.digishopkart.entity.Discount DiscountModelToDiscountEntity(Discount discount) {
        if ( discount == null ) {
            return null;
        }

        com.example.digishopkart.entity.Discount.DiscountBuilder discount1 = com.example.digishopkart.entity.Discount.builder();

        if ( discount.getId() != null ) {
            discount1.id( discount.getId() );
        }
        discount1.couponName( discount.getCouponName() );
        discount1.discountType( discount.getDiscountType() );
        discount1.couponValue( discount.getCouponValue() );

        return discount1.build();
    }

    @Override
    public Discount DiscountEntityToDiscountModel(com.example.digishopkart.entity.Discount discount) {
        if ( discount == null ) {
            return null;
        }

        Discount discount1 = new Discount();

        discount1.setId( discount.getId() );
        discount1.setCouponName( discount.getCouponName() );
        discount1.setDiscountType( discount.getDiscountType() );
        discount1.setCouponValue( discount.getCouponValue() );

        return discount1;
    }
}
