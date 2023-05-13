package io.mimitwinkle.recipeapi.reviews;

import io.mimitwinkle.recipeapi.recipes.Recipe;
import org.bson.types.ObjectId;
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

    public Optional<Review> getReviewById(ObjectId id) {
        return reviewRepository.findReviewById(id);
    }

    public Review createReview(String reviewBody, String username, LocalDateTime created, String recipeId) {
        Review review = reviewRepository.insert(new Review(reviewBody, username, created));

        mongoTemplate.update(Recipe.class)
                .matching(Criteria.where("recipeId").is(recipeId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;
    }

    public void deleteReviewById(ObjectId id) {
        reviewRepository.deleteReviewById(id);
    }
}
