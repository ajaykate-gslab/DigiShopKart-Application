package com.example.digishopkart.mapper;

import com.example.digishopkart.model.CustomerAddress;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-03T19:20:04+0530",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
@Component
public class CustomerAddressMapperImpl implements CustomerAddressMapper {

    @Override
    public com.example.digishopkart.entity.CustomerAddress customerAddressModelToCustomerAddressEntity(CustomerAddress customerAddress) {
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

    @Override
    public CustomerAddress customerAddressEntityToCustomerAddressModel(com.example.digishopkart.entity.CustomerAddress customerAddress) {
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
}
