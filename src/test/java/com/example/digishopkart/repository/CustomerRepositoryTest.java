package com.example.digishopkart.repository;

import com.example.digishopkart.entity.Customer;
import com.example.digishopkart.entity.CustomerAddress;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerAddressRepository customerAddressRepository;

    @Test
    public void saveCustomerTest(){
       CustomerAddress customerAddress = CustomerAddress.builder()
                .addressType(com.example.digishopkart.model.CustomerAddress.AddressTypeEnum.SHIPPING)
                .customerFullName("Abc ddd")
                .country("IND")
                .state("Maharashtra")
                .town("Mumbai")
                .area("Parel")
                .houseOrBuilding("Delta's Tower")
                .landmark("Parel station")
                .pinCode(123456)
                .mobile("+9876543210").build();

        List<CustomerAddress> customerAddressList = new ArrayList<CustomerAddress>();
        customerAddressList.add(customerAddress);

        Customer customer= Customer.builder()
                .firstName("Abc")
                .lastName("ddd")
                .email("abc@gmail.com")
                .mobile("+9876543210")
                .customerStatus(com.example.digishopkart.model.Customer.CustomerStatusEnum.ACTIVE)
                .customerAddress(customerAddressList).build();
        System.out.println(customer.toString()+"AAAAAA");
        System.out.println(customerAddressList);
        customerRepository.save(customer);
        Assertions.assertThat(customer.getId()).isGreaterThan(0);
    }

    @Test
    public void getCustomerTest(){
        Customer customer= customerRepository.findById(1).get();

        Assertions.assertThat(customer.getId()).isEqualTo(1);
    }
}
