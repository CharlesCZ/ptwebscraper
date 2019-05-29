package org.teleinformatyka.computations;

import org.openqa.selenium.WebDriver;
import org.teleinformatyka.api.model.RecipeTagsPage;
import org.teleinformatyka.domain.Recipe;
import org.teleinformatyka.api.model.RecipeTags;

import java.util.List;

public interface RecipeService {

    Recipe singleRecipe(RecipeTags recipeTags);

    List<Recipe> pageOfRecipes(RecipeTagsPage recipeTagsPage);


    List<Recipe> findAllRecipes();



    Recipe singleRecipeAniaGotuje( RecipeTags recipeTags);


    List<Recipe> pageOfRecipesAniaGotuje(RecipeTagsPage recipeTagsPage);



}