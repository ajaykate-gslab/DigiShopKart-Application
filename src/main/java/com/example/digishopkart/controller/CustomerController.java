package com.example.digishopkart.controller;

import com.example.digishopkart.api.AddCustomerApi;
import com.example.digishopkart.api.FetchAllCustomersApi;
import com.example.digishopkart.api.FetchCustomerByIdApi;
import com.example.digishopkart.api.UpdateCustomerByIdApi;
import com.example.digishopkart.entity.Customer;
import com.example.digishopkart.mapper.CustomerMapper;
import com.example.digishopkart.repository.CustomerRepository;
import com.example.digishopkart.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class CustomerController implements AddCustomerApi, FetchCustomerByIdApi, FetchAllCustomersApi, UpdateCustomerByIdApi {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private CustomerRepository customerRepository;

    // ------------------- API TO ADD A CUSTOMER ------------------
    /*public ResponseEntity<Customer> createCustomer(com.example.digishopkart.model.Customer customer){
        return new ResponseEntity(customerService.createCustomerPost(customer), HttpStatus.ACCEPTED);
    }*/

    // ------------------- API TO FETCH CUSTOMER ------------------
    public ResponseEntity<Customer> fetchCustomerById(String id) {
        return new ResponseEntity(customerService.fetchCustomerByIdGet(id), HttpStatus.FOUND);
    }

    // ------------------- TEST ------------------
    @GetMapping("/test")
    public String test() {
        return "tested...!!!";
    }

    // ------------------- API TO ADD A CUSTOMER -----------------
    @Override
    public ResponseEntity<com.example.digishopkart.model.Customer> addCustomerPost(com.example.digishopkart.model.Customer body) {
        com.example.digishopkart.entity.Customer customer = new com.example.digishopkart.entity.Customer();
        customer = customerMapper.CustomerModelToCustomerEntity(body);
        return new ResponseEntity(customerRepository.save(customer), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<com.example.digishopkart.model.Customer>> fetchAllCustomersGet() {
        return null;
    }

    @Override
    public ResponseEntity<com.example.digishopkart.model.Customer> fetchCustomerByIdGet(String id) {
        return null;
    }

    @Override
    public ResponseEntity<com.example.digishopkart.model.Customer> updateCustomerByIdPut(BigDecimal id, com.example.digishopkart.model.Customer body) {
        return null;
    }
}
