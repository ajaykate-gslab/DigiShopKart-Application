package com.example.digishopkart.repository;

import com.example.digishopkart.controller.DiscountController;
import com.example.digishopkart.entity.Discount;
import com.example.digishopkart.mapper.DiscountMapper;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class DiscountRepositoryTest {

    @Autowired
    private DiscountRepository discountRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private DiscountController discountController;
    @Autowired
    private DiscountMapper discountMapper;
   /* @BeforeClass
    public static void init() {
        Discount discount=new Discount();
        discount.setDiscountId(1);
        discount.setDiscountType(com.example.digishopkart.model.Discount.DiscountTypeEnum.FLAT);
        discount.setCouponName("FLAT100");
        discount.setCouponValue(100.0);

        //EntityManager.merge(discount);
    }*/

    @Test
    @Order(1)
    public void saveDiscountTest(){
        Discount discount=Discount.builder()
                .id(3)
                .couponName("FLAT100")
                .couponValue(100.0)
                .discountType(com.example.digishopkart.model.Discount.DiscountTypeEnum.FLAT)
                .build();

        //discountController.createDiscount(discountMapper.DiscountEntityToDiscountModel(discount));

        discountRepository.save(discount);
        System.out.println(discount);
        Assertions.assertThat(discount.getId()).isGreaterThan(3);
    }

    @Test
    @Order(2)
    public void getDiscountTest(){
        Discount discount = discountRepository.findById(1).get();
        Assertions.assertThat(discount.getId()).isEqualTo(1);
    }

    /*@Test
    @Rollback(value = false)
    public void testCreateDiscount(){
        Discount discount =new Discount(1,"FLAT100",com.example.digishopkart.model.Discount.DiscountTypeEnum.FLAT,100.0);
        com.example.digishopkart.model.Discount savedDiscount = discountRepository.save(discount);
        assertNotNull(savedDiscount);
    }
*/
}
