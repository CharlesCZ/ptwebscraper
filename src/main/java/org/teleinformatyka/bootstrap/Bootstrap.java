package org.teleinformatyka.bootstrap;

import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.teleinformatyka.api.model.RecipeTagsPage;
import org.teleinformatyka.computations.RecipeService;
import org.teleinformatyka.api.model.RecipeTags;

import java.util.Arrays;

@Slf4j
@Component
public class Bootstrap implements CommandLineRunner {



private final RecipeService recipeService;


    public Bootstrap(RecipeService recipeService) {
        this.recipeService = recipeService;

    }


    @Override
    public void run(String... args) throws Exception {



        BasicConfigurator.configure();




        //simplerecipes;

       RecipeTags recipeTags=new RecipeTags();
        recipeTags.setRecipeUrl("https://www.simplyrecipes.com/recipes/pasta_with_spinach_artichokes_and_ricotta/");
        recipeTags.setTitleClass(".entry-title");
        recipeTags.setIngredientsClass(".entry-details.recipe-ingredients");
        recipeTags.setInstructionsClass(".entry-details.recipe-method.instructions");


        System.out.println(recipeService.singleRecipe(recipeTags).toString());

      RecipeTagsPage recipeTagsPage=new RecipeTagsPage();
      recipeTagsPage.setRecipeTags(Arrays.asList(recipeTags));
      recipeTagsPage.setUrl("https://www.simplyrecipes.com/recipes/ingredient/chicken/page/2");
      recipeTagsPage.setPageLinkTags("entry-list");
         recipeService.pageOfRecipes(recipeTagsPage).forEach(System.out::println);

        System.out.println("##########################");
//https://www.bbc.com/food/recipes

        RecipeTags recipeTags2=new RecipeTags();
        recipeTags2.setRecipeUrl("https://www.bbc.com/food/recipes/stuffed_chicken_breasts_14926");
        recipeTags2.setTitleClass(".gel-trafalgar.content-title__text");
        recipeTags2.setIngredientsClass(".recipe-ingredients__list");
        recipeTags2.setInstructionsClass(".recipe-method__list");


        System.out.println(recipeService.singleRecipe(recipeTags2).toString());



        RecipeTagsPage recipeTagsPage2=new RecipeTagsPage();
        recipeTagsPage2.setRecipeTags(Arrays.asList(recipeTags2));
        recipeTagsPage2.setUrl("https://www.bbc.com/food/search?occasions=eid_el-fitr");
        recipeTagsPage2.setPageLinkTags("loading-overlay");
        recipeService.pageOfRecipes(recipeTagsPage2).forEach(System.out::println);


     //   driver.close();
        log.info("webscraping zakonczony");
    }
}
