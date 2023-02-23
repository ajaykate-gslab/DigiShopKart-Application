package com.example.digishopkart.mapper;

import com.example.digishopkart.entity.CustomerAddress;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerAddressMapper {


    CustomerAddressMapper INSTANCE = Mappers.getMapper(CustomerAddressMapper.class);
    //@Mapping(target = "com.example.digishopkart.entity.Customer", source = "customerAddressId")
    //@Mapping(target = "com.example.digishopkart.model.CustomerAddress", source = "customerAddressId", qualifiedByName = "mapProducts")
    CustomerAddress customerAddressModelToCustomerAddressEntity(com.example.digishopkart.model.CustomerAddress customerAddress);
    com.example.digishopkart.model.CustomerAddress customerAddressEntityToCustomerAddressModel(CustomerAddress customerAddress);
}
