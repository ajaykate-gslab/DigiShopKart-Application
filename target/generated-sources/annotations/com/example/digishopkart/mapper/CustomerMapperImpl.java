package com.example.digishopkart.mapper;

import com.example.digishopkart.model.Customer;
import com.example.digishopkart.model.CustomerAddress;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-03T14:31:15+0530",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public com.example.digishopkart.entity.Customer CustomerModelToCustomerEntity(Customer customer) {
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

    @Override
    public Customer CustomerEntityToCustomerModel(com.example.digishopkart.entity.Customer customer) {
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
}
