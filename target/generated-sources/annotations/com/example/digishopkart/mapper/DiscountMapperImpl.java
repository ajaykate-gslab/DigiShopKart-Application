package com.example.digishopkart.mapper;

import com.example.digishopkart.entity.DiscountEntity;
import com.example.digishopkart.model.Discount;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-21T11:26:43+0530",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
@Component
public class DiscountMapperImpl implements DiscountMapper {

    @Override
    public DiscountEntity DiscountModelToDiscountEntity(Discount discount) {
        if ( discount == null ) {
            return null;
        }

        DiscountEntity.DiscountEntityBuilder discountEntity = DiscountEntity.builder();

        if ( discount.getId() != null ) {
            discountEntity.id( discount.getId() );
        }
        discountEntity.couponName( discount.getCouponName() );
        discountEntity.discountType( discount.getDiscountType() );
        discountEntity.couponValue( discount.getCouponValue() );

        return discountEntity.build();
    }

    @Override
    public Discount DiscountEntityToDiscountModel(DiscountEntity discountEntity) {
        if ( discountEntity == null ) {
            return null;
        }

        Discount discount = new Discount();

        discount.setId( discountEntity.getId() );
        discount.setCouponName( discountEntity.getCouponName() );
        discount.setDiscountType( discountEntity.getDiscountType() );
        discount.setCouponValue( discountEntity.getCouponValue() );

        return discount;
    }
}
