package com.techelevator.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.DollarAmount;
import com.techelevator.model.Order;
import com.techelevator.model.OrderDAO;

@Component
public class JdbcOrderDAO implements OrderDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcOrderDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
    public Order getOrder(long orderId) {
		Order order = null;
		String sqlSelectOrderByID = "SELECT * FROM orders WHERE id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectOrderByID, orderId);
		if(results.next()) {
			order = mapRowToOrder(results);
		}
		return order;
    }

	@Override
	public List<Order> getOrders(long userID) {
		List<Order> orders = new ArrayList<>();
		String sqlSelectOrderByUserID = "SELECT * FROM orders WHERE userid = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectOrderByUserID, userID);
		while(results.next()) {
			orders.add(mapRowToOrder(results));
		}
		return orders;
	}

	@Override
	public void saveOrder(Order order) {
		String sqlInsertOrder = "INSERT INTO orders("
				+ "id, userid, nameoncard, creditcardnumber, expirationdate, "
				+ "billingaddress1, billingaddress2, billingcity, billingstate, billingpostalcode, "
				+ "shippingaddress1, shippingaddress2, shippingcity, shippingstate, shippingpostalcode, "
				+ "shippingtype, subtotal, weight, shipping, tax) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Long id = getNextId();
		jdbcTemplate.update(sqlInsertOrder, id, order.getUserID(), order.getNameOnCard(), order.getCreditCardNumber(), order.getExpirationDate(),
				order.getBillingAddress1(), order.getBillingAddress2(), order.getBillingCity(), order.getBillingPostalCode(), order.getBillingState(),
				order.getShippingAddress1(), order.getShippingAddress2(), order.getShippingCity(), order.getShippingState(), order.getShippingPostalCode(),
				order.getShippingType(), order.getSubTotal().getBigDecimalValue(), order.getWeight(), order.getShipping().getBigDecimalValue(), order.getTax().getBigDecimalValue());
		order.setId(id);
	}

	private Order mapRowToOrder(SqlRowSet row) {
		Order order = new Order();
		order.setId(row.getLong("id"));
		order.setBillingAddress1(row.getString("billingaddress1"));
		order.setBillingAddress2(row.getString("billingaddress2"));
		order.setBillingCity(row.getString("billingcity"));
		order.setBillingPostalCode(row.getString("billingpostalcode"));
		order.setBillingState(row.getString("billingstate"));
		order.setCreditCardNumber(row.getString("creditcardnumber"));
		order.setExpirationDate(row.getString("expirationdate"));
		order.setNameOnCard(row.getString("nameoncard"));
		order.setShippingPostalCode(row.getString("shippingpostalcode"));
		order.setShipping(new DollarAmount(row.getBigDecimal("shipping")));
		order.setShippingAddress1(row.getString("shippingaddress1"));
		order.setShippingAddress2(row.getString("shippingaddress2"));
		order.setShippingCity(row.getString("shippingcity"));
		order.setShipping(new DollarAmount(row.getBigDecimal("shipping")));
		order.setShippingState(row.getString("shippingstate"));
		order.setShippingType(row.getString("shippingtype"));
		order.setSubTotal(new DollarAmount(row.getBigDecimal("subtotal")));
		order.setTax(new DollarAmount(row.getBigDecimal("tax")));
		order.setUserID(row.getLong("userid"));
		order.setWeight(row.getDouble("weight"));
		return order;
	}
	
	private Long getNextId() {
		String sqlSelectNextId = "SELECT NEXTVAL('seq_order_id')";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlSelectNextId);
		if(result.next()) {
			return result.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting the next order id");
		}
	}
}
