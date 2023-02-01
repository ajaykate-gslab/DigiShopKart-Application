package com.example.digishopkart.controller;

import com.example.digishopkart.entity.Customer;
import com.example.digishopkart.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/test")
    public String test(){
        return "tested...!!!";
    }

    public ResponseEntity<Customer> createCustomer(com.example.digishopkart.model.Customer customer){
        return new ResponseEntity(customerService.createCustomerPost(customer), HttpStatus.ACCEPTED);
    }

    public ResponseEntity<Customer> fetchCustomerById(String id){
        return new ResponseEntity(customerService.fetchCustomerByIdGet(id),HttpStatus.FOUND);
    }
}
