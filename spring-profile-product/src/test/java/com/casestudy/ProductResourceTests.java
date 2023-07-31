package com.casestudy;

import static org.junit.jupiter.api.Assertions.assertEquals; 
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.casestudy.controller.ProductController;
import com.casestudy.entities.Product;
import com.casestudy.service.ProductService;

@SpringBootTest(classes= {ProductResourceTests.class})
public class ProductResourceTests {
	
	//to inject mocks without calling Mockito.mocks manually
	@Mock
	ProductService productService;
	
	@InjectMocks 
	ProductController productResource;
	
	
	List<Product> products;
	Product product;
	
	@Test
	@Order(1)
	public void test_getAllProducts() {
		
		products= new ArrayList<Product>();
		products.add((new  Product(1, "pants", "killer", "sports","5", "ok",
				"img", 45, "Merchant", "abc@123",10)));
		products.add((new  Product(2, "shirts", "Arrow", "formal","5", "ok",
				"img", 450, "Merchant", "abc@123",20)));
		
		when(productService.getAllProducts()).thenReturn(products);
		
		List<Product> result=productResource.getAllProducts();
		
		assertEquals(2,result.size() );
	}
	
	
	@Test
	@Order(2)
	public void test_getProductById() {
		
		
		product= new  Product(1, "pants", "killer", "sports","5", "ok",
				"img", 45, "Merchant", "abc@123",20);
		
		int productId=1;
	
		
		when(productService.getProductById(productId)).thenReturn(product);
		
		
		ResponseEntity<Product> result=productResource.getProductById(productId);
		
		assertEquals(HttpStatus.OK,result.getStatusCode() );
		assertEquals(productId, result.getBody().getProductId());
	}
	
	@Test
	@Order(3)
	public void test_addProduct() {
			
		product= new  Product(1, "pants", "killer", "sports","5", "ok",
				"img", 45, "Merchant", "abc@123",20);
		
		when(productService.addProduct(product)).thenReturn(product);
		ResponseEntity<Product> result= productResource.addProducts(product);
		
		assertEquals(HttpStatus.CREATED, result.getStatusCode());
		assertEquals(product, result.getBody());
	}
	
	
	@Test
	@Order(4)
	public void test_updateProduct() {			
		product = new  Product(1, "pants", "killer", "sports","5", "ok",
				"img", 45, "Merchant", "abc@123",20);
		
		int productId=1;
	
		
		when(productService.getProductById(productId)).thenReturn(product);
		when(productService.updateProducts(productId,product)).thenReturn(product);
		
		
		ResponseEntity<Product> result= productResource.updateProduct(productId,product);
		
	assertEquals(HttpStatus.OK, result.getStatusCode());
	assertEquals("killer", result.getBody().getProductName());
		assertEquals(productId, result.getBody().getProductId());
	}
	
	
	

	
	@Test
	@Order(6)
	public void test_getProductByProductName() {
		
		
		product= new  Product(1, "pants", "killer", "sports","5", "ok",
				"img", 45, "Merchant", "abc@123",20);
		
		String productName="killer";
	
		
		when(productService.getProductByName(productName)).thenReturn(product);
		
		
		ResponseEntity<Product> result=productResource.getProductByName(productName);
		
		assertEquals(HttpStatus.OK,result.getStatusCode() );
		assertEquals(productName, result.getBody().getProductName());
	}
	
	@Test
	@Order(7)
	public void test_getProductByProductCategory() {
		
		products= new ArrayList<Product>();
		product= new  Product(1, "pants", "adidas", "sports","5", "ok",
				"img", 45, "Merchant", "abc@123",20);
		
		products.add(product);
		
		String productCategory="sports";
	
		
		when(productService.getProductByCategory(productCategory)).thenReturn(products);
		
		
		ResponseEntity<List<Product>> result=productResource.getProductByCategory(productCategory);
		
		assertEquals(HttpStatus.OK,result.getStatusCode() );
		assertEquals(products, result.getBody());
	}
	
	@Test
	@Order(8)
	public void test_getProductByProductType() {
		
		products= new ArrayList<Product>();
		product= new  Product(1, "pants", "killer", "sports","5", "ok",
				"img", 45, "Merchant", "abc@123",20);
		
		products.add(product);
		
		String productType="pants";
	
		
		when(productService.getProductByType(productType)).thenReturn(products);
		
		
		ResponseEntity<List<Product>> result=productResource.getProductByType(productType);
		
		assertEquals(HttpStatus.OK,result.getStatusCode() );
		assertEquals(products, result.getBody());
	}

}
