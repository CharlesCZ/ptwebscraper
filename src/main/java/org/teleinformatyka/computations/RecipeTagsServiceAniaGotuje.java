package org.teleinformatyka.computations;

import org.openqa.selenium.WebDriver;
import org.teleinformatyka.model.Recipe;
import org.teleinformatyka.model.RecipeTags;
import org.teleinformatyka.model.RecipeTagsPage;

import java.util.List;

public class RecipeTagsServiceAniaGotuje implements RecipeTagsService {
    @Override
    public Recipe singleRecipe(WebDriver webDriver, RecipeTags recipeTags) {
        return null;
    }

    @Override
    public List<Recipe> pageOfRecipes(WebDriver webDriver, RecipeTagsPage recipeTagsPage) {
        return null;
    }
}
