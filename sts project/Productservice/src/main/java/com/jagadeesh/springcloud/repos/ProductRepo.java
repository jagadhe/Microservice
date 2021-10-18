package com.jagadeesh.springcloud.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jagadeesh.springcloud.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
