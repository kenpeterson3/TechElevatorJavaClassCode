package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcReviewDao implements ReviewDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcReviewDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Review> getAllReviews() {
		List<Review> allReviews = new ArrayList<>();
		String sqlSelectAllReviews = "SELECT * FROM reviews";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllReviews);
		while(results.next()) {
			Review review = new Review();
			review.setId(results.getLong("review_id"));
			review.setUsername(results.getString("username"));
			review.setRating(results.getInt("rating"));
			review.setTitle(results.getString("review_title"));
			review.setText(results.getString("review_text"));
			review.setDateSubmitted(results.getTimestamp("review_date").toLocalDateTime());
			allReviews.add(review);
		}
		return allReviews;
	}

	@Override
	public void save(Review review) {
		String sqlInsertReview = "INSERT INTO reviews(username, rating, review_title, review_text, review_date) VALUES (?,?,?,?,?) RETURNING review_id";
		Long id = jdbcTemplate.queryForObject(sqlInsertReview, Long.class, review.getUsername(), review.getRating(), review.getTitle(), review.getText(), review.getDateSubmitted());
		review.setId(id);
	}

}
