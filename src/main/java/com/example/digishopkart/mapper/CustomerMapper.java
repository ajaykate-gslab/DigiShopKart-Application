package com.example.digishopkart.mapper;

import com.example.digishopkart.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerMapper INSTANCE= Mappers.getMapper(CustomerMapper.class);
    //@Mappings({@Mapping(target = "customerAddressId", source = "id")})


    Customer CustomerModelToCustomerEntity(com.example.digishopkart.model.Customer customer);
    com.example.digishopkart.model.Customer CustomerEntityToCustomerModel(Customer customer);

}