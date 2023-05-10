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
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Recipe {
    @Id
    private ObjectId id;
    private String name;
    private String source;
    private int preptime;
    private int waittime;
    private int cooktime;
    private int servings;
    private String comments;
    // Database contains nutritional info, but I won't include this in the MVP
//    private int calories;
//    private int fat;
//    private int satfat;
//    private int carbs;
//    private int fiber;
//    private int sugar;
//    private int protein;
    private String instructions;
    private List<String> ingredients;
    private List<String> tags;
    @DocumentReference
    private List<Review> reviewIds;



    public Recipe() {
    }

    public Recipe(ObjectId id, String name, String source, int preptime, int waittime, int cooktime, int servings, String comments, String instructions, List<String> ingredients, List<String> tags, List<Review> reviewIds) {
        this.id = id;
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

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getPreptime() {
        return preptime;
    }

    public void setPreptime(int preptime) {
        this.preptime = preptime;
    }

    public int getWaittime() {
        return waittime;
    }

    public void setWaittime(int waittime) {
        this.waittime = waittime;
    }

    public int getCooktime() {
        return cooktime;
    }

    public void setCooktime(int cooktime) {
        this.cooktime = cooktime;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<Review> getReviewIds() {
        return reviewIds;
    }

    public void setReviewIds(List<Review> reviewIds) {
        this.reviewIds = reviewIds;
    }
}
