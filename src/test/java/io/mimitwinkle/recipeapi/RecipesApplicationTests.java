package io.mimitwinkle.recipeapi;

import io.mimitwinkle.recipeapi.reviews.Review;
import io.mimitwinkle.recipeapi.reviews.ReviewRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RecipesApplicationTests {
	@Autowired
	ReviewRepository reviewRepository;

	@Test
	public void testCreateReview() {
		Review review = new Review();
		review.setId("testReviewId");
		review.setUsername("TestUsername");
		review.setBody("Test review.");
		review.setCreated(LocalDateTime.parse("2023-05-13T23:22:56.768"));
		reviewRepository.save(review);

		String id = review.getId().toString();
		assertNotNull(reviewRepository.findById(id));
	}

	@Test
	public void testDeleteReview() {
		String testReviewId = "testReviewId";

		boolean existsBeforeDeletion = reviewRepository.findById(testReviewId).isPresent();
		assertTrue(existsBeforeDeletion);

		reviewRepository.deleteById(testReviewId);
		boolean existsAfterDeletion = reviewRepository.findById(testReviewId).isPresent();
		assertFalse(existsAfterDeletion);
	}

}
