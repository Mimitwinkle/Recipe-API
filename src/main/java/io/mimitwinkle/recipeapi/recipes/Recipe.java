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

    public Recipe(String recipeId, String name, String source, int preptime, int waittime, int cooktime, int servings, String comments, String instructions, List<String> ingredients, List<String> tags, List<Review> reviewIds) {
        this.recipeId = recipeId;
        this.name = name;
        this.source = source;
        this.preptime = preptime;
        this.waittime = waittime;
        this.cooktime = cooktime;
        this.servings = servings;
        this.comments = comments;
        this.instructions = instructions;
        this.ingredients = ingredients;
        this.tags = tags;
        this.reviewIds = reviewIds;
    }
}
