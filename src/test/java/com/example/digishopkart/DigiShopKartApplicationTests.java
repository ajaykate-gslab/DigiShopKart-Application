package com.example.digishopkart;

import com.example.digishopkart.controller.DiscountController;
import com.example.digishopkart.entity.Discount;
import com.example.digishopkart.mapper.DiscountMapper;
import com.example.digishopkart.repository.CustomerRepository;
import com.example.digishopkart.repository.DiscountRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DigiShopKartApplicationTests {

	@Autowired
	private DiscountRepository discountRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private DiscountController discountController;
	@Autowired
	private DiscountMapper discountMapper;

	@Test
	void contextLoads() {
	}

	@Test
	public void saveDiscountTest(){
		Discount discount=Discount.builder()
				.id(1)
				.couponName("FLAT100")
				.couponValue(100.0)
				.discountType(com.example.digishopkart.model.Discount.DiscountTypeEnum.FLAT)
				.build();

		//discountController.createDiscount(discountMapper.DiscountEntityToDiscountModel(discount));

		discountRepository.save(discount);
		System.out.println(discount);
		Assertions.assertThat(discount.getId()).isGreaterThan(0);
	}

	@Test
	@Order(2)
	public void getDiscountTest(){
		Discount discount = discountRepository.findById(1).get();
		System.out.println(discount);
		Assertions.assertThat(discount.getId()).isEqualTo(1);
	}
}
