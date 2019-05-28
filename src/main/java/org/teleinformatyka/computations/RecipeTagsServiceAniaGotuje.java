package org.teleinformatyka.computations;

import org.openqa.selenium.WebDriver;
import org.teleinformatyka.model.Recipe;
import org.teleinformatyka.model.RecipeTags;

import java.util.List;

public class RecipeTagsServiceAniaGotuje implements RecipeTagsService {
    @Override
    public Recipe singleRecipe(WebDriver webDriver, RecipeTags recipeTags) {
        return null;
    }

    @Override
    public List<Recipe> pageOfRecipes(WebDriver webDriver, RecipeTags recipeTags, String url, int siteNum) {
        return null;
    }
}
