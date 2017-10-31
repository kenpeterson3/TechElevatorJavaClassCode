package com.techelevator.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.techelevator.DAOIntegrationTest;
import com.techelevator.model.jdbc.JdbcProductDAO;

public class JdbcProductDaoIntegrationTest extends DAOIntegrationTest  {

	private static ProductDAO dao;
	
	@Before
	public void setup() {
		dao = new JdbcProductDAO(getDataSource());
	}
	
	@Test
	public void read_all_products() {
		List<Product> result = dao.getProducts();
		assertNotNull(result);
		assertTrue(result.size() > 0);
	}
	
}
