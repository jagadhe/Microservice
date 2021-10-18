package com.jagadeesh.springcloud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jagadeesh.springcloud.model.Coupon;
import com.jagadeesh.springcloud.model.Product;
import com.jagadeesh.springcloud.repos.ProductRepo;
import com.jagadeesh.springcloud.restclients.CouponClient;

@RestController
@RequestMapping("/productapi")
public class ProductRestController {
	@Autowired
	CouponClient couponClient;
	
	@Autowired
	 private ProductRepo repo;
	
	@RequestMapping(value ="/products",method = RequestMethod.POST)
	public Product create(@RequestBody Product product) {
		Coupon coupon=couponClient.getCoupon(product.getCouponCode());
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
		return repo.save(product);
		
	}

}
