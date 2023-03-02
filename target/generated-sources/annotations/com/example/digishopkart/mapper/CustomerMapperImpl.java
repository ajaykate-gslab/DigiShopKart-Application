package com.example.digishopkart.mapper;

import com.example.digishopkart.model.Customer;
import com.example.digishopkart.model.CustomerAddress;
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
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public com.example.digishopkart.entity.Customer CustomerModelToCustomerEntity(Customer customer) {
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

    @Override
    public Customer CustomerEntityToCustomerModel(com.example.digishopkart.entity.Customer customer) {
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
}
