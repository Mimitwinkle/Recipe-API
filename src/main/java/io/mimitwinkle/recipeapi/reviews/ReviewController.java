package io.mimitwinkle.recipeapi.reviews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Review>> getReviewById(@PathVariable String id) {
        return new ResponseEntity<Optional<Review>>(reviewService.getReviewById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<Review>(reviewService.createReview(
                payload.get("recipeId"),
                payload.get("username"),
                Integer.parseInt(payload.get("rating")),
                payload.get("reviewBody"),
                LocalDateTime.parse(payload.get("created"))
        ), HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<Review> updateReview(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<Review>(reviewService.updateReview(
                payload.get("id"),
                Integer.parseInt(payload.get("rating")),
                payload.get("reviewBody"),
                LocalDateTime.parse(payload.get("updated"))
        ), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteReviewById(@PathVariable String id) {
        reviewService.deleteReviewById(id);
        return HttpStatus.OK;
    }
}
