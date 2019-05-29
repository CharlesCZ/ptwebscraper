package org.teleinformatyka.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.teleinformatyka.api.model.RecipeTags;
import org.teleinformatyka.api.model.RecipeTagsPage;
import org.teleinformatyka.computations.RecipeService;

@RestController
public class RecipeController {

    private final RecipeService recipeService;


    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }


    @PostMapping("/recipe")
    public ResponseEntity<RecipeTags> saveOneRecipe(@RequestBody RecipeTags recipeTags){

       return new ResponseEntity<>( recipeService.singleRecipe(recipeTags), HttpStatus.CREATED);
    }


    @GetMapping("/recipe")
    @ResponseStatus(HttpStatus.OK)
    public RecipeTagsPage getAllRecipes(){

        return recipeService.findAllRecipes();
    }
}
