package com.example.digishopkart.controller;

import com.example.digishopkart.entity.Customer;
import com.example.digishopkart.entity.CustomerAddress;
import com.example.digishopkart.mapper.CustomerAddressMapper;
import com.example.digishopkart.repository.CustomerAddressRepository;
import com.example.digishopkart.repository.CustomerRepository;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CustomerAddressControllerTestApis {
    @MockBean
    private CustomerAddressRepository customerAddressRepository;
    @MockBean
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerAddressController customerAddressController;
    @Autowired
    private CustomerAddressMapper customerAddressMapper;

    CustomerAddress customerAddress = new CustomerAddress();
    Customer customer = new Customer();
    int customerId = 122;
    int customerAddressId = 122;

    public static Customer getCustomerObject() {
        CustomerAddress customerAddress =
                new CustomerAddress(1, com.example.digishopkart.model.CustomerAddress.AddressTypeEnum.SHIPPING, "Ajay kate", "India",
                        "MH", "Pune", "kharadi", "abc123",
                        "near XYZ", 411014, "1234567890");
        List<CustomerAddress> customerAddressList = new ArrayList<CustomerAddress>();
        customerAddressList.add(customerAddress);
        Customer customer =
                new Customer(1, "Ajay", "Kate", "ajay@gmail.com", "0987654321",
                        com.example.digishopkart.model.Customer.CustomerStatusEnum.ACTIVE, customerAddressList);
        return customer;
    }


    // -------------- TEST CASE FOR INSERTING CUSTOMER_ADDERSS FOR PEETICULAR CUSTOMER  ----------------
    @Test
    public void addCustomerAddressTest() {
        // int customerId = 1;
        customer = getCustomerObject();
        // List<CustomerAddress> customerAddressList = customer.getCustomerAddress();
        if (customerId == customer.getId()) {
            when(customerRepository.findById(customer.getId())).thenReturn(Optional.of(customer));
            when(customerRepository.save(customer)).thenReturn(customer);
            assertEquals(customer, customerAddressController
                    .insertCustomerAddress(customerId, customerAddressMapper.
                            customerAddressEntityToCustomerAddressModel(customerAddress)).getBody());
            when(customerRepository.save(customer)).thenReturn(customer);
        } else {
            assertEquals("Please Enter valid customerId to add address", customerAddressController
                    .insertCustomerAddress(customerId, customerAddressMapper.
                            customerAddressEntityToCustomerAddressModel(customerAddress)).getBody());
        }
    }

    // -------------- TEST CASE FOR GET CUSTOMER ADDERSS API ------------------------
    @Test
    public void fetchCustomerAddressTest() {
        // int customerId = 11;
        customer = getCustomerObject();
        //List<CustomerAddress> customerAddressList = customer.getCustomerAddress();
        if (customerId == customer.getId()) {
            when(customerRepository.findById(customerId)).thenReturn(Optional.of(customer));
            assertEquals(customer.getCustomerAddress(), customerAddressController
                    .fetchCustomerAddress(customerId).getBody());
            System.out.println("in if");
        } else {
            System.out.println("in else");
            // when(customerRepository.findById(customerId)).thenReturn(Optional.of(customer));
            assertEquals("Please enter valid customreId to fech addresses", customerAddressController
                    .fetchCustomerAddress(customerId).getBody());
        }
    }

    // -------------- TEST CASE FOR GET ALL CUSTOMER ADDERSSES API ------------------------
    @Test
    public void fetchAllCustomerAddressTest() {
        customer = getCustomerObject();
        List<CustomerAddress> customerAddressList = customer.getCustomerAddress();
        when(customerAddressRepository.findAll()).thenReturn(customerAddressList);
        assertEquals(customerAddressList, customerAddressController.fetchAllCustomerAddresses().getBody());
    }

    // -------------- TEST CASE FOR DELETE CUSTOMER ADDERSS API ------------------------
    @Test
    public void deleteCustomerAddressTest() {
        customerAddress = getCustomerObject().getCustomerAddress().get(0);
        when(customerAddressRepository.findById(1)).thenReturn(Optional.of(customerAddress));
        if (customerAddressId == customerAddress.getId()) {
            assertEquals("'" + customerAddress.getAddressType() + "' type Address removed, of customer : " + customerAddress
                    .getCustomerFullName(), customerAddressController.deleteCustomerAddress(customerAddressId).getBody());
        } else {
            assertEquals("Customer Address not found for this addressId", customerAddressController.deleteCustomerAddress(customerAddressId).getBody());
        }
    }

    // -------------- TEST CASE FOR UPDATE CUSTOMER ADDERSS API ------------------------
    @Test
    public void updateCustomerAddressTest() {
        customerAddress = getCustomerObject().getCustomerAddress().get(0);
        when(customerAddressRepository.findById(customerAddressId)).thenReturn(Optional.of(customerAddress));
        when(customerAddressRepository.save(customerAddress)).thenReturn(customerAddress);
        assertEquals(customerAddress, customerAddressController
                .updateCustomerAddress(customerAddressId, customerAddressMapper
                        .customerAddressEntityToCustomerAddressModel(customerAddress)).getBody());

    }


}
