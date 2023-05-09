package io.mimitwinkle.recipes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/recipes")
public class RecipeController {

    @GetMapping
    public ResponseEntity<String> allRecipes() {
        return new ResponseEntity<String>("All recipes", HttpStatus.OK);
    }

}
