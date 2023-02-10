package com.example.digishopkart.controller;

import com.example.digishopkart.api.*;
import com.example.digishopkart.entity.Customer;
import com.example.digishopkart.entity.CustomerAddress;
import com.example.digishopkart.mapper.CustomerMapper;
import com.example.digishopkart.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
public class CustomerController implements AddCustomerApi, FetchCustomerByIdApi, FetchAllCustomersApi, UpdateCustomerByIdApi, DeleteCustomerByIdApi {
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private CustomerRepository customerRepository;
    Logger logger= LoggerFactory.getLogger(CustomerController.class);

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
        return new ResponseEntity(customerList, HttpStatus.OK);
    }


    // ----------------------------- API TO FETCH CUSTOMER BY ID -----------------------------------
    @Override
    public ResponseEntity<com.example.digishopkart.model.Customer> fetchCustomerByIdGet(Integer id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            return new ResponseEntity(optionalCustomer, HttpStatus.FOUND);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


    // ----------------------------- API TO DELETE CUSTOMER BY ID -----------------------------------

    @Override
    public ResponseEntity<com.example.digishopkart.model.Customer> deleteCustomerByIdDelete(Integer id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            customerRepository.deleteById(id);
            return new ResponseEntity("Customer '" + customer.get().getCustomerAddress().getCustomerFullName() + "' deleted successfully ...!!!", HttpStatus.OK);
        } else {
            return new ResponseEntity("Please Enter Valid Customer Id...!!!", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<com.example.digishopkart.model.Customer> updateCustomerByIdPatch(Integer id, com.example.digishopkart.model.Customer body) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            logger.info("Customer is present of the id :"+id);
            Customer customer =customerRepository.save(customerMapper.CustomerModelToCustomerEntity(body));
            return new ResponseEntity(customer, HttpStatus.OK);
        }
        else {
            return new ResponseEntity("Please Enter valid customer to update record...!!!",HttpStatus.NOT_FOUND);
        }
    }
}
