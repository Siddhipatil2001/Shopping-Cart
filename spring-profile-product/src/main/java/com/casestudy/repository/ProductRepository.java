package com.casestudy.repository;

import java.util.List; 
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.entities.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, Integer> {
	
	public Optional<Product> findByProductName(String productName);

	public List<Product> findByCategory(String category);

	public List<Product> findByProductType(String producType);
}
