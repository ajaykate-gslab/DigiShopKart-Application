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
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
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
        return null;
    }

    @Override
    public ResponseEntity<List<Discount>> fetchAllDiscounts() {
        return new ResponseEntity(discountRepository.findAll(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Discount> fetchDiscount(Integer discountId) {
        return null;
    }

    @Override
    public ResponseEntity<Discount> updateDiscount(Integer discountId, Discount body) {
        return null;
    }
    /*@Autowired
    private DiscountRepository discountRepository;
    @Autowired
    private DiscountMapper discountMapper;
    Logger logger = LoggerFactory.getLogger(CustomerController.class);

    //---------------- API TO CREATE DISCOUNT COUPON ----------------
    @Override
    public ResponseEntity<Discount> createDiscountCouponPost(Discount body) {
        return new ResponseEntity(discountRepository.save(discountMapper.DiscountModelToDiscountEntity(body)), HttpStatus.CREATED);
    }

    //---------------- API TO DELETE DISCOUNT COUPON BY ID----------------
    @Override
    public ResponseEntity<Discount> deleteDiscountCouponByIdDelete(Integer id) {
        Optional<com.example.digishopkart.entity.Discount> discountOptional = discountRepository.findById(id);
        if (discountOptional.isPresent()) {
            logger.info("Discount Coupon found for this id :" + id);
            discountRepository.deleteById(id);
            return new ResponseEntity("Discount Coupon '" + discountOptional.get().getCouponName() + " 'Deleted...!!!", HttpStatus.OK);
        } else {
            return new ResponseEntity("Please enter valid couponId ...!!!", HttpStatus.NOT_FOUND);
        }
    }


    //---------------- API TO FETCH ALL DISCOUNT COUPONS ----------------
    @Override
    public ResponseEntity<List<Discount>> fetchAllDiscountCouponsGet() {
        return new ResponseEntity(discountRepository.findAll(), HttpStatus.OK);
    }


    //---------------- API TO FETCH DISCOUNT COUPON BY ID----------------
    @Override
    public ResponseEntity<Discount> fetchDiscountCouponByIdGet(Integer id) {
        Optional<com.example.digishopkart.entity.Discount> discountOptional =
                discountRepository.findById(id);
        if (discountOptional.isPresent()) {
            logger.info("Discount Coupon found for this id :" + id);
            return new ResponseEntity(discountOptional.get(), HttpStatus.FOUND);
        } else {
            return new ResponseEntity("Please Enter Valid Discount Coupon Id...!!!", HttpStatus.NOT_FOUND);
        }
    }

    //---------------- API TO UPDATE DISCOUNT COUPON BY ID ----------------
    @Override
    public ResponseEntity<Discount> updateDiscountCouponByIdPatch(Integer id, Discount body) {
        Optional<com.example.digishopkart.entity.Discount> discountOptional = discountRepository.findById(id);
        if (discountOptional.isPresent()) {
            return new ResponseEntity(discountRepository
                    .save(discountMapper.DiscountModelToDiscountEntity(body)), HttpStatus.OK);
        } else {
            return new ResponseEntity("Please Enter Valid Discount Coupon Id...!!!", HttpStatus.NOT_FOUND);
        }
    }*/
}
