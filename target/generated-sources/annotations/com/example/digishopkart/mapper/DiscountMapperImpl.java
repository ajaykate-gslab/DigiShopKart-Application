package com.example.digishopkart.mapper;

import com.example.digishopkart.model.Discount;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-23T09:52:31+0530",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
@Component
public class DiscountMapperImpl implements DiscountMapper {

    @Override
    public com.example.digishopkart.entity.Discount DiscountModelToDiscountEntity(Discount discount) {
        if ( discount == null ) {
            return null;
        }

        com.example.digishopkart.entity.Discount discount1 = new com.example.digishopkart.entity.Discount();

        if ( discount.getDiscountId() != null ) {
            discount1.setDiscountId( discount.getDiscountId() );
        }
        discount1.setCouponName( discount.getCouponName() );
        discount1.setDiscountType( discount.getDiscountType() );
        discount1.setCouponValue( discount.getCouponValue() );

        return discount1;
    }

    @Override
    public Discount DiscountEntityToDiscountModel(com.example.digishopkart.entity.Discount discount) {
        if ( discount == null ) {
            return null;
        }

        Discount discount1 = new Discount();

        discount1.setDiscountId( discount.getDiscountId() );
        discount1.setCouponName( discount.getCouponName() );
        discount1.setDiscountType( discount.getDiscountType() );
        discount1.setCouponValue( discount.getCouponValue() );

        return discount1;
    }
}
