package com.example.digishopkart.controller;

import com.example.digishopkart.entity.DiscountEntity;
import com.example.digishopkart.mapper.DiscountMapper;
import com.example.digishopkart.model.Discount;
import com.example.digishopkart.repository.DiscountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
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
    DiscountEntity discountEntity = new DiscountEntity();
    Discount discountDto = new Discount();

    public static DiscountEntity getDiscountEntity(){

        DiscountEntity discountEntity =new DiscountEntity(1,"FLAT100",
                com.example.digishopkart.model.Discount.DiscountTypeEnum.FLAT,100.0);
        return discountEntity;
    }

    public static Discount getDiscountDto(){
        Discount discount=new Discount();
        discount.setId(1);
        discount.setCouponName("FLAT100");
        discount.setCouponValue(100.0);
        discount.setDiscountType(Discount.DiscountTypeEnum.FLAT);
        return discount;
    }

    //------------- Test Case To Insert Discount Api ----------------------
    @Test
    public void testInsertDiscount(){
        discountEntity = getDiscountEntity();
        discountDto = getDiscountDto();
        when(discountRepository.save(discountEntity)).thenReturn(discountEntity);

        ResponseEntity<Discount> discountResponseEntity=discountController.createDiscount(discountDto);

        assertEquals(HttpStatus.CREATED,discountResponseEntity.getStatusCode());
        assertEquals(discountEntity,discountResponseEntity.getBody());

    }

    //------------- Test Case To Fetch Discount Api ----------------------
    @Test
    public void testFetchDiscountReturnFound(){
        discountEntity = getDiscountEntity();
        discountDto = getDiscountDto();
        when(discountRepository.findById(1)).thenReturn(Optional.of(discountEntity));

        ResponseEntity<Discount> discountResponseEntity=discountController.fetchDiscount(discountDto.getId());

        assertEquals(HttpStatus.FOUND,discountResponseEntity.getStatusCode());
        assertEquals(discountEntity,discountResponseEntity.getBody());
    }
    @Test
    public void testFetchDiscountReturnNotFound(){
        discountDto = getDiscountDto();
        String expectedResult = "Please Enter Valid discountId to fetch the record";
        when(discountRepository.findById(discountDto.getId())).thenReturn(Optional.empty());

        ResponseEntity<Discount> discountResponseEntity=discountController.fetchDiscount(discountDto.getId());

        assertEquals(HttpStatus.NOT_FOUND,discountResponseEntity.getStatusCode());
        assertEquals(expectedResult,discountResponseEntity.getBody());
    }


    //------------- Test Case To FetchAllDiscount Api ----------------------
    @Test
    public void testFetchAllDiscounts(){
        discountEntity = getDiscountEntity();
        when(discountRepository.findAll()).thenReturn(Stream.of(discountEntity).collect(Collectors.toList()));

        ResponseEntity<List<Discount>> discountResponseEntity = discountController.fetchAllDiscounts();

        assertEquals(HttpStatus.OK,discountResponseEntity.getStatusCode());
        assertEquals(1,discountResponseEntity.getBody().size());
    }

    // ---------------- Test Case To UpdateDiscount Api -----------------------
    @Test
    public void testUpdateDiscountRetunFound(){
        discountEntity = getDiscountEntity();
        discountDto = getDiscountDto();
        when(discountRepository.findById(1)).thenReturn(Optional.of(discountEntity));
        when(discountRepository.save(discountEntity)).thenReturn(discountEntity);

        ResponseEntity<Discount> discountResponseEntity = discountController.updateDiscount(discountDto.getId(),discountDto);

        assertEquals(HttpStatus.OK,discountResponseEntity.getStatusCode());
        assertEquals(discountEntity,discountResponseEntity.getBody());
    }

    @Test
    public void testUpdateDiscountRetunNotFound(){
        discountEntity = getDiscountEntity();
        discountDto = getDiscountDto();
        String expectedResult = "Please Enter Valid discountId to update record";
        when(discountRepository.findById(1)).thenReturn(Optional.empty());
        when(discountRepository.save(discountEntity)).thenReturn(discountEntity);

        ResponseEntity<Discount> discountResponseEntity = discountController.updateDiscount(discountDto.getId(),discountDto);

        assertEquals(HttpStatus.NOT_FOUND,discountResponseEntity.getStatusCode());
        assertEquals(expectedResult,discountResponseEntity.getBody());
    }



    //------------- Test Case To Delete Discount ----------------------
    @Test
    public void deleteDiscountTestReturnFound(){
        discountEntity = getDiscountEntity();
        String expectedResult = "'"+ discountEntity.getCouponName()+"' discount deleted Successfully...!!!";

        when(discountRepository.findById(1)).thenReturn(Optional.of(discountEntity));

        ResponseEntity<Discount> discountResponseEntity = discountController.deleteDiscount(discountEntity.getId());

        assertEquals(HttpStatus.OK,discountResponseEntity.getStatusCode());
        assertEquals(expectedResult,discountResponseEntity.getBody());
    }

    @Test
    public void testDeleteDiscountReturnNotFound(){
        discountEntity = getDiscountEntity();
        String expectedResult = "Please Enter Valid discountId to delete the record";

        when(discountRepository.findById(1)).thenReturn(Optional.empty());

        ResponseEntity<Discount> discountResponseEntity = discountController.deleteDiscount(discountEntity.getId());

        assertEquals(HttpStatus.NOT_FOUND,discountResponseEntity.getStatusCode());
        assertEquals(expectedResult,discountResponseEntity.getBody());
    }
}
