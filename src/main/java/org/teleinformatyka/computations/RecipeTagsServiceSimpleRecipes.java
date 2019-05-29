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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
        // String to be scanned to find the pattern.
        String pattern="(https.+recipes/)";

        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);

        // Now create matcher object.
        Matcher m = r.matcher(recipeTagsPage.getUrl());
        if (m.find( )) {
            System.out.println("Found value: " + m.group(0) );

        }else {
            System.out.println("NO MATCH");
        }







        driver.get(recipeTagsPage.getUrl());
        List<WebElement> listOfInputElements1 = ((ChromeDriver) driver).findElementByClassName(recipeTagsPage.getPageLinkTags()).findElements(By.tagName("a"));

        List<String> recipesLinkList1 = listOfInputElements1.stream()
                .map(webElement -> webElement.getAttribute("href"))
                .filter(Objects::nonNull)
                .filter(s -> s.contains(m.group(0)))
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
