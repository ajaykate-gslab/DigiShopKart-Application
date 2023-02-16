package com.example.digishopkart.mapper;

import com.example.digishopkart.model.CustomerAddress;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-16T13:05:01+0530",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
@Component
public class CustomerAddressMapperImpl implements CustomerAddressMapper {

    @Override
    public com.example.digishopkart.entity.CustomerAddress customerAddressModelToCustomerAddress(CustomerAddress customerAddress) {
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

    @Override
    public CustomerAddress customerAddressEntityToCustomerAddressModel(com.example.digishopkart.entity.CustomerAddress customerAddress) {
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
