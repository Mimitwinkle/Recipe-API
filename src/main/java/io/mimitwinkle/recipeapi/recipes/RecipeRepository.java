package io.mimitwinkle.recipeapi.recipes;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecipeRepository extends MongoRepository<Recipe, ObjectId> {
    Optional<Recipe> findRecipeByRecipeId(String id);

    @Query(value = "{ 'tags':{ $all: ?0 } }")
    Optional<List<Recipe>> findByTagsIn(List<String> tags);
}
