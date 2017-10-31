package com.techelevator.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ShoppingCartTest {

	@Test
	public void add_item_to_shopping_cart_and_check_subtotal() {
		Product product = new Product();
		product.setId(1234567890L);
		product.setSku("TEST-SKU");
		product.setName("Test Product");
		product.setDescription("Test Description");
		product.setImageName("Test ImageName");
		product.setPrice(new DollarAmount(9876));
		product.setWeight(3);
		product.setActive(true);
		ShoppingCart sc = new ShoppingCart();
		sc.addToCart(product, 3);
		assertEquals(new DollarAmount(29628), sc.getSubTotal());
	}

}
