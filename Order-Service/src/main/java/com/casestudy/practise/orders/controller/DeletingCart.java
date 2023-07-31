package com.casestudy.practise.orders.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.casestudy.practise.orders.model.Cart;

@FeignClient(value = "cart-service",url ="http://localhost:8083/cart")
public interface DeletingCart {
	
	@DeleteMapping("/delete/{cartId}")
	public void deleteCart(@PathVariable int cartId);
}
