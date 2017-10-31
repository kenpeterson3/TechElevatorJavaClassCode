package com.techelevator.model.viewmodel;

import java.util.List;

import com.techelevator.model.Order;
import com.techelevator.model.OrderItem;
import com.techelevator.model.Product;

public class ConfirmationViewModel {

	private Order order;
	private List<OrderItem> orderItems;
	private List<Product> products;
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
