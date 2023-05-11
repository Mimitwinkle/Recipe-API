package io.mimitwinkle.recipeapi.reviews;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "reviews")
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    private ObjectId id;
    private String body;
    private String username;
    private LocalDateTime created;

    public Review(String body, String username, LocalDateTime created) {
        this.body = body;
        this.username = username;
        this.created = created;
    }
}
