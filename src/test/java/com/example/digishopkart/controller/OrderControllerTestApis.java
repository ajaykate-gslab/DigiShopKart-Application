package com.example.digishopkart.controller;

import com.example.digishopkart.entity.*;
import com.example.digishopkart.mapper.OrderMapper;
import com.example.digishopkart.repository.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderControllerTestApis {
    @Autowired
    private OrderController orderController;
    @Autowired
    private OrderMapper orderMapper;
    @MockBean
    private OrderRepository orderRepository;
    Order order= new Order();
    int orderId=1;

    public static Order getOrderObject(){
        CustomerAddress customerAddress = new CustomerAddress(1, com.example.digishopkart.model.CustomerAddress.AddressTypeEnum.SHIPPING, "Ajay kate", "India","MH", "Pune", "kharadi", "abc123","near XYZ", 411014, "1234567890");
        List<CustomerAddress> customerAddressList = new ArrayList<CustomerAddress>();
        customerAddressList.add(customerAddress);
        Customer customer = new Customer(1, "Ajay", "Kate", "ajay@gmail.com", "0987654321", com.example.digishopkart.model.Customer.CustomerStatusEnum.ACTIVE,customerAddressList);

        Variant variant = new Variant(1,"size","L",com.example.digishopkart.model.Variant.StatusEnum.ACTIVE);
        List<Variant> variantList = new ArrayList<Variant>();
        variantList.add(variant);
        Product product = new Product(1,"Cotton T-Shirt","Allen Solly",1200.0, com.example.digishopkart.model.Product.ProductStatusEnum.ACTIVE, com.example.digishopkart.model.Product.ProductCategoryEnum.CLOTHS,variantList);
        List<Product> productList =new ArrayList<Product>();
        productList.add(product);

        Discount discount=new Discount(1,"FLAT100", com.example.digishopkart.model.Discount.DiscountTypeEnum.FLAT,100.0);

        Order order =new Order(1,"activated","updated",1200.0, com.example.digishopkart.model.Order.OrderStatusEnum.CONFIRMED,customer,productList,discount);
        return order;
    }


    @Test  //check
    public void CreateOrderTest(){
        order = getOrderObject();
        when(orderRepository.save(order)).thenReturn(order);
        assertEquals(order,orderController.createOrder(orderMapper.OrderEntityToOrderModel(order)).getBody());
    }
    @Test
    public void fetchOrderTest(){
        order = getOrderObject();
        when(orderRepository.findById(orderId)).thenReturn(Optional.of(order));
        assertEquals(order,orderController.fetchOrder(orderId).getBody());
    }

    @Test
    public void fetchAllOrdersTest(){
        order= getOrderObject();
        List<Order> orderList=new ArrayList<Order>();
        orderList.add(order);
        when(orderRepository.findAll()).thenReturn(Stream.of(order).collect(Collectors.toList()));
        assertEquals(orderList,orderController.fetchAllOrders().getBody());
    }

    @Test //check
    public void deleteOrderTest(){
        order =getOrderObject();
        when(orderRepository.findById(orderId)).thenReturn(Optional.of(order));
        assertEquals(order,orderController.deleteOrder(orderId).getBody());

    }

    @Test //check
    public void updateOrderTest(){

    }

}
