package com.example.digishopkart.configuration;

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

    /*@Bean
    public ProductMapper productMapper(){
        return new ProductMapper() {
            @Override
            public Product ProductModelToProductEntity(com.example.digishopkart.model.Product product) {
                return  product;
            }

            @Override
            public com.example.digishopkart.model.Product ProductEntityToProductmodel(Product product) {
                return null;
            }
        };
    }

    public VariantMapper variantMapper(){
        return new VariantMapper() {
            @Override
            public Variant VariantModelToVariantEntity(com.example.digishopkart.model.Variant variant) {
                return null;
            }

            @Override
            public com.example.digishopkart.model.Variant VariantEntityToVariantModel(Variant variant) {
                return null;
            }
        };
    }*/
}
