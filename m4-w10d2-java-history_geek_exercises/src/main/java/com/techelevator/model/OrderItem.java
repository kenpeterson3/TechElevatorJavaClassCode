package com.techelevator.model;

public class OrderItem {
	
	private Long orderID;
	private Long productID;
	private int quantity;
	private DollarAmount price;

	public long getOrderID() {
		return orderID;
	}
	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}
	public long getProductID() {
		return productID;
	}
	public void setProductID(long productID) {
		this.productID = productID;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public DollarAmount getPrice() {
		return price;
	}
	public void setPrice(DollarAmount price) {
		this.price = price;
	}
	
}
