package com.example.digishopkart.controller;

import com.example.digishopkart.entity.Customer;
import com.example.digishopkart.entity.CustomerAddress;
import com.example.digishopkart.mapper.CustomerMapper;
import com.example.digishopkart.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerControllerTestApis {
    @MockBean
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerController customerController;

    @Autowired
    private CustomerMapper customerMapper;

    Customer customer=new Customer();

    //Method for object initialization
    public static Customer getCustomerObject(){
        CustomerAddress customerAddress=
                new CustomerAddress(1, com.example.digishopkart.model.CustomerAddress.AddressTypeEnum.SHIPPING, "Ajay kate", "India",
                        "MH", "Pune", "kharadi", "abc123",
                        "near XYZ", 411014, "1234567890");
        List<CustomerAddress> customerAddressList = new ArrayList<CustomerAddress>();
        customerAddressList.add(customerAddress);
        Customer customer =
                new Customer(1, "Ajay", "Kate", "ajay@gmail.com", "0987654321",
                        com.example.digishopkart.model.Customer.CustomerStatusEnum.ACTIVE,customerAddressList);
        return customer;
    }

    //------------------ TEST FOR API OF addCustomer  ----------------------------
    @Test
    public void addCustomerTest(){
        customer = getCustomerObject();
        when(customerRepository.save(customer)).thenReturn(customer);
        assertEquals(customer,customerController.
                addCustomer(customerMapper.CustomerEntityToCustomerModel(customer)).getBody());
    }


    // ----------------- TEST FOR API OF fetchAllCustomers  --------------------
    @Test
    public void getAllCustomersTest(){
        customer = getCustomerObject();
        when(customerRepository.findAll()).thenReturn(Stream.of(customer).collect(Collectors.toList()));
        assertEquals(1,customerController.fetchAllCustomers().getBody().size());
    }


    // ----------------------- TEST FOR API OF fetchCustomer --------------------
    @Test
    public void fetchCustomeerByIdTest(){
        customer = getCustomerObject();
        when(customerRepository.findById(1)).thenReturn(Optional.of(customer));
        assertEquals(HttpStatus.FOUND,customerController.fetchCustomer(1).getStatusCode());
    }


    // ------------------ TEST FOR API OF updateCustomer ------------------------
    @Test
    public void updateCustomerTest(){
        customer =getCustomerObject();

        when(customerRepository.findById(1)).thenReturn(Optional.of(customer));
        when(customerRepository.save(customer)).thenReturn(customer);
        assertEquals(customer,customerController.updateCustomer(1,
                customerMapper.CustomerEntityToCustomerModel(customer)).getBody());
    }
    // ------------ TEST FOR API OF deleteCustomer ------------
    @Test
    public void deleleCustomerByIdTest()
    {
    customer =getCustomerObject();
    when(customerRepository.findById(customer.getId())).thenReturn(Optional.of(customer));
    String expectedResult = "Customer of email Id : '"+customer.getEmail()+"' deleted successfully ...!!!";
    assertEquals(expectedResult,customerController.deleteCustomer(customer.getId()).getBody());
    }
}
