package io.mimitwinkle.recipeapi.reviews;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReviewRepository extends MongoRepository<Review, String> {
    Optional<Review> findReviewById(String id);
    Optional<Review> deleteReviewById(String id);
}
