package com.techelevator.model;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertThat;

import java.time.LocalDateTime;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.DAOIntegrationTest;
import com.techelevator.model.JdbcReviewDao;
import com.techelevator.model.Review;

public class JdbcReviewDaoIntegrationTest extends DAOIntegrationTest {

	private JdbcReviewDao dao;
	
	@Before
	public void setup() {
		dao = new JdbcReviewDao(getDataSource());
	}
	
	@Before
	public void cleanDatabase() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		jdbcTemplate.update("DELETE FROM reviews");
	}
	
	@Test
	public void saved_reviews_are_returned_in_list_of_all_reviews() {
		Review review1 = createReview("Good Cop", 5, "Good Cop's review", "Loved it.");
		Review review2 = createReview("Bad Cop", 1, "Bad Cop's review", "Hated it.");
		
		dao.save(review1);
		dao.save(review2);
		
		List<Review> results = dao.getAllReviews();

		assertThat(results, hasItem(equalTo(review1)));
		assertThat(results, hasItem(equalTo(review2)));
		assertThat(results.size(), CoreMatchers.equalTo(2));
	}
	
	private Matcher<Review> equalTo(final Review expected) {
		return new TypeSafeMatcher<Review>() {

			public void describeTo(Description desc) {
				
			}

			protected boolean matchesSafely(Review review) {
				return nullOrEqual(expected.getId(), review.getId()) &&
						nullOrEqual(expected.getUsername(), review.getUsername()) &&
						nullOrEqual(expected.getRating(), review.getRating()) &&
						nullOrEqual(expected.getTitle(), review.getTitle()) &&
						nullOrEqual(expected.getText(), review.getText()) &&
						nullOrEqual(expected.getDateSubmitted(), review.getDateSubmitted());
						   
			}
			
			private boolean nullOrEqual(Object left, Object right) {
				return left != null ? left.equals(right) : right == null;
			}
		};
	}

	private Review createReview(String username, int rating, String title, String text) {
		Review review = new Review();
		review.setUsername(username);
		review.setRating(rating);
		review.setTitle(title);
		review.setText(text);
		review.setDateSubmitted(LocalDateTime.now());
		return review;
	}
}
