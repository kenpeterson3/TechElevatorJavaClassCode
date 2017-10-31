package com.techelevator.model;

public class ShoppingCartItem {

	private Product product;
	private int quantity;

	public ShoppingCartItem() {
	};

	public ShoppingCartItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public DollarAmount getPrice() {
		return product.getPrice().multipliedBy(quantity);
	}

	public double getWeight() {
		return product.getWeight() * quantity;
	}

}
