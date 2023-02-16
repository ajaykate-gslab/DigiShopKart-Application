package com.example.digishopkart.mapper;

import com.example.digishopkart.entity.Order;
import com.example.digishopkart.entity.Product;
import com.example.digishopkart.entity.Variant;
import com.example.digishopkart.model.Customer;
import com.example.digishopkart.model.CustomerAddress;
import com.example.digishopkart.model.Discount;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-16T13:05:01+0530",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public Order OrderModelToOrderEntity(com.example.digishopkart.model.Order order) {
        if ( order == null ) {
            return null;
        }

        Order order1 = new Order();

        if ( order.getOrderId() != null ) {
            order1.setOrderId( order.getOrderId() );
        }
        order1.setActivatedAt( order.getActivatedAt() );
        order1.setProductName( order.getProductName() );
        order1.setDiscountPrice( order.getDiscountPrice() );
        order1.setCouponValue( order.getCouponValue() );
        order1.setOrderStatus( order.getOrderStatus() );
        order1.setCustomer( customerToCustomer( order.getCustomer() ) );
        order1.setProduct( productToProduct( order.getProduct() ) );
        order1.setDiscount( discountToDiscount( order.getDiscount() ) );

        return order1;
    }

    @Override
    public com.example.digishopkart.model.Order OrderEntityToOrderModel(Order order) {
        if ( order == null ) {
            return null;
        }

        com.example.digishopkart.model.Order order1 = new com.example.digishopkart.model.Order();

        order1.setOrderId( order.getOrderId() );
        order1.setProductName( order.getProductName() );
        order1.setActivatedAt( order.getActivatedAt() );
        order1.setDiscountPrice( order.getDiscountPrice() );
        order1.setCouponValue( order.getCouponValue() );
        order1.setOrderStatus( order.getOrderStatus() );
        order1.setCustomer( customerToCustomer1( order.getCustomer() ) );
        order1.setProduct( productToProduct1( order.getProduct() ) );
        order1.setDiscount( discountToDiscount1( order.getDiscount() ) );

        return order1;
    }

    protected com.example.digishopkart.entity.CustomerAddress customerAddressToCustomerAddress(CustomerAddress customerAddress) {
        if ( customerAddress == null ) {
            return null;
        }

        com.example.digishopkart.entity.CustomerAddress customerAddress1 = new com.example.digishopkart.entity.CustomerAddress();

        if ( customerAddress.getCustomerAddressId() != null ) {
            customerAddress1.setCustomerAddressId( customerAddress.getCustomerAddressId() );
        }
        customerAddress1.setCustomerFullName( customerAddress.getCustomerFullName() );
        customerAddress1.setCountry( customerAddress.getCountry() );
        customerAddress1.setState( customerAddress.getState() );
        customerAddress1.setTown( customerAddress.getTown() );
        customerAddress1.setArea( customerAddress.getArea() );
        customerAddress1.setHouseOrBuilding( customerAddress.getHouseOrBuilding() );
        customerAddress1.setLandmark( customerAddress.getLandmark() );
        customerAddress1.setPinCode( customerAddress.getPinCode() );
        customerAddress1.setMobile( customerAddress.getMobile() );

        return customerAddress1;
    }

    protected com.example.digishopkart.entity.Customer customerToCustomer(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        com.example.digishopkart.entity.Customer customer1 = new com.example.digishopkart.entity.Customer();

        if ( customer.getCustomerId() != null ) {
            customer1.setCustomerId( customer.getCustomerId() );
        }
        customer1.setFirstName( customer.getFirstName() );
        customer1.setLastName( customer.getLastName() );
        customer1.setEmail( customer.getEmail() );
        customer1.setMobile( customer.getMobile() );
        customer1.setCustomerStatus( customer.getCustomerStatus() );
        customer1.setCustomerAddress( customerAddressToCustomerAddress( customer.getCustomerAddress() ) );

        return customer1;
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

    protected Product productToProduct(com.example.digishopkart.model.Product product) {
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

    protected com.example.digishopkart.entity.Discount discountToDiscount(Discount discount) {
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

    protected CustomerAddress customerAddressToCustomerAddress1(com.example.digishopkart.entity.CustomerAddress customerAddress) {
        if ( customerAddress == null ) {
            return null;
        }

        CustomerAddress customerAddress1 = new CustomerAddress();

        customerAddress1.setCustomerAddressId( customerAddress.getCustomerAddressId() );
        customerAddress1.setCustomerFullName( customerAddress.getCustomerFullName() );
        customerAddress1.setCountry( customerAddress.getCountry() );
        customerAddress1.setState( customerAddress.getState() );
        customerAddress1.setTown( customerAddress.getTown() );
        customerAddress1.setArea( customerAddress.getArea() );
        customerAddress1.setHouseOrBuilding( customerAddress.getHouseOrBuilding() );
        customerAddress1.setLandmark( customerAddress.getLandmark() );
        customerAddress1.setPinCode( customerAddress.getPinCode() );
        customerAddress1.setMobile( customerAddress.getMobile() );

        return customerAddress1;
    }

    protected Customer customerToCustomer1(com.example.digishopkart.entity.Customer customer) {
        if ( customer == null ) {
            return null;
        }

        Customer customer1 = new Customer();

        customer1.setCustomerId( customer.getCustomerId() );
        customer1.setFirstName( customer.getFirstName() );
        customer1.setLastName( customer.getLastName() );
        customer1.setEmail( customer.getEmail() );
        customer1.setMobile( customer.getMobile() );
        customer1.setCustomerStatus( customer.getCustomerStatus() );
        customer1.setCustomerAddress( customerAddressToCustomerAddress1( customer.getCustomerAddress() ) );

        return customer1;
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

    protected com.example.digishopkart.model.Product productToProduct1(Product product) {
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

    protected Discount discountToDiscount1(com.example.digishopkart.entity.Discount discount) {
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
