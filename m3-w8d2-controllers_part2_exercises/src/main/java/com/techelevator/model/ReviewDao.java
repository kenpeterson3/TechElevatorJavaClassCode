package com.techelevator.model;

import java.util.List;

public interface ReviewDao {

	public List<Review> getAllReviews();
	public void save(Review post);
}
