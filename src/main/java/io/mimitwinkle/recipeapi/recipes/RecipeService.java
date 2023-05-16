package io.mimitwinkle.recipeapi.recipes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public Optional<Recipe> getRecipeById(String id) {
        return recipeRepository.findRecipeByRecipeId(id);
    }

    public Optional<List<Recipe>> getRecipesByTags(List<String> tags) {
        return recipeRepository.findByTagsIn(tags);
    }
}
