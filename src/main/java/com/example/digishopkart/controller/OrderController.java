package com.example.digishopkart.controller;

import com.example.digishopkart.api.*;
import com.example.digishopkart.entity.Customer;
import com.example.digishopkart.entity.Discount;
import com.example.digishopkart.entity.Product;
import com.example.digishopkart.mapper.OrderMapper;
import com.example.digishopkart.model.Order;
import com.example.digishopkart.repository.CustomerRepository;
import com.example.digishopkart.repository.DiscountRepository;
import com.example.digishopkart.repository.OrderRepository;
import com.example.digishopkart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.format.DateTimeFormatter;

import java.util.Optional;

@RestController
public class OrderController implements CreateOrderApi, FetchOrderByIdApi, FetchAllOrdersApi, UpdateOrderByIdApi, DeleteOrderByIdApi {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private DiscountRepository discountRepository;
    @Autowired
    private OrderMapper orderMapper;


    //--------------------------------------- API TO CREATE ORDER ---------------------------------------
    @Override
    public ResponseEntity<Order> createOrderPost(Order body) {
        Optional<Customer> optionalCustomer = customerRepository.findById(body.getCustomer().getCustomerId());
        Optional<Product> optionalProduct = productRepository.findById(body.getProduct().getProductId());
        Optional<Discount> optionalDiscount = discountRepository.findById(body.getDiscount().getDiscountId());

        com.example.digishopkart.entity.Order order = new com.example.digishopkart.entity.Order();
        double d;
        if (optionalCustomer.isPresent()) {
            if (optionalProduct.isPresent()) {
                if (optionalDiscount.isPresent()) {
                    order.setCustomer(optionalCustomer.get());
                    order.setProduct(optionalProduct.get());
                    order.setDiscount(optionalDiscount.get());

                    LocalDateTime localDateTime = LocalDateTime.now();
                    org.threeten.bp.format.DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy 'at' hh:mm a");
                    String currentDate = dateTimeFormatter.format(localDateTime);

                    order.setActivatedAt(currentDate);
                    order.setCouponValue(optionalDiscount.get().getCouponValue());
                    order.setCouponName(optionalDiscount.get().getCouponName());
                    order.setProductName(optionalProduct.get().getProductName());
                    order.setOrderStatus(body.getOrderStatus());
                    if (optionalDiscount.get().getDiscountType().equals(com.example.digishopkart.model.Discount.DiscountTypeEnum.FLAT)) {
                        d = optionalProduct.get().getProductPrice() - optionalDiscount.get().getCouponValue();
                        order.setDiscountPrice(d);
                    } else if (optionalDiscount.get().getDiscountType().equals(com.example.digishopkart.model.Discount.DiscountTypeEnum.PERCENTAGE)) {
                        d = optionalProduct.get().getProductPrice() * (optionalDiscount.get().getCouponValue() / 100);
                        order.setDiscountPrice(d);
                    }
                    return new ResponseEntity(orderRepository.save(order), HttpStatus.CREATED);
                } else {
                    return new ResponseEntity("Please Enter valid Discount id", HttpStatus.NOT_FOUND);
                }
            } else {
                return new ResponseEntity("Please Enter valid Product id", HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity("Please Enter valid Customer id", HttpStatus.NOT_FOUND);
        }
    }


    //--------------------------------------- API TO DELETE ORDER BY ID ---------------------------------------
    @Override
    public ResponseEntity<Order> deleteOrderByIdDelete(Integer id) {
        Optional<com.example.digishopkart.entity.Order> optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isPresent()) {
            com.example.digishopkart.entity.Order order = new com.example.digishopkart.entity.Order();
            order = optionalOrder.get();
            orderRepository.delete(order);
            return new ResponseEntity("Order cancelled successfully...!!!", HttpStatus.OK);
        } else {
            return new ResponseEntity("Please Enter valid order id...!!!", HttpStatus.NOT_FOUND);
        }
    }


    //--------------------------------------- API TO FETCH ALL ORDERS ---------------------------------------
    @Override
    public ResponseEntity<Order> fetchAllOrdersGet() {
        return new ResponseEntity(orderRepository.findAll(), HttpStatus.OK);
    }


    //--------------------------------------- API TO FETCH ORDER BY ID ---------------------------------------
    @Override
    public ResponseEntity<Order> fetchOrderByIdGet(Integer id) {
        Optional<com.example.digishopkart.entity.Order> optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isPresent()) {
            return new ResponseEntity(optionalOrder.get(), HttpStatus.FOUND);
        } else {
            return new ResponseEntity("Please Enter valid order id...!!!", HttpStatus.NOT_FOUND);
        }
    }
    //--------------------------------------- API TO UPDATE ORDER ---------------------------------------
    @Override
    public ResponseEntity<Order> updateOrderByIdPatch(Integer id, Order body) {
        Optional<com.example.digishopkart.entity.Order> optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isPresent()) {
            body.setActivatedAt(optionalOrder.get().getActivatedAt());
            body.setProductName(optionalOrder.get().getProductName());
            return new ResponseEntity(orderRepository.save(orderMapper
                    .OrderModelToOrderEntity(body)), HttpStatus.OK);
        } else {
            return new ResponseEntity("Please Enter valid order id...!!!", HttpStatus.NOT_FOUND);
        }
    }
}
