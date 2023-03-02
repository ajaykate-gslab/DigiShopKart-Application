package com.example.digishopkart.mapper;

import com.example.digishopkart.entity.Order;
import com.example.digishopkart.entity.Product;
import com.example.digishopkart.entity.Variant;
import com.example.digishopkart.model.Customer;
import com.example.digishopkart.model.CustomerAddress;
import com.example.digishopkart.model.Discount;
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
        order1.setUpdatedAt( order.getUpdatedAt() );
        order1.setOrderStatus( order.getOrderStatus() );
        order1.setCustomer( customerToCustomer( order.getCustomer() ) );
        order1.setProducts( productListToProductList( order.getProducts() ) );
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
        order1.setActivatedAt( order.getActivatedAt() );
        order1.setUpdatedAt( order.getUpdatedAt() );
        order1.setOrderStatus( order.getOrderStatus() );
        order1.setCustomer( customerToCustomer1( order.getCustomer() ) );
        order1.setProducts( productListToProductList1( order.getProducts() ) );
        order1.setDiscount( discountToDiscount1( order.getDiscount() ) );

        return order1;
    }

    protected com.example.digishopkart.entity.CustomerAddress customerAddressToCustomerAddress(CustomerAddress customerAddress) {
        if ( customerAddress == null ) {
            return null;
        }

        com.example.digishopkart.entity.CustomerAddress.CustomerAddressBuilder customerAddress1 = com.example.digishopkart.entity.CustomerAddress.builder();

        if ( customerAddress.getId() != null ) {
            customerAddress1.id( customerAddress.getId() );
        }
        customerAddress1.addressType( customerAddress.getAddressType() );
        customerAddress1.customerFullName( customerAddress.getCustomerFullName() );
        customerAddress1.country( customerAddress.getCountry() );
        customerAddress1.state( customerAddress.getState() );
        customerAddress1.town( customerAddress.getTown() );
        customerAddress1.area( customerAddress.getArea() );
        customerAddress1.houseOrBuilding( customerAddress.getHouseOrBuilding() );
        customerAddress1.landmark( customerAddress.getLandmark() );
        customerAddress1.pinCode( customerAddress.getPinCode() );
        customerAddress1.mobile( customerAddress.getMobile() );

        return customerAddress1.build();
    }

    protected List<com.example.digishopkart.entity.CustomerAddress> customerAddressListToCustomerAddressList(List<CustomerAddress> list) {
        if ( list == null ) {
            return null;
        }

        List<com.example.digishopkart.entity.CustomerAddress> list1 = new ArrayList<com.example.digishopkart.entity.CustomerAddress>( list.size() );
        for ( CustomerAddress customerAddress : list ) {
            list1.add( customerAddressToCustomerAddress( customerAddress ) );
        }

        return list1;
    }

    protected com.example.digishopkart.entity.Customer customerToCustomer(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        com.example.digishopkart.entity.Customer.CustomerBuilder customer1 = com.example.digishopkart.entity.Customer.builder();

        if ( customer.getId() != null ) {
            customer1.id( customer.getId() );
        }
        customer1.firstName( customer.getFirstName() );
        customer1.lastName( customer.getLastName() );
        customer1.email( customer.getEmail() );
        customer1.mobile( customer.getMobile() );
        customer1.customerStatus( customer.getCustomerStatus() );
        customer1.customerAddress( customerAddressListToCustomerAddressList( customer.getCustomerAddress() ) );

        return customer1.build();
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

    protected Product productToProduct(com.example.digishopkart.model.Product product) {
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

    protected List<Product> productListToProductList(List<com.example.digishopkart.model.Product> list) {
        if ( list == null ) {
            return null;
        }

        List<Product> list1 = new ArrayList<Product>( list.size() );
        for ( com.example.digishopkart.model.Product product : list ) {
            list1.add( productToProduct( product ) );
        }

        return list1;
    }

    protected com.example.digishopkart.entity.Discount discountToDiscount(Discount discount) {
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

    protected CustomerAddress customerAddressToCustomerAddress1(com.example.digishopkart.entity.CustomerAddress customerAddress) {
        if ( customerAddress == null ) {
            return null;
        }

        CustomerAddress customerAddress1 = new CustomerAddress();

        customerAddress1.setId( customerAddress.getId() );
        customerAddress1.setAddressType( customerAddress.getAddressType() );
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

    protected List<CustomerAddress> customerAddressListToCustomerAddressList1(List<com.example.digishopkart.entity.CustomerAddress> list) {
        if ( list == null ) {
            return null;
        }

        List<CustomerAddress> list1 = new ArrayList<CustomerAddress>( list.size() );
        for ( com.example.digishopkart.entity.CustomerAddress customerAddress : list ) {
            list1.add( customerAddressToCustomerAddress1( customerAddress ) );
        }

        return list1;
    }

    protected Customer customerToCustomer1(com.example.digishopkart.entity.Customer customer) {
        if ( customer == null ) {
            return null;
        }

        Customer customer1 = new Customer();

        customer1.setId( customer.getId() );
        customer1.setFirstName( customer.getFirstName() );
        customer1.setLastName( customer.getLastName() );
        customer1.setEmail( customer.getEmail() );
        customer1.setMobile( customer.getMobile() );
        customer1.setCustomerStatus( customer.getCustomerStatus() );
        customer1.setCustomerAddress( customerAddressListToCustomerAddressList1( customer.getCustomerAddress() ) );

        return customer1;
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

    protected com.example.digishopkart.model.Product productToProduct1(Product product) {
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

    protected List<com.example.digishopkart.model.Product> productListToProductList1(List<Product> list) {
        if ( list == null ) {
            return null;
        }

        List<com.example.digishopkart.model.Product> list1 = new ArrayList<com.example.digishopkart.model.Product>( list.size() );
        for ( Product product : list ) {
            list1.add( productToProduct1( product ) );
        }

        return list1;
    }

    protected Discount discountToDiscount1(com.example.digishopkart.entity.Discount discount) {
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
