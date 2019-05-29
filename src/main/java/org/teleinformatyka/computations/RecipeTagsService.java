package org.teleinformatyka.computations;

import org.openqa.selenium.WebDriver;
import org.teleinformatyka.model.Recipe;
import org.teleinformatyka.model.RecipeTags;
import org.teleinformatyka.model.RecipeTagsPage;

import java.util.List;

public interface RecipeTagsService {

    Recipe singleRecipe(WebDriver webDriver, RecipeTags recipeTags);

    List<Recipe> pageOfRecipes(WebDriver webDriver, RecipeTagsPage recipeTagsPage);
}
