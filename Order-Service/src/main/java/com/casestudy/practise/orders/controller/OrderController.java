package com.casestudy.practise.orders.controller;

import java.util.List;   


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.practise.orders.model.Address;
import com.casestudy.practise.orders.model.Cart;
import com.casestudy.practise.orders.model.Items;
import com.casestudy.practise.orders.model.Orders;
import com.casestudy.practise.orders.service.OrderService;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;


@RestController
@RequestMapping("/order")
@CrossOrigin(origins="*",maxAge = 3600)
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private PlacingOrder pl;
	
	@Autowired
	private DeletingCart dl;
	
	OrderController(){
		
	}
	
	//get all placed orders
	@GetMapping("/getAll")
	public List<Orders> getAllOrders(){
		return orderService.getAllOrders();
		
	}
	
	//get all address
	@GetMapping("/getAllAddress")
	public List<Address> getAllAddress(){
		return orderService.getAllAddress();
	}
	
	//get order by customer Id
	@GetMapping("/getOrderByCust/{customerId}")
	public List<Orders> getOrderByCustomerId(int customerId){
		return orderService.getOrderByCustomerId(customerId);
		
	}
	//get address by  customer by id
	@GetMapping("/getAddByCust/{customerId}")
	public List<Address> getAddressByCustomerId(int customerId) {
		return orderService.getAddressByCustomerId(customerId);
	}
	
	//place order for customer with fullName
	@PostMapping("/placeOrder/{mode}/{email}")
	public String placeOrder(@RequestBody Cart cart ,@PathVariable String mode,@PathVariable String email) {
		
		List<Items> i = cart.getItems();
		
		for(Items ac:i) {
			pl.decreaseItem(ac.getProductId(), ac.getQuantity());
		}
		
		
		orderService.placeOrder(cart, mode, email);
		
		dl.deleteCart(cart.getCartId());
		return "Order placed";
		
		
	}
	
	
	//add address for order
	@PostMapping("/addAddress")
	public void storeAddress(@RequestBody Address address) {
		orderService.storeAddress(address);
	}
	
	//change status for confirmed status
	@PutMapping("/changeStatus/{orderId}")
	public void changeOrderStatus(@RequestBody String status, @PathVariable int orderId) {
		orderService.changeStatus(status, orderId);
	}
	
	//delete order by orderId
	@DeleteMapping("/deleteOrder/{orderId}")
	public ResponseEntity<String> deleteOrder(@PathVariable int orderId){
		orderService.deleteOrder(orderId);
		return  ResponseEntity.ok("Your order is deleted with"+ orderId);
	}
	
	//get order by customer fullName
	@GetMapping("/getOrderByFullName/{fullName}")
	public List<Orders> getOrderByfullName(@PathVariable String fullName){
		return orderService.findOrderByFullName(fullName);
		
	}
	
	@PostMapping("/pay")
	public String onlinePayment(@RequestBody Cart cart) throws RazorpayException {
			
		return orderService.onlinePayment(cart);
 }
	

}
