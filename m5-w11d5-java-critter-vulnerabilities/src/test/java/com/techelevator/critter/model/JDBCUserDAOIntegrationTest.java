package com.techelevator.critter.model;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration("/test-config.xml")
@Transactional
public class JDBCUserDAOIntegrationTest {

	@Autowired private BasicDataSource dataSource;
	@Autowired private UserDAO userDAO;
	
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}

	@Test
	public void returns_true_if_userName_and_password_match() {
		userDAO.saveUser("spiderman", "uncleBen");
		boolean result = userDAO.searchForUsernameAndPassword("spiderman", "uncleBen");
		assertThat(result, equalTo(true));
	}

	@Test
	public void returns_false_if_userName_does_not_exist() {
		userDAO.saveUser("spiderman", "uncleBen");
		boolean result = userDAO.searchForUsernameAndPassword("antman", "uncleBen");
		assertThat(result, equalTo(false));
	}

	@Test
	public void returns_false_if_userName_exists_but_password_is_incorrect() {
		userDAO.saveUser("spiderman", "uncleBen");
		boolean result = userDAO.searchForUsernameAndPassword("spiderman", "uncleBob");
		assertThat(result, equalTo(false));
	}
	
	@Test
	public void userName_is_not_case_sensitive() {
		userDAO.saveUser("SpiderMan", "uncleBen");
		boolean result = userDAO.searchForUsernameAndPassword("sPIDERmAN", "uncleBen");
		assertThat(result, equalTo(true));
	}
	
	@Test
	public void password_is_case_sensitive() {
		userDAO.saveUser("spiderman", "uncleBen");
		boolean result = userDAO.searchForUsernameAndPassword("spiderman", "uncleben");
		assertThat(result, equalTo(false));
	}
	
	

}
