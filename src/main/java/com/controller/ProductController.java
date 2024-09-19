package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	//read all products infromation
	@GetMapping("/getproducts")
	public List<ProductEntity> getAllProducts(){
		
		List<ProductEntity> products=productRepository.findAll();
		return products;
		
	}
	
	//get Product by id using pathVariable
	@GetMapping("/getproducts/{productId}")
	public ProductEntity getProductById(@PathVariable("productId") Integer productId) {
	 Optional<ProductEntity> optional=	productRepository.findById(productId);
	 if(optional.isEmpty()) {
		 return null;
	 }else {
		 ProductEntity productEntity=optional.get();
		 return productEntity;
	 }}
	 
	 

		//get Product by id using query parameter
		@GetMapping("/getproduct")
		public ProductEntity getProductById2(@RequestParam("productId") Integer productId) {
		 Optional<ProductEntity> optional=	productRepository.findById(productId);
		 if(optional.isEmpty()) {
			 return null;
		 }else {
			 ProductEntity entity=optional.get();
			 return entity;
		 }
	}
}
