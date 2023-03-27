package com.example.digishopkart.mapper;

import com.example.digishopkart.entity.CustomerAddressEntity;
import com.example.digishopkart.entity.CustomerEntity;
import com.example.digishopkart.model.Customer;
import com.example.digishopkart.model.CustomerAddress;
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
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerEntity CustomerDtoToCustomerEntity(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerEntity.CustomerEntityBuilder customerEntity = CustomerEntity.builder();

        if ( customer.getId() != null ) {
            customerEntity.id( customer.getId() );
        }
        customerEntity.firstName( customer.getFirstName() );
        customerEntity.lastName( customer.getLastName() );
        customerEntity.email( customer.getEmail() );
        customerEntity.mobile( customer.getMobile() );
        customerEntity.customerStatus( customer.getCustomerStatus() );
        customerEntity.customerAddress( customerAddressListToCustomerAddressEntityList( customer.getCustomerAddress() ) );

        return customerEntity.build();
    }

    @Override
    public Customer CustomerEntityToCustomerDto(CustomerEntity customerEntity) {
        if ( customerEntity == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( customerEntity.getId() );
        customer.setFirstName( customerEntity.getFirstName() );
        customer.setLastName( customerEntity.getLastName() );
        customer.setEmail( customerEntity.getEmail() );
        customer.setMobile( customerEntity.getMobile() );
        customer.setCustomerStatus( customerEntity.getCustomerStatus() );
        customer.setCustomerAddress( customerAddressEntityListToCustomerAddressList( customerEntity.getCustomerAddress() ) );

        return customer;
    }

    protected CustomerAddressEntity customerAddressToCustomerAddressEntity(CustomerAddress customerAddress) {
        if ( customerAddress == null ) {
            return null;
        }

        CustomerAddressEntity.CustomerAddressEntityBuilder customerAddressEntity = CustomerAddressEntity.builder();

        if ( customerAddress.getId() != null ) {
            customerAddressEntity.id( customerAddress.getId() );
        }
        customerAddressEntity.addressType( customerAddress.getAddressType() );
        customerAddressEntity.customerFullName( customerAddress.getCustomerFullName() );
        customerAddressEntity.country( customerAddress.getCountry() );
        customerAddressEntity.state( customerAddress.getState() );
        customerAddressEntity.town( customerAddress.getTown() );
        customerAddressEntity.area( customerAddress.getArea() );
        customerAddressEntity.houseOrBuilding( customerAddress.getHouseOrBuilding() );
        customerAddressEntity.landmark( customerAddress.getLandmark() );
        customerAddressEntity.pinCode( customerAddress.getPinCode() );
        customerAddressEntity.mobile( customerAddress.getMobile() );

        return customerAddressEntity.build();
    }

    protected List<CustomerAddressEntity> customerAddressListToCustomerAddressEntityList(List<CustomerAddress> list) {
        if ( list == null ) {
            return null;
        }

        List<CustomerAddressEntity> list1 = new ArrayList<CustomerAddressEntity>( list.size() );
        for ( CustomerAddress customerAddress : list ) {
            list1.add( customerAddressToCustomerAddressEntity( customerAddress ) );
        }

        return list1;
    }

    protected CustomerAddress customerAddressEntityToCustomerAddress(CustomerAddressEntity customerAddressEntity) {
        if ( customerAddressEntity == null ) {
            return null;
        }

        CustomerAddress customerAddress = new CustomerAddress();

        customerAddress.setId( customerAddressEntity.getId() );
        customerAddress.setAddressType( customerAddressEntity.getAddressType() );
        customerAddress.setCustomerFullName( customerAddressEntity.getCustomerFullName() );
        customerAddress.setCountry( customerAddressEntity.getCountry() );
        customerAddress.setState( customerAddressEntity.getState() );
        customerAddress.setTown( customerAddressEntity.getTown() );
        customerAddress.setArea( customerAddressEntity.getArea() );
        customerAddress.setHouseOrBuilding( customerAddressEntity.getHouseOrBuilding() );
        customerAddress.setLandmark( customerAddressEntity.getLandmark() );
        customerAddress.setPinCode( customerAddressEntity.getPinCode() );
        customerAddress.setMobile( customerAddressEntity.getMobile() );

        return customerAddress;
    }

    protected List<CustomerAddress> customerAddressEntityListToCustomerAddressList(List<CustomerAddressEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<CustomerAddress> list1 = new ArrayList<CustomerAddress>( list.size() );
        for ( CustomerAddressEntity customerAddressEntity : list ) {
            list1.add( customerAddressEntityToCustomerAddress( customerAddressEntity ) );
        }

        return list1;
    }
}
