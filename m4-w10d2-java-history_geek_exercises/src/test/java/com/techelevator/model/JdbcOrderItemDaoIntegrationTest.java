package com.techelevator.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.DAOIntegrationTest;
import com.techelevator.model.jdbc.JdbcOrderDAO;
import com.techelevator.model.jdbc.JdbcOrderItemDAO;
import com.techelevator.model.jdbc.JdbcProductDAO;
import com.techelevator.model.jdbc.JdbcUserDAO;

public class JdbcOrderItemDaoIntegrationTest extends DAOIntegrationTest  {

	private static OrderItemDAO dao;
	
	@Before
	public void setup() {
		dao = new JdbcOrderItemDAO(getDataSource());
	}
	
	@Before
	public void clearOrderItemTable() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		jdbcTemplate.update("DELETE FROM order_items");
	}
	
	@Test
	public void saves_and_reads_order_item() {
		UserDAO userDAO = new JdbcUserDAO(getDataSource());
		User user = new User();
		user.setEmail("larrye@oracle.com");
		user.setPassword("ImFantastic");
		userDAO.saveUser(user);

		OrderDAO orderDAO = new JdbcOrderDAO(getDataSource());
		Order order = new Order();
		order.setUserID(user.getID());
		order.setNameOnCard("Larry");
		order.setCreditCardNumber("1111111111");
		order.setExpirationDate("Never");
		order.setBillingAddress1("1234 Test Drive");
		order.setBillingAddress2("Side Street");
		order.setBillingCity("Redwood Shores");
		order.setBillingPostalCode("12345");
		order.setBillingState("CA");
		order.setShippingAddress1("9876 Drive Back Drive");
		order.setShippingAddress2("North Ave");
		order.setShippingCity("Grimmville");
		order.setShippingState("OR");
		order.setShippingPostalCode("43433");
		order.setShippingType("Fast");
		order.setSubTotal(new DollarAmount(120));
		order.setWeight(2.30);
		order.setShipping(new DollarAmount(340));
		order.setTax(new DollarAmount(560));
		orderDAO.saveOrder(order);

		ProductDAO productDAO = new JdbcProductDAO(getDataSource());
		List<Product> products = productDAO.getProducts();
		
		List<OrderItem> orderItems = new ArrayList<>();
		OrderItem orderItem = new OrderItem();
		orderItem.setOrderID(order.getId());
		orderItem.setProductID(products.get(0).getId());
		orderItem.setQuantity(10);
		orderItem.setPrice(products.get(0).getPrice());
		orderItems.add(orderItem);
		dao.saveOrderItems(orderItems);
		
		List<OrderItem> result = dao.getOrderItems(orderItems.get(0).getOrderID());
		
		assertNotNull(result);
		assertEquals(1, result.size());
		assertThat(orderItem, equalTo(result.get(0)));
	}
	
	private Matcher<OrderItem> equalTo(final OrderItem expected) {
		return new TypeSafeMatcher<OrderItem>() {

			public void describeTo(Description description) {
			}

			protected boolean matchesSafely(OrderItem orderItem) {
				return nullOrEqual(expected.getOrderID(), orderItem.getOrderID()) &&
						nullOrEqual(expected.getProductID(), orderItem.getProductID()) &&
						nullOrEqual(expected.getPrice(), orderItem.getPrice()) &&
						nullOrEqual(expected.getQuantity(), orderItem.getQuantity());
			}
			
			private boolean nullOrEqual(Object left, Object right) {
				return left != null ? left.equals(right) : right == null;
			}
		};
	}

}
