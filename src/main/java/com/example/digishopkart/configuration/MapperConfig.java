package com.example.digishopkart.configuration;

import com.example.digishopkart.entity.Customer;
import com.example.digishopkart.entity.CustomerAddress;
import com.example.digishopkart.mapper.CustomerAddressMapper;
import com.example.digishopkart.mapper.CustomerMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    /*@Bean
    public CustomerMapper customerMapper(){
        return new CustomerMapper() {
            @Override
            public Customer CustomerModelToCustomerEntity(com.example.digishopkart.model.Customer customer) {
                return null;
            }

            @Override
            public com.example.digishopkart.model.Customer CustomerEntityToCustomerModel(Customer customer) {
                return null;
            }
        };
    }

    @Bean
    public CustomerAddressMapper customerAddressMapper(){
        return new CustomerAddressMapper() {
            @Override
            public CustomerAddress customerAddressModelToCustomerAddress(com.example.digishopkart.model.CustomerAddress customerAddress) {
                return INSTANCE.customerAddressModelToCustomerAddress(customerAddress);
            }

            @Override
            public com.example.digishopkart.model.CustomerAddress customerAddressEntityToCustomerAddressModel(CustomerAddress customerAddress) {
               return INSTANCE.customerAddressEntityToCustomerAddressModel(customerAddress);
            }
        };
    }*/
}
