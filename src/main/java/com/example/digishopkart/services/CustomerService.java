package com.example.digishopkart.services;

import com.example.digishopkart.api.CreateCustomerApi;
import com.example.digishopkart.api.FetchCustomerByIdApi;
import com.example.digishopkart.mapper.CustomerAddressMapper;
import com.example.digishopkart.mapper.CustomerMapper;
import com.example.digishopkart.model.Customer;
import com.example.digishopkart.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;


@Service
@RestController
public class CustomerService implements CreateCustomerApi, FetchCustomerByIdApi {

    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private CustomerAddressMapper customerAddressMapper;

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public ResponseEntity<Customer> createCustomerPost(Customer body) {
        com.example.digishopkart.entity.Customer customer = new com.example.digishopkart.entity.Customer();
        System.out.println("Body"+body.toString());

        customer= customerMapper.CustomerModelToCustomerEntity(body);

        System.out.println("****"+customer.toString());
        return new ResponseEntity(customerRepository.save(customer), HttpStatus.CREATED);

    }

    @Override
    public ResponseEntity<Customer> fetchCustomerByIdGet(String id) {
        return null;
    }
}
