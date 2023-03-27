package com.example.digishopkart.mapper;

import com.example.digishopkart.entity.CustomerAddressEntity;
import com.example.digishopkart.model.CustomerAddress;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-21T11:26:43+0530",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
@Component
public class CustomerAddressMapperImpl implements CustomerAddressMapper {

    @Override
    public CustomerAddressEntity customerAddressDtoToCustomerAddressEntity(CustomerAddress customerAddress) {
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

    @Override
    public CustomerAddress customerAddressEntityToCustomerAddressDto(CustomerAddressEntity customerAddressEntity) {
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
}
