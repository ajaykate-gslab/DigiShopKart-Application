package com.example.digishopkart.controller;

import com.example.digishopkart.entity.*;
import com.example.digishopkart.mapper.OrderMapper;
import com.example.digishopkart.model.Customer;
import com.example.digishopkart.model.Discount;
import com.example.digishopkart.model.Order;
import com.example.digishopkart.model.Product;
import com.example.digishopkart.repository.CustomerRepository;
import com.example.digishopkart.repository.DiscountRepository;
import com.example.digishopkart.repository.OrderRepository;
import com.example.digishopkart.repository.ProductRepository;
import org.aspectj.weaver.ast.Or;
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
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderControllerTestApis {
    @Autowired
    private OrderController orderController;
    @Autowired
    private CustomerController customerController;
    @Autowired
    private DiscountController discountController;
    @Autowired
    private ProductController productController;
    @Autowired
    private OrderMapper orderMapper;
    @MockBean
    private OrderRepository orderRepository;
    @MockBean
    private CustomerRepository customerRepository;
    @MockBean
    private DiscountRepository discountRepository;
    @MockBean
    private ProductRepository productRepository;
    OrderEntity orderEntity = new OrderEntity();
    int orderId=1;

    public static OrderEntity getOrderEntity(){
        CustomerAddressEntity customerAddressEntity = new CustomerAddressEntity(1, com.example.digishopkart.model.CustomerAddress.AddressTypeEnum.SHIPPING, "Ajay kate", "India","MH", "Pune", "kharadi", "abc123","near XYZ", 411014, "1234567890");
        List<CustomerAddressEntity> customerAddressEntityList = new ArrayList<CustomerAddressEntity>();
        customerAddressEntityList.add(customerAddressEntity);
        CustomerEntity customerEntity = new CustomerEntity(1, "Ajay", "Kate", "ajay@gmail.com", "0987654321", com.example.digishopkart.model.Customer.CustomerStatusEnum.ACTIVE, customerAddressEntityList);

        VariantEntity variantEntity = new VariantEntity(1,"size","L",com.example.digishopkart.model.Variant.StatusEnum.ACTIVE);
        List<VariantEntity> variantEntityList = new ArrayList<VariantEntity>();
        variantEntityList.add(variantEntity);
        ProductEntity productEntity = new ProductEntity(1,"Cotton T-Shirt","Allen Solly",1200.0, com.example.digishopkart.model.Product.ProductStatusEnum.ACTIVE, com.example.digishopkart.model.Product.ProductCategoryEnum.CLOTHS, variantEntityList);
        List<ProductEntity> productEntityList =new ArrayList<ProductEntity>();
        productEntityList.add(productEntity);

        DiscountEntity discountEntity =new DiscountEntity(1,"FLAT100", com.example.digishopkart.model.Discount.DiscountTypeEnum.FLAT,100.0);

        OrderEntity orderEntity =new OrderEntity(1,"03/03/2023","03/03/2023",1200.0, com.example.digishopkart.model.Order.OrderStatusEnum.CONFIRMED, customerEntity, productEntityList, discountEntity);
        return orderEntity;
    }

    public static Order getOrderDto(){
        Customer customerDto= CustomerControllerTestApis.getCustomerDto();
        Discount discountDto = DiscountControllerTestApis.getDiscountDto();
        Product productDto= ProductControllerTestApis.getProductDto();

        List<Product> productList=new ArrayList<Product>();
        productList.add(productDto);

        Order orderDto=new Order();
        orderDto.setOrderId(1);
        orderDto.setActivatedAt("01/01/2023");
        orderDto.setUpdatedAt("03/03/2023");
        orderDto.setOrderStatus(Order.OrderStatusEnum.CONFIRMED);
        orderDto.setCustomer(customerDto);
        orderDto.setDiscount(discountDto);
        orderDto.setProducts(productList);
        return orderDto;
    }


    // ----------- Test Case to CreateOrder Api -------------------
    //@Test  //check
    public void CreateOrderTest(){
        orderEntity = getOrderEntity();
        when(orderRepository.save(orderEntity)).thenReturn(orderEntity);

        //ResponseEntity<Order> response = orderController.createOrder()

        assertEquals(orderEntity,orderController.createOrder(orderMapper.OrderEntityToOrderModel(orderEntity)).getBody());
    }

    @Test
    public void createOrder_validInputs_returnsCreatedStatus() {
        Order orderDto = getOrderDto();
        Customer customerDto =orderDto.getCustomer();
        Discount discountDto = orderDto.getDiscount();
        List<Product> productList = orderDto.getProducts();

        OrderEntity orderEntity = getOrderEntity();
        CustomerEntity customerEntity = orderEntity.getCustomerEntity();
        DiscountEntity discountEntity = orderEntity.getDiscountEntity();
        List<ProductEntity> productEntityList = orderEntity.getProductEntities();

      /*  Optional<CustomerEntity> optionalCustomerEntity = Optional.of(customerEntity);
        Optional<DiscountEntity> optionalDiscountEntity = Optional.of(discountEntity);
        Optional<ProductEntity> optionalProductEntity = Optional.of(productEntityList.get(0));
*/
        when(customerRepository.findById(1)).thenReturn(Optional.of(customerEntity));
        when(discountRepository.findById(1)).thenReturn(Optional.of(discountEntity));
        when(productRepository.findById(1)).thenReturn(Optional.of(productEntityList.get(0)));
        when(orderRepository.save(orderEntity)).thenReturn(orderEntity);

        // Act
        ResponseEntity<Order> response = orderController.createOrder(orderDto);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        //assertEquals(orderDto,response.getBody());
    }

    @Test
    public void createOrder_invalidCustomer_returnsNotFoundStatus() {
        Order orderDto = getOrderDto();
        Customer customerDto =orderDto.getCustomer();
        Discount discountDto = orderDto.getDiscount();
        List<Product> productList = orderDto.getProducts();

        OrderEntity orderEntity = getOrderEntity();
        CustomerEntity customerEntity = orderEntity.getCustomerEntity();
        DiscountEntity discountEntity = orderEntity.getDiscountEntity();
        List<ProductEntity> productEntityList = orderEntity.getProductEntities();
        String expectedResult = "Please Enter valid Customer id";

        when(customerRepository.findById(1)).thenReturn(Optional.empty());
        when(productRepository.findById(1)).thenReturn(Optional.of(productEntityList.get(0)));
        when(discountRepository.findById(22)).thenReturn(Optional.of(discountEntity));

        ResponseEntity<Order> response = orderController.createOrder(orderDto);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(expectedResult, response.getBody());
    }

    @Test
    public void createOrder_invalidDiscount_returnsNotFoundStatus() {
        Order orderDto = getOrderDto();
        Customer customerDto =orderDto.getCustomer();
        Discount discountDto = orderDto.getDiscount();
        List<Product> productList = orderDto.getProducts();

        OrderEntity orderEntity = getOrderEntity();
        CustomerEntity customerEntity = orderEntity.getCustomerEntity();
        DiscountEntity discountEntity = orderEntity.getDiscountEntity();
        List<ProductEntity> productEntityList = orderEntity.getProductEntities();
        String expectedResult = "Please Enter valid Discount id";

        when(customerRepository.findById(1)).thenReturn(Optional.of(customerEntity));
        when(productRepository.findById(1)).thenReturn(Optional.of(productEntityList.get(0)));
        when(discountRepository.findById(1)).thenReturn(Optional.empty());

        ResponseEntity<Order> response = orderController.createOrder(orderDto);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(expectedResult, response.getBody());
    }

   // @Test
    public void createOrder_invalidProduct_returnsNotFoundStatus() {
        Order orderDto = getOrderDto();
        Customer customerDto =orderDto.getCustomer();
        Discount discountDto = orderDto.getDiscount();
        List<Product> productList = orderDto.getProducts();

        OrderEntity orderEntity = getOrderEntity();
        CustomerEntity customerEntity = orderEntity.getCustomerEntity();
        DiscountEntity discountEntity = orderEntity.getDiscountEntity();
        //List<ProductEntity> productEntityList = orderEntity.getProductEntities();
        String expectedResult = "Please Enter valid Product id";

        System.out.println(orderEntity.getProductEntities());
        when(customerRepository.findById(1)).thenReturn(Optional.of(customerEntity));
        when(discountRepository.findById(1)).thenReturn(Optional.of(discountEntity));
        when(productRepository.findById(22)).thenReturn(Optional.empty());
        when(orderRepository.save(orderEntity)).thenReturn(orderEntity);

        ResponseEntity<Order> response = orderController.createOrder(orderDto);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        //assertEquals(expectedResult, response.getBody());
    }
    @Test
    public void testFetchOrderReturnFound(){
        orderEntity = getOrderEntity();
        when(orderRepository.findById(orderId)).thenReturn(Optional.of(orderEntity));

        ResponseEntity<Order> response=orderController.fetchOrder(1);

        assertEquals(HttpStatus.FOUND,response.getStatusCode());
        assertEquals(orderEntity,response.getBody());
    }


    @Test
    public void testFetchOrderReturnNotFound(){
        orderEntity = getOrderEntity();
        when(orderRepository.findById(orderId)).thenReturn(Optional.empty());
        String expectedResult = "Please Enter Valid OrderId ...!!!";
        ResponseEntity<Order> response=orderController.fetchOrder(1);

        assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
        assertEquals(expectedResult,response.getBody());
    }


    // ----------- Test Case to FetchAllOrder Api -------------------
    @Test
    public void fetchAllOrdersTest(){
        orderEntity = getOrderEntity();
        List<OrderEntity> orderEntityList =new ArrayList<OrderEntity>();
        orderEntityList.add(orderEntity);
        when(orderRepository.findAll()).thenReturn(Stream.of(orderEntity).collect(Collectors.toList()));

        ResponseEntity<Order> response=orderController.fetchAllOrders();

        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertEquals(orderEntityList,response.getBody());
    }


    // ----------- Test Case to DeleteOrder Api -------------------
    @Test
    public void testDeleteOrder_WhenOrderFound(){
        int orderId=1;
        orderEntity = getOrderEntity();
        when(orderRepository.findById(orderId)).thenReturn(Optional.of(orderEntity));

        ResponseEntity<Order> response = orderController.deleteOrder(orderId);

        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertEquals(orderEntity,response.getBody());

    }

    @Test
    public void testDeleteOrder_WhenOrderNotFound(){
        int orderId=1;
        orderEntity = getOrderEntity();
        String expectedResult = "Please enter valid orderId ..!!!";

        when(orderRepository.findById(orderId)).thenReturn(Optional.empty());

        ResponseEntity<Order> response = orderController.deleteOrder(orderId);

        assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
        assertEquals(expectedResult,response.getBody());

    }

    // ----------- Test Case to UpdateOrderStatus Api -------------------
    @Test
    public void testUpdateOrderStatus_WhenOrderFound(){
        int orderId=1;
        orderEntity = getOrderEntity();
        Order orderDto = getOrderDto();

        when(orderRepository.findById(orderId)).thenReturn(Optional.of(orderEntity));
        orderEntity.setOrderStatus(Order.OrderStatusEnum.DELIVERED);

        when(orderRepository.save(orderEntity)).thenReturn(orderEntity);
        ResponseEntity<Order> response = orderController.updateOrderStatus(orderId,orderDto);

        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertEquals(orderEntity,response.getBody());

    }

    @Test
    public void testUpdateOrderStatus_WhenOrderNotFound(){
        int orderId=1;
        orderEntity = getOrderEntity();
        Order orderDto = getOrderDto();
        String expectedResult = "Please enter valid orderId to update status..!!!";
        when(orderRepository.findById(orderId)).thenReturn(Optional.empty());
        ResponseEntity<Order> response = orderController.updateOrderStatus(orderId,orderDto);

        assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
        assertEquals(expectedResult,response.getBody());

    }

    //--
    @Test
    public void testUpdateOrder() {
        int orderid =1;
        Order orderDto =getOrderDto();
        OrderEntity orderEntity=getOrderEntity();

        when(orderRepository.findById(1)).thenReturn(Optional.of(orderEntity));

        Order updatedorder = new Order();
        updatedorder = orderDto;
        updatedorder.setOrderStatus(Order.OrderStatusEnum.DELIVERED);

        ResponseEntity<Order> response =orderController.updateOrder(orderId,updatedorder);

        assertEquals(HttpStatus.OK,response.getStatusCode());
        //assertEquals(updatedorder,response.getBody());
    }

    @Test
    public void testUpdateOrder_WhenOrderNotFound() {
        int orderid =11;
        Order orderDto =getOrderDto();
        OrderEntity orderEntity=getOrderEntity();
        String expectedResult ="Please enter valid orderId to update Order...!!!";
        when(orderRepository.findById(orderid)).thenReturn(Optional.empty());

        Order updatedorder = new Order();
        updatedorder = orderDto;
        updatedorder.setOrderStatus(Order.OrderStatusEnum.DELIVERED);

        ResponseEntity<Order> response =orderController.updateOrder(orderId,updatedorder);

        assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
        assertEquals(expectedResult,response.getBody());
    }

}
