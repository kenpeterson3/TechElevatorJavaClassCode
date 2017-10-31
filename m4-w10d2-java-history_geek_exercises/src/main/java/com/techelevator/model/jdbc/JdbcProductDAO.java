package com.techelevator.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.DollarAmount;
import com.techelevator.model.Product;
import com.techelevator.model.ProductDAO;

@Component
public class JdbcProductDAO implements ProductDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcProductDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Product> getProducts() {
		List<Product> products = new ArrayList<>();
		String sqlSelectProducts = "SELECT * FROM products";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectProducts);
		while(results.next()) {
			products.add(mapRowToProduct(results));
		}
		return products;
    }
	
	@Override
	public Product getProduct(String sku) {
		Product product = new Product();
		String sqlSelectProductBySKU = "SELECT * FROM products WHERE sku = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectProductBySKU, sku);
		if(results.next()) {
			product = mapRowToProduct(results);
		}
		return product;
	}
	
	@Override
	public Product getProductByID(long id) {
		Product product = new Product();
		String sqlSelectProductByID = "SELECT * FROM products WHERE id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectProductByID, id);
		if(results.next()) {
			product = mapRowToProduct(results);
		}
		return product;
	}
	
	private Product mapRowToProduct(SqlRowSet row) {
		Product product = new Product();
		product.setId(row.getLong("id"));
		product.setSku(row.getString("sku"));
		product.setName(row.getString("name"));
		product.setDescription(row.getString("description"));
		product.setPrice(new DollarAmount(row.getBigDecimal("price")));
		product.setImageName(row.getString("imagename"));
		product.setWeight(row.getDouble("weight"));
		product.setActive(row.getBoolean("active"));
		return product;
	}

}
