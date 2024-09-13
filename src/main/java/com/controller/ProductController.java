package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.ProductEntity;
import com.repository.ProductRepository;

@RestController
public class ProductController {

	@Autowired
	ProductRepository productRepository;
	
	
	// api
		// read product information and store into databse
	@PostMapping("/products")
	public ProductEntity addProduct(@RequestBody ProductEntity productEntity) {
		System.out.println(productEntity);
		productRepository.save(productEntity);
		return productEntity;
	}
}
