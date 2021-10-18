package com.jagadeesh.springcloud;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.jagadeesh.springcloud.model.Coupon;
import com.jagadeesh.springcloud.repos.CouponRepo;
@RunWith(SpringRunner.class)
@SpringBootTest
class CouponserviceApplicationTests {
	@Autowired
	private CouponRepo couponRepo;
	private RestTemplate restTemplate;
	
	@Test
public void testgetdetails() {
		
		restTemplate = new RestTemplate();
		Coupon object = restTemplate.getForObject("http://localhost:8080/couponapi/coupons/SUPERSALE",Coupon.class);
		assertNotNull(object);

}
	@Test
	public void testcreateDetails() {
		RestTemplate restTemplate = new RestTemplate();
		Coupon coupon= new Coupon();
		coupon.setCode("MEGASALE");
		coupon.setDiscount(new BigDecimal(20.00));
		coupon.setExpDate("14/10/2021");
		
		Object newDetail = restTemplate.postForObject("http://localhost:8080/couponapi/coupons",coupon, Coupon.class);
		assertNotNull(newDetail);
		assertNotNull(coupon.getId());
	
		
		
	}
	
}