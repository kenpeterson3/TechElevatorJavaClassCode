package com.techelevator.model.jdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.User;
import com.techelevator.model.UserDAO;

@Component
public class JdbcUserDAO implements UserDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcUserDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
    public User getUser(String email) {
		User user = null;
		String sqlSelectProductByEmail = "SELECT * FROM users WHERE email = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectProductByEmail, email);
		if(results.next()) {
			user = mapRowToUser(results);
		}
		return user;
    }

	@Override
    public void saveUser(User user) {
		String sqlInsertProduct = "INSERT INTO users(id, email, password) VALUES(?, ?, ?)";
		Long id = getNextId();
		jdbcTemplate.update(sqlInsertProduct, id, user.getEmail(), user.getPassword());
		user.setID(id);
    }

	private User mapRowToUser(SqlRowSet row) {
		User user = new User();
		user.setID(row.getLong("id"));
		user.setEmail(row.getString("email"));
		user.setPassword(row.getString("password"));
		return user;
	}
	
	private Long getNextId() {
		String sqlSelectNextId = "SELECT NEXTVAL('seq_user_id')";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlSelectNextId);
		if(result.next()) {
			return result.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting the next user id");
		}
	}

}
