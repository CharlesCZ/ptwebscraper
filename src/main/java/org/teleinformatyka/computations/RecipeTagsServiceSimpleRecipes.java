package org.teleinformatyka.computations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.teleinformatyka.model.Recipe;
import org.teleinformatyka.model.RecipeTags;
import org.teleinformatyka.model.RecipeTagsPage;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RecipeTagsServiceSimpleRecipes implements RecipeTagsService {


    @Override
    public Recipe singleRecipe(WebDriver driver, RecipeTags recipeTags) {

        driver.get(recipeTags.getRecipeUrl());

        Recipe recipe=new Recipe();
        recipe.setTitle(((ChromeDriver) driver).findElement(By.cssSelector(recipeTags.getTitleClass())).getText());
        recipe.setIngredients(((ChromeDriver) driver).findElement(By.cssSelector(recipeTags.getIngredientsClass())).getText().replaceAll("[A-Z]{3,}",""));
       recipe.setInstructions(((ChromeDriver) driver).findElement(By.cssSelector(recipeTags.getInstructionsClass())).getText().replaceAll("[A-Z]{3,}",""));
        return recipe;
    }

    @Override
    public List<Recipe> pageOfRecipes(WebDriver driver, RecipeTagsPage recipeTagsPage) {



        driver.get(recipeTagsPage.getUrl());
        List<WebElement> listOfInputElements1 = ((ChromeDriver) driver).findElementByClassName("entry-list").findElements(By.tagName("a"));

        List<String> recipesLinkList1 = listOfInputElements1.stream()
                .map(webElement -> webElement.getAttribute("href"))
                .filter(Objects::nonNull)
                .filter(s -> s.contains("https://www.simplyrecipes.com/recipes/"))
                .distinct()
                .collect(Collectors.toList());


List<Recipe> recipeList=new LinkedList<>();
        for (int i = 0; i < recipesLinkList1.size(); i++) {
            String name = recipesLinkList1.get(i);
            driver.navigate().to(name);
            Recipe recipe=new Recipe();
            recipe.setTitle(((ChromeDriver) driver).findElement(By.cssSelector(recipeTagsPage.getRecipeTags().getTitleClass())).getText());
            recipe.setIngredients(((ChromeDriver) driver).findElement(By.cssSelector(recipeTagsPage.getRecipeTags().getIngredientsClass())).getText().replaceAll("[A-Z]{3,}",""));
            recipe.setInstructions(((ChromeDriver) driver).findElement(By.cssSelector(recipeTagsPage.getRecipeTags().getInstructionsClass())).getText().replaceAll("[A-Z]{3,}",""));
          recipeList.add(recipe);
            driver.navigate().back();
        }


        return recipeList;
    }


}
