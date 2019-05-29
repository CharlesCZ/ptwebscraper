package org.teleinformatyka.computations;

import org.openqa.selenium.WebDriver;
import org.teleinformatyka.api.model.RecipeTagsPage;
import org.teleinformatyka.domain.Recipe;
import org.teleinformatyka.api.model.RecipeTags;

import java.util.List;

public interface RecipeService {

    RecipeTags  singleRecipe(RecipeTags recipeTags);

    RecipeTagsPage pageOfRecipes(RecipeTagsPage recipeTagsPage);


    RecipeTagsPage findAllRecipes();



    RecipeTags  singleRecipeAniaGotuje( RecipeTags recipeTags);


    RecipeTagsPage pageOfRecipesAniaGotuje(RecipeTagsPage recipeTagsPage);



}
