package com.example.digishopkart.controller;

import com.example.digishopkart.entity.CustomerEntity;
import com.example.digishopkart.entity.CustomerAddressEntity;
import com.example.digishopkart.mapper.CustomerMapper;
import com.example.digishopkart.model.Customer;
import com.example.digishopkart.model.CustomerAddress;
import com.example.digishopkart.repository.CustomerAddressRepository;
import com.example.digishopkart.repository.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerControllerTestApis {
    @MockBean
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerController customerController;
    @Autowired
    private CustomerMapper customerMapper;
    CustomerEntity customerEntity =new CustomerEntity();
    Customer customerDto=new Customer();

    //Method for object initialization
    public static CustomerEntity getCustomerEntity(){
        CustomerAddressEntity customerAddressEntity =
                new CustomerAddressEntity(1, CustomerAddress.AddressTypeEnum.SHIPPING, "Ajay kate", "India", "MH", "Pune", "kharadi", "abc123", "near XYZ", 411014, "1234567890");
        List<CustomerAddressEntity> customerAddressEntityList = new ArrayList<CustomerAddressEntity>();
        customerAddressEntityList.add(customerAddressEntity);
        CustomerEntity customerEntity =
                new CustomerEntity(1, "Ajay", "Kate", "ajay@gmail.com", "0987654321", Customer.CustomerStatusEnum.ACTIVE, customerAddressEntityList);
        return customerEntity;
    }

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
    private List<Customer> customerList;
    private List<CustomerEntity> customerEntityList;
    @Autowired
    private CustomerAddressRepository customerAddressRepository;

    public static List<CustomerEntity> getCustomerEntityList(){
        List<CustomerEntity> customerEntityList=new ArrayList<CustomerEntity>();
        customerEntityList.add(getCustomerEntity());
        return customerEntityList;
    }

    public static List<Customer> getCustomerDtoList(){
       List<Customer> customerDtoList = new ArrayList<>();
        customerDtoList.add(getCustomerDto());
        return customerDtoList;
    }



    //------------------ TEST FOR API OF addCustomer  ----------------------------
    @Test
    public void testAddCustomer(){
        customerEntity = getCustomerEntity();
        customerDto = getCustomerDto();
        when(customerRepository.save(customerEntity)).thenReturn(customerEntity);
        ResponseEntity<Customer> customerResponseEntity = customerController.addCustomer(customerDto);
        assertEquals(HttpStatus.CREATED,customerResponseEntity.getStatusCode());
        //assertEquals(customerEntity,customerResponseEntity.getBody());
    }


    // ----------------- TEST FOR API OF fetchAllCustomers  --------------------
    @Test
    public void testFetchAllCustomers() {
        List<Customer> customerDtoList = getCustomerDtoList();
        List<CustomerEntity> customerEntityList=getCustomerEntityList();

        customerDtoList.add(getCustomerDto());
        customerEntityList.add(getCustomerEntity());

        when(customerRepository.findAll()).thenReturn(customerEntityList);

        ResponseEntity<List<Customer>> response = customerController.fetchAllCustomers();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(customerEntityList,response.getBody());
        assertEquals(customerEntityList.size(),response.getBody().size());
}


    // ----------------------- TEST FOR API OF fetchCustomer --------------------

    @Test
    public void testFetchCustomerReturnsFound() {
        customerEntity=getCustomerEntity();
        customerDto=getCustomerDto();
        when(customerRepository.findById(customerDto.getId())).thenReturn(Optional.of(customerEntity));
        ResponseEntity<Customer> responseEntity = customerController.fetchCustomer(customerDto.getId());
        assertEquals(HttpStatus.FOUND, responseEntity.getStatusCode());
        assertEquals(customerEntity,responseEntity.getBody());
    }
    @Test
    public void testFetchCustomerReturnsNotFound() {
        customerEntity=getCustomerEntity();
        customerDto=getCustomerDto();
        String expectedResult ="Please Enter valid customerId to add address";
        when(customerRepository.findById(customerDto.getId())).thenReturn(Optional.empty());

        ResponseEntity<Customer> response = customerController.fetchCustomer(customerDto.getId());
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(expectedResult, response.getBody());
    }
    // ------------------ TEST FOR API OF updateCustomer ------------------------
    @Test
    public void testUpdateCustomerReturnFound(){
        int customerId =1;
        customerEntity = getCustomerEntity();
        customerDto = getCustomerDto();

        when(customerRepository.findById(customerId)).thenReturn(Optional.of(customerEntity));
        when(customerRepository.save(customerEntity)).thenReturn(customerEntity);

        ResponseEntity<Customer> response=customerController.updateCustomer(customerId,customerDto);

        assertEquals(HttpStatus.OK,response.getStatusCode());
        //assertEquals(customerEntity,response.getBody());
    }

    @Test
    public void testUpdateCustomerReturnNotFound(){
        int customerId =1;
        customerEntity = getCustomerEntity();
        customerDto = getCustomerDto();
        String expectedResult = "Please Enter valid customer to update record...!!!";

        when(customerRepository.findById(customerId)).thenReturn(Optional.empty());
        when(customerRepository.save(customerEntity)).thenReturn(customerEntity);

        ResponseEntity<Customer> response=customerController.updateCustomer(customerId,customerDto);

        assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
        assertEquals(expectedResult,response.getBody());
    }
    // ------------ TEST FOR API OF deleteCustomer ------------
    @Test
    public void testDeleteCustomerByIdReturnFound()
    {
        // Setup
        int customerId = 1;
        String expectedResult = "Customer of email Id : '"+ customerEntity.getEmail()+"' deleted successfully ...!!!";
        when(customerRepository.findById(customerId)).thenReturn(Optional.of(customerEntity));
        doNothing().when(customerRepository).deleteById(customerId);
        // Exercise
        ResponseEntity<Customer> response = customerController.deleteCustomer(customerId);
        // Verify
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResult, response.getBody());
    }

    @Test
    public void testDeleteCustomerByIdReturntNotFound()
    {
        // Setup
        int customerId = 1;
        String expectedResult = "Please Enter Valid Customer Id...!!!";
        when(customerRepository.findById(customerId)).thenReturn(Optional.empty());
        doNothing().when(customerRepository).deleteById(customerId);
        // Exercise
        ResponseEntity<Customer> response = customerController.deleteCustomer(customerId);
        // Verify
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(expectedResult, response.getBody());
    }
    //------
    @Test
    public void testUpdateCustomerWithValidCustomer() {
        customerEntity=getCustomerEntity();
        customerDto=getCustomerDto();
        String expectedResult1 = "ajaykate@gmail.com";
        Customer.CustomerStatusEnum expectedResult2 =  Customer.CustomerStatusEnum.INACTIVE;

        when(customerRepository.findById(customerDto.getId())).thenReturn(Optional.of(customerEntity));

        Customer updatedCustomerDto = new Customer();
        updatedCustomerDto = customerDto;
        updatedCustomerDto.setEmail("ajaykate@gmail.com");
        updatedCustomerDto.setCustomerStatus(Customer.CustomerStatusEnum.INACTIVE);

        CustomerEntity updatedCustomerEntity = new CustomerEntity();
        updatedCustomerEntity = customerEntity;
        updatedCustomerEntity.setEmail("ajaykate@gmail.com");
        updatedCustomerEntity.setCustomerStatus(Customer.CustomerStatusEnum.INACTIVE);

        when(customerRepository.save(updatedCustomerEntity)).thenReturn(updatedCustomerEntity);
        ResponseEntity<Customer> responseEntity = customerController.updateCustomer(customerDto.getId(), updatedCustomerDto);

        // assert that the HTTP status is OK
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedResult1, updatedCustomerEntity.getEmail());
        assertEquals(expectedResult2, updatedCustomerEntity.getCustomerStatus());
       // assertEquals(updatedCustomerEntity, responseEntity);
    }

}
