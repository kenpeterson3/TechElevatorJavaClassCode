package com.techelevator.model;

import static org.junit.Assert.*;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.DAOIntegrationTest;
import com.techelevator.model.jdbc.JdbcOrderDAO;
import com.techelevator.model.jdbc.JdbcUserDAO;

public class JdbcOrderDaoIntegrationTest extends DAOIntegrationTest  {

	private static OrderDAO dao;
	
	@Before
	public void setup() {
		dao = new JdbcOrderDAO(getDataSource());
	}
	
	@Test
	public void saves_and_reads_one_order() {
		UserDAO userDAO = new JdbcUserDAO(getDataSource());
		User user = new User();
		user.setEmail("larrye@oracle.com");
		user.setPassword("ImFantastic");
		userDAO.saveUser(user);
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

		dao.saveOrder(order);
		Order result = dao.getOrder(order.getId());
		
		assertNotNull(result);
//		assertThat(result, equalTo(order));
	}
	
	private Matcher<Order> equalTo(final Order expected) {
		return new TypeSafeMatcher<Order>() {

			public void describeTo(Description description) {
			}

			protected boolean matchesSafely(Order order) {
				return nullOrEqual(expected.getId(), order.getId()) &&
						nullOrEqual(expected.getUserID(), order.getUserID()) &&
						nullOrEqual(expected.getNameOnCard(), order.getNameOnCard()) &&
						nullOrEqual(expected.getCreditCardNumber(), order.getCreditCardNumber()) &&
						nullOrEqual(expected.getExpirationDate(), order.getExpirationDate()) &&
						nullOrEqual(expected.getBillingAddress1(), order.getBillingAddress1()) &&
						nullOrEqual(expected.getBillingAddress2(), order.getBillingAddress2()) &&
						nullOrEqual(expected.getBillingCity(), order.getBillingCity()) &&
						nullOrEqual(expected.getBillingState(), order.getBillingState()) &&
						nullOrEqual(expected.getBillingPostalCode(), order.getBillingPostalCode()) &&
						nullOrEqual(expected.getShippingAddress1(), order.getShippingAddress1()) &&
						nullOrEqual(expected.getShippingAddress2(), order.getShippingAddress2()) &&
						nullOrEqual(expected.getShippingCity(), order.getShippingCity()) &&
						nullOrEqual(expected.getShippingState(), order.getShippingState()) &&
						nullOrEqual(expected.getShippingPostalCode(), order.getShippingPostalCode()) &&
						nullOrEqual(expected.getShippingType(), order.getShippingType()) &&
						nullOrEqual(expected.getSubTotal(), order.getSubTotal()) &&
						nullOrEqual(expected.getWeight(), order.getWeight()) &&
						nullOrEqual(expected.getShipping(), order.getShipping()) &&
						nullOrEqual(expected.getTax(), order.getTax()) &&
						nullOrEqual(expected.getShippingRates(), order.getShippingRates());
			}
			
			private boolean nullOrEqual(Object left, Object right) {
				return left != null ? left.equals(right) : right == null;
			}
		};
	}

}
