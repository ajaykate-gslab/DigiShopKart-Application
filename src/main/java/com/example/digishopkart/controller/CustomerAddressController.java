package com.example.digishopkart.controller;

import com.example.digishopkart.api.CustomerAddressApi;
import com.example.digishopkart.entity.CustomerAddressEntity;
import com.example.digishopkart.entity.CustomerEntity;
import com.example.digishopkart.mapper.CustomerAddressMapper;
import com.example.digishopkart.mapper.CustomerMapper;
import com.example.digishopkart.model.CustomerAddress;
import com.example.digishopkart.repository.CustomerAddressRepository;
import com.example.digishopkart.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
public class CustomerAddressController implements CustomerAddressApi {

    @Autowired
    private CustomerAddressMapper customerAddressMapper;
    @Autowired
    private CustomerAddressRepository customerAddressRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;
    Logger logger = LoggerFactory.getLogger(CustomerController.class);


    //------------------- API TO ADD CUSTOMER ADDRESS TO PREVIOUS CUSTOMER RECORD -------------------
    @Override
    public ResponseEntity<CustomerAddress> insertCustomerAddress(Integer customerId, CustomerAddress body) {

        Optional<CustomerEntity> optionalCustomer = customerRepository.findById(customerId);
        if (optionalCustomer.isPresent()) {
            CustomerEntity customerEntity = optionalCustomer.get();
            List<CustomerAddressEntity> customerAddressEntities = customerEntity.getCustomerAddress();
            customerAddressEntities.add(customerAddressMapper.customerAddressDtoToCustomerAddressEntity(body));
            customerEntity.setCustomerAddress(customerAddressEntities);

            CustomerAddressEntity customerAddressEntity=customerRepository.save(customerEntity).getCustomerAddress().get(customerEntity.getCustomerAddress().size()-1);

            return new ResponseEntity(customerAddressEntity, HttpStatus.CREATED);
        } else {
            return new ResponseEntity(("Please Enter valid customerId to add address"), HttpStatus.NOT_FOUND);
        }
    }


    //------------------- API TO DELETE CUSTOMER ADDRESS FROM PREVIOUS CUSTOMER RECORD -------------------
    @Override
    public ResponseEntity<CustomerAddress> deleteCustomerAddress(Integer addressId) {
        Optional<CustomerAddressEntity> optionalCustomerAddress = customerAddressRepository.findById(addressId);
        if (optionalCustomerAddress.isPresent()) {

            customerAddressRepository.deleteById(addressId);
            return new ResponseEntity("'"+optionalCustomerAddress.get().getAddressType()+ "' type Address removed, of customer : "+optionalCustomerAddress.get().getCustomerFullName()+"'",HttpStatus.OK);
        }else {
            return new ResponseEntity("Customer Address not found for this addressId",HttpStatus.NOT_FOUND);
        }
    }

    //------------------- API TO FETCH CUSTOMERS ALL ADDRESSES  -------------------
    @Override
    public ResponseEntity<List<CustomerAddress>> fetchAllCustomerAddresses() {
        return new ResponseEntity(customerAddressRepository.findAll(),HttpStatus.OK);
    }

    //------------------- API TO FETCH ALL CUSTOMER ADDRESSES OF PERTICULAR CUSTOMER  -------------------
    @Override
    public ResponseEntity<CustomerAddress> fetchCustomerAddress(Integer customerId) {
        Optional<CustomerEntity> optionalCustomer = customerRepository.findById(customerId);
        if (optionalCustomer.isPresent()){
            return new ResponseEntity(optionalCustomer.get().getCustomerAddress(),HttpStatus.FOUND);
        }else {
            return new ResponseEntity("Please enter valid customreId to fech addresses",HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<CustomerAddress> updateCustomerAddress(Integer addressId, CustomerAddress body) {
        Optional<CustomerAddressEntity> optionalCustomerAddress= customerAddressRepository.findById(addressId);
        if (optionalCustomerAddress.isPresent()){
            return new ResponseEntity(customerAddressRepository.save(customerAddressMapper.customerAddressDtoToCustomerAddressEntity(body)),HttpStatus.OK);
        }else {
            return new ResponseEntity("Please Enter Valid addressId...!!!",HttpStatus.NOT_FOUND);
        }
    }

}
