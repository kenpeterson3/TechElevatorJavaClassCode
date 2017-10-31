package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	
	public List<ShoppingCartItem> items = new ArrayList<>();

	public List<ShoppingCartItem> getItems() {
		return items;
	}

	public void setItems(List<ShoppingCartItem> items) {
		this.items = items;
	}
	
	public void empty() {
		items.clear();
	}
    
    /**
     *  Adds a product to the shopping cart. If it is already in the cart, updates the quantity.
     * @param product
     * @param quantity
     */
	public void addToCart(Product product, int quantity) {
		ShoppingCartItem existingItem = null;
		for (ShoppingCartItem item : items) {
			if (item.getProduct().getSku().equals(product.getSku())) {
				existingItem = item;
				break;
			}
		}
		if (existingItem == null) {
			items.add(new ShoppingCartItem(product, quantity));
		} else {
			existingItem.setQuantity(existingItem.getQuantity() + quantity);
		}
	}

    /**
     *  Get the subtotal of all items in the shopping cart.
     * @return
     */
	public DollarAmount getSubTotal() {
		DollarAmount subTotal = new DollarAmount(0);
		for (ShoppingCartItem item : items) {
			subTotal = subTotal.plus(item.getPrice());
		}
		return subTotal;
	}

}
