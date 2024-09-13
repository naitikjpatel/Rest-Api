package com.entity;

import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "products")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer productId;
	String productName;
	Float price;
	String category;
	Integer qty;
	@Override
	public String toString() {
		return "ProductEntity [productId=" + productId + ", productName=" + productName + ", price=" + price
				+ ", category=" + category + ", qty=" + qty + "]";
	}
	
	
	
}
