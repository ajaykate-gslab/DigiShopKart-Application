package com.example.digishopkart.controller;

import com.example.digishopkart.api.CustomerApi;
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
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;


@RestController
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

    // --------------------------------------- TEST ---------------------------------------
    @GetMapping("/test")
    public String test() {
        return "tested...!!!";
    }


    // --------------------------------------- API TO ADD A CUSTOMER ---------------------------------------
    @Override
    @ExceptionHandler
    public ResponseEntity<Customer> addCustomer( Customer body) {
        return new ResponseEntity(
                customerRepository.save(customerMapper
                .CustomerModelToCustomerEntity(body)), HttpStatus.CREATED);
    }


    // --------------------------------------- API TO DELETE CUSTOMER BY ID ---------------------------------------
    @Override
    public ResponseEntity<Customer> deleteCustomer(Integer customerId) {
        Optional<com.example.digishopkart.entity.Customer> customer = customerRepository.findById(customerId);
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
        List<com.example.digishopkart.entity.Customer> customerList = customerRepository.findAll();
        return new ResponseEntity(customerList, HttpStatus.OK);
    }

    // --------------------------------------- API TO FETCH CUSTOMER BY ID ---------------------------------------
    @Override
    public ResponseEntity<Customer> fetchCustomer(Integer customerId) {
        Optional<com.example.digishopkart.entity.Customer> optionalCustomer = customerRepository.findById(customerId);
        if (optionalCustomer.isPresent()) {
            return new ResponseEntity(optionalCustomer, HttpStatus.FOUND);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


    // --------------------------------------- API TO UPDATE CUSTOMER BY ID ---------------------------------------
    @Override
    public ResponseEntity<Customer> updateCustomer(Integer customerId, Customer body) {
        Optional<com.example.digishopkart.entity.Customer> optionalCustomer = customerRepository.findById(customerId);
        if (optionalCustomer.isPresent()) {
            com.example.digishopkart.entity.Customer customer = customerRepository.save(customerMapper.CustomerModelToCustomerEntity(body));
            return new ResponseEntity(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity("Please Enter valid customer to update record...!!!", HttpStatus.NOT_FOUND);
        }
    }
    /*
    // --------------------------------------- API TO ADD A CUSTOMER ---------------------------------------
    @Override
    public ResponseEntity<com.example.digishopkart.model.Customer> addCustomerPost(com.example.digishopkart.model.Customer body) {
        return new ResponseEntity(customerRepository
                .save(customerMapper
                        .CustomerModelToCustomerEntity(body)), HttpStatus.CREATED);
    }

    // --------------------------------------- API TO FETCH ALL CUSTOMERS ---------------------------------------
    @Override
    public ResponseEntity<List<com.example.digishopkart.model.Customer>> fetchAllCustomersGet() {
        List<Customer> customerList = customerRepository.findAll();
        return new ResponseEntity(customerList, HttpStatus.OK);
    }


    // --------------------------------------- API TO FETCH CUSTOMER BY ID ---------------------------------------
    @Override
    public ResponseEntity<com.example.digishopkart.model.Customer> fetchCustomerByIdGet(Integer id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            return new ResponseEntity(optionalCustomer, HttpStatus.FOUND);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


    // --------------------------------------- API TO DELETE CUSTOMER BY ID ---------------------------------------

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
    // --------------------------------------- API TO UPDATE CUSTOMER BY ID ---------------------------------------
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
    }*/


}
