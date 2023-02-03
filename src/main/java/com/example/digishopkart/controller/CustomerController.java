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
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController implements AddCustomerApi, FetchCustomerByIdApi, FetchAllCustomersApi, UpdateCustomerByIdApi {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private CustomerRepository customerRepository;

    // ------------------- TEST ------------------
    @GetMapping("/test")
    public String test() {
        return "tested...!!!";
    }

    // ---------------------------------- API TO ADD A CUSTOMER ------------------------------
    @Override
    public ResponseEntity<com.example.digishopkart.model.Customer> addCustomerPost(com.example.digishopkart.model.Customer body) {
        return new ResponseEntity(customerRepository
                .save(customerMapper
                        .CustomerModelToCustomerEntity(body)), HttpStatus.CREATED);
    }
    // ----------------------------- API TO FETCH ALL CUSTOMERS -----------------------------------
    @Override
    public ResponseEntity<List<com.example.digishopkart.model.Customer>> fetchAllCustomersGet() {
        List<Customer> customerList = customerRepository.findAll();
        return new ResponseEntity(customerList,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<com.example.digishopkart.model.Customer> updateCustomerByIdPut(BigDecimal id, com.example.digishopkart.model.Customer body) {
        return null;
    }
    // ----------------------------- API TO FETCH CUSTOMER BY ID -----------------------------------
    @Override
    public ResponseEntity<com.example.digishopkart.model.Customer> fetchCustomerByIdGet(Integer id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            System.out.println(optionalCustomer.get().getEmail());
            return new ResponseEntity(optionalCustomer, HttpStatus.FOUND);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
