package com.casestudy.practise.orders.model;

import java.time.LocalDate;
import java.util.List;



import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Document(collection = "Orders")
public class Orders {
	
	@Transient
	public  static final String SEQUENCE_NAME="OrderSequence";
	
	@Id
	private int orderId;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate orderDate;
	
	private int customerId;
	public Orders(int orderId, LocalDate orderDate, int customerId, double ammountPaid, int totalPrice,
			String modeOfPayment, String orderStatus, int quantity, String fullName, String email, Address address,
			String add) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.customerId = customerId;
		this.ammountPaid = ammountPaid;
		this.totalPrice = totalPrice;
		this.modeOfPayment = modeOfPayment;
		this.orderStatus = orderStatus;
		this.quantity = quantity;
		this.fullName = fullName;
		this.email = email;
		this.address = address;
		this.add = add;
	}
	private double ammountPaid;
	private int totalPrice;
	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}
	private String modeOfPayment;
	private String orderStatus;
	private int quantity;   // quantity must decrease after ordering
	private String fullName;
	private String email;
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	private Address address;
	private String add;
	
	
	
	
	
	
//	public Orders(int orderId, LocalDate orderDate, Integer customerId, double ammountPaid, String modeOfPayment,
//			String orderStatus, int quantity, String fullName, String email, Address address) {
//		super();
//		this.orderId = orderId;
//		this.orderDate = orderDate;
//		this.customerId = customerId;
//		this.ammountPaid = ammountPaid;
//		this.modeOfPayment = modeOfPayment;
//		this.orderStatus = orderStatus;
//		this.quantity = quantity;
//		this.fullName = fullName;
//		this.email = email;
//		this.address = address;
//	}

	public Orders() {
	
	}
	
	
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public double getAmmountPaid() {
		return ammountPaid;
	}
	public void setAmmountPaid(double ammountPaid) {
		this.ammountPaid = ammountPaid;
	}
	public String getModeOfPayment() {
		return modeOfPayment;
	}
	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}
	//sequence genrator for orderId




	

}