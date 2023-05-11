package io.mimitwinkle.recipeapi.recipes;

import io.mimitwinkle.recipeapi.reviews.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "recipes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    @Id
    private ObjectId id;
    private String recipeId;
    private String name;
    private String source;
    private int preptime;
    private int waittime;
    private int cooktime;
    private int servings;
    private String comments;
    private String instructions;
    private List<String> ingredients;
    private List<String> tags;
    @DocumentReference
    private List<Review> reviewIds;
}
