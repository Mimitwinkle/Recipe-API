package io.mimitwinkle.recipeapi.reviews;

import io.mimitwinkle.recipeapi.recipes.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public Optional<Review> getReviewById(String id) {
        return reviewRepository.findReviewById(id);
    }

    public Review createReview(String recipeId, String username, int rating, String reviewBody, LocalDateTime created) {
        Review review = reviewRepository.insert(new Review(username, rating, reviewBody, created));

        mongoTemplate.update(Recipe.class)
                .matching(Criteria.where("recipeId").is(recipeId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;
    }

    public Review updateReview(String id, int rating, String reviewBody, LocalDateTime updated) {
        Review review = reviewRepository.findReviewById(id).orElseThrow();
        review.setRating(rating);
        review.setBody(reviewBody);
        review.setLastUpdated(updated);

        return reviewRepository.save(review);
    }

    public void deleteReviewById(String id) {
        reviewRepository.deleteReviewById(id);
    }


}
