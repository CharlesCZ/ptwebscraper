package org.teleinformatyka.computations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;
import org.teleinformatyka.api.mapper.RecipeMapper;
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
    private final  WebDriver driver;
private final RecipeMapper recipeMapper;

    public RecipeServiceSimpleRecipes(RecipeRepository recipeRepository, WebDriver driver, RecipeMapper recipeMapper) {
        this.recipeRepository = recipeRepository;
        this.driver = driver;
        this.recipeMapper = recipeMapper;
    }


    @Override
    public RecipeTags singleRecipe( RecipeTags recipeTags) {

        driver.get(recipeTags.getRecipeUrl());

        Recipe recipe=new Recipe();
        recipe.setTitle(((ChromeDriver) driver).findElement(By.cssSelector(recipeTags.getTitleClass())).getText());
        recipe.setIngredients(((ChromeDriver) driver).findElement(By.cssSelector(recipeTags.getIngredientsClass())).getText().replaceAll("[A-Z]{3,}",""));
       recipe.setInstructions(((ChromeDriver) driver).findElement(By.cssSelector(recipeTags.getInstructionsClass())).getText().replaceAll("[A-Z]{3,}",""));



        return recipeMapper.recipeToRecipeTags(recipeRepository.save(recipe));
    }

    @Override
    public RecipeTagsPage pageOfRecipes( RecipeTagsPage recipeTagsPage) {

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
            recipe.setTitle(((ChromeDriver) driver).findElement(By.cssSelector(recipeTagsPage.getRecipeTags().get(0).getTitleClass())).getText());
            recipe.setIngredients(((ChromeDriver) driver).findElement(By.cssSelector(recipeTagsPage.getRecipeTags().get(0).getIngredientsClass())).getText().replaceAll("[A-Z]{3,}",""));
            recipe.setInstructions(((ChromeDriver) driver).findElement(By.cssSelector(recipeTagsPage.getRecipeTags().get(0).getInstructionsClass())).getText().replaceAll("[A-Z]{3,}",""));
          recipeList.add(recipe);
            driver.navigate().back();
        }

recipeTagsPage.setRecipeTags(recipeRepository.saveAll(recipeList)
        .stream().map(recipeMapper::recipeToRecipeTags).collect(Collectors.toList()));

        return recipeTagsPage;
    }

    @Override
    public RecipeTagsPage findAllRecipes() {
        RecipeTagsPage recipeTagsPage=new RecipeTagsPage();

        recipeTagsPage.setRecipeTags(recipeRepository.findAll()
                .stream().map(recipeMapper::recipeToRecipeTags).collect(Collectors.toList()));

        return recipeTagsPage;

    }

    @Override
    public RecipeTags singleRecipeAniaGotuje(RecipeTags recipeTags) {
        //TODO ZROBCIE TO ALE BEZ UZYCIA XPATH

        return null;
    }

    @Override
    public RecipeTagsPage pageOfRecipesAniaGotuje(RecipeTagsPage recipeTagsPage)
    {
        //TODO ZROBCIE TO ALE BEZ UZYCIA XPATH
        return null;
    }


}

