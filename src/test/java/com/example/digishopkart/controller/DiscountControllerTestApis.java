package com.example.digishopkart.controller;

import com.example.digishopkart.entity.Discount;
import com.example.digishopkart.mapper.DiscountMapper;
import com.example.digishopkart.repository.DiscountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DiscountControllerTestApis {
    @Autowired
    private DiscountController discountController;
    @Autowired
    private DiscountMapper discountMapper;
    @MockBean
    private DiscountRepository discountRepository;
    Discount discount = new Discount();

    public static Discount getDiscountObject(){
        Discount discount=new Discount(1,"FLAT100",
                com.example.digishopkart.model.Discount.DiscountTypeEnum.FLAT,100.0);
        return discount;
    }

    @Test
    public void insertDiscountTest(){
        discount = getDiscountObject();
        when(discountRepository.save(discount)).thenReturn(discount);
        assertEquals(discount,discountController
                .createDiscount(discountMapper.DiscountEntityToDiscountModel(discount)).getBody());

    }

    @Test
    public void fetchDiscountTest(){
        discount = getDiscountObject();
        when(discountRepository.findById(1)).thenReturn(Optional.of(discount));
        assertEquals(discount,discountController.fetchDiscount(discount.getId()).getBody());
    }

    @Test
    public void fetchAllDiscountsTest(){
        discount = getDiscountObject();
        when(discountRepository.findAll()).thenReturn(Stream.of(discount).collect(Collectors.toList()));
        assertEquals(1,discountController.fetchAllDiscounts().getBody().size());
    }

    @Test
    public void updateDiscountTest(){
        discount = getDiscountObject();
        when(discountRepository.findById(1)).thenReturn(Optional.of(discount));
        when(discountRepository.save(discount)).thenReturn(discount);
        assertEquals(discount,discountController
                .updateDiscount(discount.getId(),
                        discountMapper.DiscountEntityToDiscountModel(discount)).getBody());
    }
 /*   public void updateCustomerTest(){
        customer =getCustomerObject();

        when(customerRepository.findById(1)).thenReturn(Optional.of(customer));
        when(customerRepository.save(customer)).thenReturn(customer);
        assertEquals(customer,customerController.updateCustomer(1,
                customerMapper.CustomerEntityToCustomerModel(customer)).getBody());
    }*/
    @Test
    public void deleteDiscountTest(){
        discount = getDiscountObject();
        when(discountRepository.findById(1)).thenReturn(Optional.of(discount));
        //productController.deleteProduct(product.getId());
        String expectedResult = "'"+discount.getCouponName()+"' discount deleted Successfully...!!!";
        assertEquals(expectedResult,discountController.deleteDiscount(discount.getId()).getBody());
    }



}
