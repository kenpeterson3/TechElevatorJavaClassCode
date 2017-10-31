package com.techelevator.model;

import static org.junit.Assert.*;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.DAOIntegrationTest;
import com.techelevator.model.jdbc.JdbcUserDAO;

public class JdbcUserDaoIntegrationTest extends DAOIntegrationTest  {

	private static UserDAO dao;
	
	@Before
	public void setup() {
		dao = new JdbcUserDAO(getDataSource());
	}
	
	@Test
	public void saves_and_reads_one_user() {
		User user = new User();
		user.setEmail("larrye@oracle.com");
		user.setPassword("ImFantastic");
		
		dao.saveUser(user);
		User result = dao.getUser(user.getEmail());
		
		assertNotNull(result);
		assertThat(result, equalTo(user));
	}
	
	private Matcher<User> equalTo(final User expected) {
		return new TypeSafeMatcher<User>() {

			public void describeTo(Description description) {
			}

			protected boolean matchesSafely(User user) {
				return nullOrEqual(expected.getID(), user.getID()) &&
						nullOrEqual(expected.getEmail(), user.getEmail()) &&
						nullOrEqual(expected.getPassword(), user.getPassword());
			}
			
			private boolean nullOrEqual(Object left, Object right) {
				return left != null ? left.equals(right) : right == null;
			}
		};
	}

}
