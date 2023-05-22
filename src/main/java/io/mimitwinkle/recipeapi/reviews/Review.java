package io.mimitwinkle.recipeapi.reviews;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "reviews")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Review {
    @Id
    private String id;
    private String username;
    private int rating;
    private String body;
    private LocalDateTime created;
    private LocalDateTime lastUpdated;

    public Review(String username, int rating, String body, LocalDateTime created) {
        this.username = username;
        this.rating = rating;
        this.body = body;
        this.created = created;
    }
}
