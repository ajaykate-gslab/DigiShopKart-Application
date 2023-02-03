package com.example.digishopkart.services;

import com.example.digishopkart.mapper.CustomerAddressMapper;
import com.example.digishopkart.mapper.CustomerMapper;
import com.example.digishopkart.model.Customer;
import com.example.digishopkart.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CustomerService {
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private CustomerAddressMapper customerAddressMapper;
    @Autowired
    private CustomerRepository customerRepository;

    // ----------------------- SERVICE TO ADD CUSTOMER -----------------

    public ResponseEntity<Customer> createCustomerPost(Customer body) {
        com.example.digishopkart.entity.Customer customer = new com.example.digishopkart.entity.Customer();
        customer= customerMapper.CustomerModelToCustomerEntity(body);
        return new ResponseEntity(customerRepository.save(customer), HttpStatus.CREATED);
    }

    // ----------------------- SERVICE TO FETCH CUSTOMER BY ID -----------------
    public ResponseEntity<Customer> fetchCustomerByIdGet(String id) {
        Optional<com.example.digishopkart.entity.Customer> optionalCustomer =
                customerRepository.findById(id);
        return new ResponseEntity(optionalCustomer.get(), HttpStatus.FOUND);
    }
}
