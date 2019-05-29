package org.teleinformatyka.computations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;
import org.teleinformatyka.api.model.RecipeTagsPage;
import org.teleinformatyka.domain.Recipe;
import org.teleinformatyka.api.model.RecipeTags;
import org.teleinformatyka.repositories.RecipeRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class RecipeServiceSimpleRecipes implements RecipeService {

private final RecipeRepository recipeRepository;

    public RecipeServiceSimpleRecipes(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }


    @Override
    public Recipe singleRecipe(WebDriver driver, RecipeTags recipeTags) {

        driver.get(recipeTags.getRecipeUrl());

        Recipe recipe=new Recipe();
        recipe.setTitle(((ChromeDriver) driver).findElement(By.cssSelector(recipeTags.getTitleClass())).getText());
        recipe.setIngredients(((ChromeDriver) driver).findElement(By.cssSelector(recipeTags.getIngredientsClass())).getText().replaceAll("[A-Z]{3,}",""));
       recipe.setInstructions(((ChromeDriver) driver).findElement(By.cssSelector(recipeTags.getInstructionsClass())).getText().replaceAll("[A-Z]{3,}",""));
Recipe returnedRecipe=recipeRepository.save(recipe);


        return returnedRecipe;
    }

    @Override
    public List<Recipe> pageOfRecipes(WebDriver driver, RecipeTagsPage recipeTagsPage) {

        driver.get(recipeTagsPage.getUrl());
        List<WebElement> listOfInputElements1 = ((ChromeDriver) driver).findElementByClassName(recipeTagsPage.getPageLinkTags()).findElements(By.tagName("a"));

        List<String> recipesLinkList1 = listOfInputElements1.stream()
                .map(webElement -> webElement.getAttribute("href"))
                .filter(Objects::nonNull)
                .filter(recipe->{
                    // String to be scanned to find the pattern.
                    String pattern="(https.+recipes/)";
                    // Create a Pattern object
                    Pattern r = Pattern.compile(pattern);
                    Matcher m = r.matcher(recipe);

                 return    m.find();
                })
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

    List<Recipe> returnedListRecipes=recipeRepository.saveAll(recipeList);
        return returnedListRecipes;
    }

    @Override
    public List<Recipe> findAllRecipes() {
        return recipeRepository.findAll();

    }

    @Override
    public Recipe singleRecipeAniaGotuje(WebDriver webDriver, RecipeTags recipeTags) {
        return null;
    }

    @Override
    public List<Recipe> pageOfRecipesAniaGotuje(WebDriver webDriver, RecipeTagsPage recipeTagsPage) {
        return null;
    }


}
