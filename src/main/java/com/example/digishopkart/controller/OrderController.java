package com.example.digishopkart.controller;

import com.example.digishopkart.api.*;
import com.example.digishopkart.entity.CustomerEntity;
import com.example.digishopkart.entity.DiscountEntity;
import com.example.digishopkart.entity.OrderEntity;
import com.example.digishopkart.entity.ProductEntity;
import com.example.digishopkart.mapper.OrderMapper;
import com.example.digishopkart.model.Discount;
import com.example.digishopkart.model.Order;
import com.example.digishopkart.repository.CustomerRepository;
import com.example.digishopkart.repository.DiscountRepository;
import com.example.digishopkart.repository.OrderRepository;
import com.example.digishopkart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@Component
public class OrderController implements OrderApi {

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
    public ResponseEntity<Order> createOrder(Order body) {

        List<ProductEntity> productEntityList = new ArrayList<ProductEntity>();
        Optional<ProductEntity> optionalProduct = null;

        Optional<CustomerEntity> optionalCustomer = customerRepository.findById(body.getCustomer().getId());
        Optional<DiscountEntity> optionalDiscount = discountRepository.findById(body.getDiscount().getId());

        int numberOfProducts = body.getProducts().size();
        for (int i = 0; i < numberOfProducts; i++) {
            optionalProduct = productRepository.findById(body.getProducts().get(i).getId());
            productEntityList.add(optionalProduct.get());
        }

        OrderEntity orderEntity = new OrderEntity();
        double price = 0;
        if (optionalCustomer.isPresent()) {
            if (optionalProduct.isPresent()) {
                if (optionalDiscount.isPresent()) {
                    orderEntity.setCustomerEntity(optionalCustomer.get());
                    orderEntity.setProductEntities(productEntityList);
                    orderEntity.setDiscountEntity(optionalDiscount.get());

                    LocalDateTime localDateTime = LocalDateTime.now();
                    org.threeten.bp.format.DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy 'at' hh:mm a");
                    String currentDate = dateTimeFormatter.format(localDateTime);

                    orderEntity.setActivatedAt(currentDate);
                   orderEntity.setUpdatedAt(currentDate);
                    orderEntity.setOrderStatus(body.getOrderStatus());
                    if (optionalDiscount.get().getDiscountType().equals(Discount.DiscountTypeEnum.FLAT)) {
                        for (int i = 0; i < numberOfProducts; i++) {
                            optionalProduct = productRepository.findById(body.getProducts().get(i).getId());
                            price = optionalProduct.get().getProductPrice() + price;
                        }

                        price = price - optionalDiscount.get().getCouponValue();
                        orderEntity.setTotalPrice(price);
                    } else if (optionalDiscount.get().getDiscountType().equals(Discount.DiscountTypeEnum.PERCENTAGE)) {
                        for (int i = 0; i < numberOfProducts; i++) {
                            optionalProduct = productRepository.findById(body.getProducts().get(i).getId());
                            price = optionalProduct.get().getProductPrice() + price;
                        }
                        price = price- price * (optionalDiscount.get().getCouponValue() / 100);
                        orderEntity.setTotalPrice(price);
                    }

                    return new ResponseEntity(orderRepository.save(orderEntity), HttpStatus.CREATED);
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
    public ResponseEntity<Order> deleteOrder(Integer orderId) {
        Optional<OrderEntity> optionalOrder = orderRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            orderRepository.deleteById(orderId);
            return new ResponseEntity(optionalOrder.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity("Please enter valid orderId ..!!!", HttpStatus.NOT_FOUND);
        }
    }

    //--------------------------------------- API TO FETCH ALL ORDERS ---------------------------------------
    @Override
    public ResponseEntity<Order> fetchAllOrders() {
        return new ResponseEntity(orderRepository.findAll(), HttpStatus.OK);
    }

    //--------------------------------------- API TO FETCH ORDER BY ID ---------------------------------------
    @Override
    public ResponseEntity<Order> fetchOrder(Integer orderId) {
        Optional<OrderEntity> optionalOrder = orderRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            return new ResponseEntity(optionalOrder.get(), HttpStatus.FOUND);
        } else {
            return new ResponseEntity("Please Enter Valid OrderId ...!!!", HttpStatus.NOT_FOUND);
        }
    }


    //--------------------------------------- API TO UPDATE ORDER ---------------------------------------
    @Override
    public ResponseEntity<Order> updateOrder(Integer orderId, Order body) {
        Optional<ProductEntity> optionalProduct = null;
        Optional<CustomerEntity> optionalCustomer = customerRepository.findById(body.getCustomer().getId());
        Optional<DiscountEntity> optionalDiscount = discountRepository.findById(body.getDiscount().getId());
        int numberOfProducts = body.getProducts().size();
        double price = 0;
        OrderEntity orderEntity = new OrderEntity();
        Optional<OrderEntity> optionalOrder = orderRepository.findById(orderId);

        orderEntity = orderMapper.OrderModelToOrderEntity(body);

        if (optionalOrder.isPresent()) {
            if (body.getDiscount().getDiscountType().equals(com.example.digishopkart.model.Discount.DiscountTypeEnum.FLAT)) {
                for (int i = 0; i < numberOfProducts; i++) {
                    //optionalProduct = productRepository.findById(body.getProducts().get(i).getProductId());
                    price = body.getProducts().get(i).getProductPrice() + price;
                }

                price = price - body.getDiscount().getCouponValue();
                orderEntity.setTotalPrice(price);
            } else if (body.getDiscount().getDiscountType().equals(com.example.digishopkart.model.Discount.DiscountTypeEnum.PERCENTAGE)) {
                for (int i = 0; i < numberOfProducts; i++) {
                    // optionalProduct = productRepository.findById(body.getProducts().get(i).getProductId());
                    price = body.getProducts().get(i).getProductPrice() + price;

                }
                price = price - price * (body.getDiscount().getCouponValue() / 100);
                orderEntity.setTotalPrice(price);
            }

            LocalDateTime localDateTime = LocalDateTime.now();
            org.threeten.bp.format.DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy 'at' hh:mm a");
            String currentDate = dateTimeFormatter.format(localDateTime);
            orderEntity.setUpdatedAt(currentDate);

            return new ResponseEntity(orderRepository.save(orderEntity), HttpStatus.OK);
        } else {
            return new ResponseEntity("Please enter valid orderId to update Order...!!!", HttpStatus.NOT_FOUND);
        }
    }

    //--------------------------------------- API TO UPDATE ORDER STATUS ---------------------------------------
    @Override
    public ResponseEntity<Order> updateOrderStatus(Integer orderId, Order body) {
        Optional<OrderEntity> optionalOrder = orderRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            OrderEntity orderEntity = optionalOrder.get();
            orderEntity.setOrderStatus(body.getOrderStatus());

            LocalDateTime localDateTime = LocalDateTime.now();
            org.threeten.bp.format.DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy 'at' hh:mm a");
            String currentDate = dateTimeFormatter.format(localDateTime);
            orderEntity.setUpdatedAt(currentDate);
            return new ResponseEntity(orderRepository.save(orderEntity), HttpStatus.OK);
        } else {
            return new ResponseEntity("Please enter valid orderId to update status..!!!", HttpStatus.NOT_FOUND);
        }
    }

}
