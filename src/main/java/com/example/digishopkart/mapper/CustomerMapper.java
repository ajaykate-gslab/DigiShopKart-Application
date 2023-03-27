package com.example.digishopkart.mapper;

import com.example.digishopkart.entity.CustomerEntity;
import com.example.digishopkart.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerMapper INSTANCE= Mappers.getMapper(CustomerMapper.class);
    //@Mappings({@Mapping(target = "customerAddressId", source = "id")})

    CustomerEntity CustomerDtoToCustomerEntity(Customer customer);
    Customer CustomerEntityToCustomerDto(CustomerEntity customerEntity);

}