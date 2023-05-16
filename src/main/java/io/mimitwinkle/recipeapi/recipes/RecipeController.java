package io.mimitwinkle.recipeapi.recipes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/tags")
    public ResponseEntity<Optional<List<Recipe>>> getRecipesByTags(@RequestParam("tags") List<String> tags) {
        return new ResponseEntity<Optional<List<Recipe>>>(recipeService.getRecipesByTags(tags), HttpStatus.OK);
    }

}
