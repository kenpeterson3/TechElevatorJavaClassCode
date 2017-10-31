package com.techelevator.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.OrderItemDAO;
import com.techelevator.model.DollarAmount;
import com.techelevator.model.OrderItem;

@Component
public class JdbcOrderItemDAO implements OrderItemDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcOrderItemDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<OrderItem> getOrderItems(long orderID) {
		List<OrderItem> orderItems = new ArrayList<>();
		String sqlSelectOrderItemsByOrderID = "SELECT * FROM order_items WHERE orderid = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectOrderItemsByOrderID, orderID);
		while(results.next()) {
			orderItems.add(mapRowToOrderItem(results));
		}
		return orderItems;
    }

	@Override
	public void saveOrderItems(List<OrderItem> orderItems) {
		String sqlInsertOrderItem = "INSERT INTO order_items(orderid, productid, quantity, price) VALUES(?, ?, ?, ?)";
		for (OrderItem orderItem : orderItems) {
			jdbcTemplate.update(sqlInsertOrderItem, orderItem.getOrderID(), orderItem.getProductID(), orderItem.getQuantity(), orderItem.getPrice().getBigDecimalValue());
		}
	}
	
	private OrderItem mapRowToOrderItem(SqlRowSet row) {
		OrderItem orderItem = new OrderItem();
		orderItem.setOrderID(row.getLong("orderid"));
		orderItem.setProductID(row.getLong("productId"));
		orderItem.setQuantity(row.getInt("quantity"));
		orderItem.setPrice(new DollarAmount(row.getBigDecimal("price")));
		return orderItem;
	}

}
