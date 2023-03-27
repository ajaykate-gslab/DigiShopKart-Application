package com.example.digishopkart.controller;

import com.example.digishopkart.api.CustomerApi;
import com.example.digishopkart.entity.CustomerEntity;
import com.example.digishopkart.mapper.CustomerAddressMapper;
import com.example.digishopkart.mapper.CustomerMapper;
import com.example.digishopkart.mapper.ProductMapper;
import com.example.digishopkart.model.Customer;
import com.example.digishopkart.repository.CustomerRepository;
import com.example.digishopkart.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@Component
public class CustomerController implements CustomerApi {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private CustomerAddressMapper customerAddressMapper;
    @Autowired
    private CustomerRepository customerRepository;
    Logger logger = LoggerFactory.getLogger(CustomerController.class);
    @Autowired
    private ProductRepository productRepository;


    // --------------------------------------- API TO ADD A CUSTOMER ---------------------------------------
    @Override
    public ResponseEntity<Customer> addCustomer(Customer body) {
        CustomerEntity customerEntity = customerRepository.save(customerMapper.CustomerDtoToCustomerEntity(body));
        return new ResponseEntity(customerEntity, HttpStatus.CREATED);
    }

    // --------------------------------------- API TO DELETE CUSTOMER BY ID ---------------------------------------
    @Override
    public ResponseEntity<Customer> deleteCustomer(Integer customerId) {
        Optional<CustomerEntity> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            customerRepository.deleteById(customerId);
            return new ResponseEntity("Customer of email Id : '" + customer.get().getEmail() + "' deleted successfully ...!!!", HttpStatus.OK);
        } else {
            return new ResponseEntity("Please Enter Valid Customer Id...!!!", HttpStatus.NOT_FOUND);
        }
    }


    // --------------------------------------- API TO FETCH ALL CUSTOMERS ---------------------------------------
    @Override
    public ResponseEntity<List<Customer>> fetchAllCustomers() {
        List<CustomerEntity> customerEntityList = customerRepository.findAll();
        return new ResponseEntity(customerEntityList, HttpStatus.OK);
    }

    // --------------------------------------- API TO FETCH CUSTOMER BY ID ---------------------------------------
    @Override
    public ResponseEntity<Customer> fetchCustomer(Integer customerId) {
        Optional<CustomerEntity> optionalCustomer = customerRepository.findById(customerId);
        if (optionalCustomer.isPresent()) {
            return new ResponseEntity(optionalCustomer.get(), HttpStatus.FOUND);
        } else {
            return new ResponseEntity("Please Enter valid customerId to add address",HttpStatus.NOT_FOUND);
        }
    }


    // --------------------------------------- API TO UPDATE CUSTOMER BY ID ---------------------------------------
    @Override
    public ResponseEntity<Customer> updateCustomer(Integer customerId, Customer body) {
        Optional<CustomerEntity> optionalCustomer = customerRepository.findById(customerId);
        if (optionalCustomer.isPresent()) {
            CustomerEntity customerEntity = new CustomerEntity();
           customerEntity = customerMapper.CustomerDtoToCustomerEntity(body);

            return new ResponseEntity(customerRepository.save(customerEntity), HttpStatus.OK);
        } else {
            return new ResponseEntity("Please Enter valid customer to update record...!!!", HttpStatus.NOT_FOUND);
        }
    }
}
