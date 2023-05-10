package io.mimitwinkle.recipeapi.recipes;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/recipes")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    @GetMapping
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        return new ResponseEntity<List<Recipe>>(recipeService.getAllRecipes(), HttpStatus.OK);
    }

    @GetMapping("/{recipeId}")
    public ResponseEntity<Optional<Recipe>> getRecipeById(@PathVariable String recipeId) {
        return new ResponseEntity<Optional<Recipe>>(recipeService.getRecipeById(recipeId), HttpStatus.OK);
    }

}
