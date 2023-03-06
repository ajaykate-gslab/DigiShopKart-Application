package com.example.digishopkart.controller;

import com.example.digishopkart.api.*;
import com.example.digishopkart.mapper.DiscountMapper;
import com.example.digishopkart.model.Discount;
import com.example.digishopkart.repository.DiscountRepository;
import com.example.digishopkart.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@Component
public class DiscountController implements DiscountApi {
    @Autowired
    private DiscountRepository discountRepository;
    @Autowired
    private DiscountMapper discountMapper;
    Logger logger = LoggerFactory.getLogger(CustomerController.class);
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public ResponseEntity<Discount> createDiscount(Discount body) {
        return new ResponseEntity(discountRepository.save(discountMapper.DiscountModelToDiscountEntity(body)), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Discount> deleteDiscount(Integer discountId) {
        Optional<com.example.digishopkart.entity.Discount> discountOptional = discountRepository.findById(discountId);
        if (discountOptional.isPresent()) {
            discountRepository.deleteById(discountId);
            return new ResponseEntity("'" + discountOptional.get().getCouponName() + "' discount deleted Successfully...!!!", HttpStatus.OK);
        } else {
            return new ResponseEntity("Please Enter Valid discountId to delete the record", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<List<Discount>> fetchAllDiscounts() {
        return new ResponseEntity(discountRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Discount> fetchDiscount(Integer discountId) {
        Optional<com.example.digishopkart.entity.Discount> discountOptional = discountRepository.findById(discountId);
        if (discountOptional.isPresent()) {
            return new ResponseEntity(discountOptional.get(), HttpStatus.FOUND);
        } else {
            return new ResponseEntity("Please Enter Valid discountId to fetch the record", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Discount> updateDiscount(Integer discountId, Discount body) {
        Optional<com.example.digishopkart.entity.Discount> discountOptional = discountRepository.findById(discountId);
        if (discountOptional.isPresent()) {
            return new ResponseEntity(discountRepository.save(discountMapper.DiscountModelToDiscountEntity(body)), HttpStatus.OK);
        } else {
            return new ResponseEntity("Please Enter Valid discountId to update record", HttpStatus.NOT_FOUND);
        }
    }
}
