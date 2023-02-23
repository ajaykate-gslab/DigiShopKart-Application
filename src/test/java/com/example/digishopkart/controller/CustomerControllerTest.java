package com.example.digishopkart.controller;

import com.example.digishopkart.entity.Customer;
import com.example.digishopkart.entity.CustomerAddress;
import com.example.digishopkart.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.awt.print.Book;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.digishopkart.entity.Customer.*;
import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.assertj.core.api.Assertions.assertThat;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;


@WebMvcTest
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;
    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();
    @Mock
    @MockBean
    private CustomerRepository customerRepository;

    @Autowired
    private ObjectMapper objectMapper1;
    @InjectMocks
    private CustomerController customerController;

    /*Customer RECORD_1 =
            new Customer(1, "Ajay", "Kate", "ajay@gmail.com", "0987654321",
                    com.example.digishopkart.model.Customer.CustomerStatusEnum.ACTIVE,
                    new CustomerAddress(1, "Ajay kate", "India",
                            "MH", "Pune", "kharadi", "abc123",
                            "near XYZ", new BigDecimal(411014), "1234567890"));
    Customer RECORD_2 =
            new Customer(2, "ABC", "DEF", "ABC@gmail.com", "1111111111",
                    com.example.digishopkart.model.Customer.CustomerStatusEnum.ACTIVE,
                    new CustomerAddress(2, "ABC DEF", "India",
                            "MH", "MUMBAI", "DADAR", "abc123",
                            "near XYZ", new BigDecimal(123456), "1111111111"));
    Customer RECORD_3 =
            new Customer(3, "UVW", "XYZ", "UVW@gmail.com", "2222222222",
                    com.example.digishopkart.model.Customer.CustomerStatusEnum.ACTIVE,
                    new CustomerAddress(3, "UVW XYZ", "India",
                            "MH", "Delhi", "New Delhi", "abc123",
                            "near XYZ", new BigDecimal(789101), "2222222222"));*/


    //Test for fetchAllCustomersGet method of Customer Controller class
    /*@Test
    public void getAllCustomers_success() throws Exception {
        List<Customer> records = new ArrayList<>(Array//Test for fetchAllCustomersGet method of Customer Controller class
    */
    /*@Test
    public void getAllCustomers_success() throws Exception {
        List<Customer> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));
        when(customerRepository.findAll()).thenReturn(records);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/fetchAllCustomers")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(3)));
    }

    @Test
    public void getCustomerById_success() throws Exception {

        Mockito.when(customerRepository.findById(RECORD_1.getCustomerId()))
                .thenReturn(java.util.Optional.of(RECORD_1));
       *//* when(new ResponseEntity(customerRepository.findById(RECORD_1.getCustomerId()), HttpStatus.OK))
                .thenReturn(RECORD_1);*//*
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/fetchCustomerById?id=1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", notNullValue()))
                .andExpect((ResultMatcher) jsonPath("$.firstName",is("Ajay")));
    }*/



    }


