package com.example.digishopkart.controller;

import com.example.digishopkart.entity.CustomerEntity;
import com.example.digishopkart.entity.CustomerAddressEntity;
import com.example.digishopkart.mapper.CustomerAddressMapper;
import com.example.digishopkart.model.Customer;
import com.example.digishopkart.model.CustomerAddress;
import com.example.digishopkart.repository.CustomerAddressRepository;
import com.example.digishopkart.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    CustomerAddressEntity customerAddressEntity = new CustomerAddressEntity();
    CustomerEntity customerEntity = new CustomerEntity();
    Customer customerDto = new Customer();
    CustomerAddress customerAddress = new CustomerAddress();
    int customerId = 1;
    int customerAddressId = 122;

    //----- CustomerEntity Object ----------------
    public static CustomerEntity getCustomerEntity() {
        CustomerAddressEntity customerAddressEntity = new CustomerAddressEntity(1,
                CustomerAddress.AddressTypeEnum.SHIPPING,
                "Ajay Kate", "India", "MH", "Pune", "kharadi",
                "abc123",
                "near XYZ", 411014, "1234567890");
        List<CustomerAddressEntity> customerAddressEntityList = new ArrayList<CustomerAddressEntity>();
        customerAddressEntityList.add(customerAddressEntity);
        CustomerEntity customerEntity =
                new CustomerEntity(1, "Ajay", "Kate", "ajay@gmail.com", "0987654321",
                        com.example.digishopkart.model.Customer.CustomerStatusEnum.ACTIVE, customerAddressEntityList);
        return customerEntity;
    }

    //-------- CustomerDto Object ------------------
    public static Customer getCustomerDto() {
        CustomerAddress customerAddress = new CustomerAddress();
        customerAddress.setId(1);
        customerAddress.setCustomerFullName("Ajay Kate");
        customerAddress.setAddressType(CustomerAddress.AddressTypeEnum.SHIPPING);
        customerAddress.setCountry("India");
        customerAddress.setState("MH");
        customerAddress.setTown("Pune");
        customerAddress.setArea("kharadi");
        customerAddress.setHouseOrBuilding("abc123");
        customerAddress.setLandmark("near XYZ");
        customerAddress.setPinCode(411014);
        customerAddress.setMobile("1234567890");
        List<CustomerAddress> customerAddresses = new ArrayList<CustomerAddress>();
        customerAddresses.add(customerAddress);

        Customer customer = new Customer();
        customer.setId(1);
        customer.setFirstName("Ajay");
        customer.setLastName("Kate");
        customer.setEmail("ajay@gmail.com");
        customer.setMobile("1234567890");
        customer.setCustomerStatus(Customer.CustomerStatusEnum.ACTIVE);
        customer.setCustomerAddress(customerAddresses);
        return customer;
    }


    // -------------- TEST CASE FOR INSERTING CUSTOMER_ADDERSS FOR PEETICULAR CUSTOMER  ----------------
    @Test
    public void addCustomerAddressIfCustomerPresentTest() {
        // int customerId = 1;
        customerAddressEntity = getCustomerEntity().getCustomerAddress().get(0);
        customerAddress = getCustomerDto().getCustomerAddress().get(0);
        // List<CustomerAddress> customerAddressList = customer.getCustomerAddress();
        /*if (customerId == customer.getId()) {*/
        when(customerRepository.findById(getCustomerEntity().getId())).thenReturn(Optional.of(customerEntity));
        when(customerRepository.save(customerEntity)).thenReturn(customerEntity);

        ResponseEntity<CustomerAddress> customerAddressResponseEntity =
                customerAddressController.insertCustomerAddress(customerId, customerAddress);

        assertEquals(HttpStatus.CREATED,customerAddressResponseEntity.getStatusCode());
        assertEquals(customerAddressEntity, customerAddressResponseEntity.getBody());
    }

    // -------------- TEST CASE FOR INSERTING CUSTOMER_ADDERSS FOR PEETICULAR CUSTOMER IF CUSTOMER ----------------
    @Test
    public void addCustomerAddressIfCustomerNotPresentTest() {
        int customerId = 111;
        customerAddress = getCustomerDto().getCustomerAddress().get(0);
        when(customerRepository.findById(getCustomerDto().getId())).thenReturn(Optional.of(customerEntity));
        when(customerRepository.save(customerEntity)).thenReturn(customerEntity);

        ResponseEntity<CustomerAddress> customerAddressResponseEntity =
                customerAddressController.insertCustomerAddress(customerId, customerAddress);

        assertEquals(HttpStatus.NOT_FOUND, customerAddressResponseEntity.getStatusCode());
        assertEquals("Please Enter valid customerId to add address", customerAddressResponseEntity.getBody());
    }

    // -------------- TEST CASE FOR GET CUSTOMER ADDERSS API ------------------------
    @Test
    public void testFetchCustomerAddressReturnFound() {
        int customerId = 1111;
        customerEntity = getCustomerEntity();

        when(customerRepository.findById(customerId)).thenReturn(Optional.of(customerEntity));
        ResponseEntity<CustomerAddress> customerAddressResponseEntity = customerAddressController
                .fetchCustomerAddress(customerId);

        assertEquals(HttpStatus.FOUND,customerAddressResponseEntity.getStatusCode());
        assertEquals(customerEntity.getCustomerAddress() ,customerAddressResponseEntity.getBody());
    }

    @Test
    public void testFetchCustomerAddressReturnNotFound() {
        int customerId = 1111;
        customerEntity = getCustomerEntity();
        String expectedResult ="Please enter valid customreId to fech addresses";
        when(customerRepository.findById(customerId)).thenReturn(Optional.empty());
        ResponseEntity<CustomerAddress> customerAddressResponseEntity = customerAddressController
                .fetchCustomerAddress(customerId);

        assertEquals(HttpStatus.NOT_FOUND,customerAddressResponseEntity.getStatusCode());
        assertEquals(expectedResult ,customerAddressResponseEntity.getBody());
    }

    // -------------- TEST CASE FOR GET ALL CUSTOMER ADDERSSES API ------------------------
    @Test
    public void testFetchAllCustomerAddress() {
        List<CustomerAddressEntity> customerAddressEntityList = getCustomerEntity().getCustomerAddress();

        when(customerAddressRepository.findAll()).thenReturn(customerAddressEntityList);
        ResponseEntity<List<CustomerAddress>> addressListResponseEntity = customerAddressController.fetchAllCustomerAddresses();
        assertEquals(customerAddressEntityList,addressListResponseEntity.getBody());
        assertEquals(HttpStatus.OK,addressListResponseEntity.getStatusCode());
    }

    // -------------- TEST CASE FOR DELETE CUSTOMER ADDERSS API ------------------------
    @Test
    public void testDeleteCustomerAddressReturnFound() {
        customerAddressEntity = getCustomerEntity().getCustomerAddress().get(0);
        int customerAddressId = 1;
        String response ="'" + customerAddressEntity.getAddressType() + "' type Address removed, of customer : "+ customerAddressEntity.getCustomerFullName()+"'";
        customerAddressEntity = getCustomerEntity().getCustomerAddress().get(0);

        when(customerAddressRepository.findById(customerId)).thenReturn(Optional.of(customerAddressEntity));
        ResponseEntity<CustomerAddress> customerAddressResponseEntity =
                customerAddressController.deleteCustomerAddress(customerAddressId);
        assertEquals(HttpStatus.OK,customerAddressResponseEntity.getStatusCode());
        assertEquals( response,customerAddressResponseEntity.getBody() );
    }

    @Test
    public void testDeleteCustomerAddressReturnNotFound() {
        customerAddressEntity = getCustomerEntity().getCustomerAddress().get(0);
        int customerAddressId = 1;
        String response ="Customer Address not found for this addressId";
        customerAddressEntity = getCustomerEntity().getCustomerAddress().get(0);

        when(customerAddressRepository.findById(customerId)).thenReturn(Optional.empty());
        ResponseEntity<CustomerAddress> customerAddressResponseEntity =
                customerAddressController.deleteCustomerAddress(customerAddressId);

        assertEquals(HttpStatus.NOT_FOUND,customerAddressResponseEntity.getStatusCode());
        assertEquals( response,customerAddressResponseEntity.getBody() );
    }

    // -------------- TEST CASE FOR UPDATE CUSTOMER ADDERSS API ------------------------
    @Test
    public void testUpdateCustomerAddressReturnFound() {
        customerAddressEntity = getCustomerEntity().getCustomerAddress().get(0);
        customerAddress = getCustomerDto().getCustomerAddress().get(0);
        when(customerAddressRepository.findById(customerAddressId)).thenReturn(Optional.of(customerAddressEntity));
        when(customerAddressRepository.save(customerAddressEntity)).thenReturn(customerAddressEntity);
        ResponseEntity<CustomerAddress> customerAddressResponseEntity = customerAddressController.updateCustomerAddress(customerAddressId, customerAddress);
        assertEquals(customerAddressEntity, customerAddressResponseEntity.getBody());
        assertEquals(HttpStatus.OK,customerAddressResponseEntity.getStatusCode());

    }

    @Test
    public void testUpdateCustomerAddressReturnNotFound() {
        customerAddressEntity = getCustomerEntity().getCustomerAddress().get(0);
        customerAddress = getCustomerDto().getCustomerAddress().get(0);
        String expectedResult = "Please Enter Valid addressId...!!!";

        when(customerAddressRepository.findById(customerAddressId)).thenReturn(Optional.empty());
        when(customerAddressRepository.save(customerAddressEntity)).thenReturn(customerAddressEntity);

        ResponseEntity<CustomerAddress> customerAddressResponseEntity = customerAddressController.updateCustomerAddress(customerAddressId, customerAddress);

        assertEquals(expectedResult, customerAddressResponseEntity.getBody());
        assertEquals(HttpStatus.NOT_FOUND,customerAddressResponseEntity.getStatusCode());

    }


}
