package com.casestudy.practise.orders.service;

import java.util.List;  
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.casestudy.practise.orders.model.Address;
import com.casestudy.practise.orders.model.Cart;
import com.casestudy.practise.orders.model.Orders;
import com.casestudy.practise.orders.model.Product;
import com.razorpay.RazorpayException;

//interface for order service layer
@Service
public interface OrderService {
	
	List<Orders> getAllOrders();
	void placeOrder(Cart cart,String mode,String email);
	String changeStatus(String status ,int orderId);
	void deleteOrder(int orderId);
	List<Orders> getOrderByCustomerId(int customerId);
	void storeAddress(Address address);
	List<Address> getAddressByCustomerId(int customerId);
	List<Address> getAllAddress();
	Orders getOrderById(int orderId);
	String onlinePayment(Cart cart) throws RazorpayException;
	
	List<Orders> findOrderByFullName(String fullName);
	

}
