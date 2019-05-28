package org.teleinformatyka;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.teleinformatyka.computations.RecipeTagsService;
import org.teleinformatyka.computations.RecipeTagsServiceSimpleRecipes;
import org.teleinformatyka.model.RecipeTags;

import java.io.*;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {

    static final Logger logger = Logger.getLogger(Main.class);


    public static void main(String[] args) throws InterruptedException, IOException {



        BasicConfigurator.configure();
        logger.info("rozpoczecie webscraping");
        String projectPath = System.getProperty("user.dir");
        logger.info(projectPath);
        logger.info(projectPath + "/drivers/chromedriver/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
       WebDriver driver = new ChromeDriver(new ChromeOptions().setHeadless(true));

        //String url = "/przepis/jajka-faszerowane-tunczykiem";
        //int strona = 0;
    /*    driver.get("https://aniagotuje.pl");

        List<WebElement> listOfInputElements = driver.findElements(By.tagName("a"));
        List<String> recipesLinkList = listOfInputElements.stream()
                .map(webElement -> webElement.getAttribute("href"))
                .filter(Objects::nonNull)
                .filter(s -> !s.contains("przepisy"))
                .filter(s -> s.contains("https://aniagotuje.pl/przepis"))
                .filter(s -> !s.contains("#"))
                .distinct()
                .collect(Collectors.toList());
        for (int i = 0; i < recipesLinkList.size(); i++) {
            String name = recipesLinkList.get(i);
            driver.navigate().to(name);
            List<WebElement> nazwy = driver.findElements(By.xpath("//h1[@itemprop='name']"));
            for (WebElement naz : nazwy) {
                System.out.println(naz.getText()+"\n");
                List<WebElement> skladniki = driver.findElements(By.className("recipe-ing-list"));
                for (WebElement skla : skladniki) {
                    System.out.println("Skladniki: \n" + skla.getText());
                }
                System.out.println();
                Thread.sleep(3000);
                driver.navigate().back();
            }
        }
        driver.navigate().to("https://aniagotuje.pl/page/1");
        // strona ++;
        // driver.findElement(By.className("page-item")).findElement(By.xpath("//a[@href='/page/" + strona + "']")).click();


        List<WebElement> listOfInputElements1 = driver.findElements(By.tagName("a"));

        List<String> recipesLinkList1 = listOfInputElements1.stream()
                .map(webElement -> webElement.getAttribute("href"))
                .filter(Objects::nonNull)
                .filter(s -> !s.contains("przepisy"))
                .filter(s -> s.contains("https://aniagotuje.pl/przepis"))
                .filter(s -> !s.contains("#"))
                .distinct()
                .collect(Collectors.toList());





        // Step #1. Create a file object.
        File file = new File(System.getProperty("user.dir") + "/drivers/chromedriver/przepisy.txt");
        // Step #2. Create a file writer object with above file.
        FileWriter fileWriter = new FileWriter(file);
        // Step #3. Create a file object with above file writer.
        BufferedWriter writer = new BufferedWriter(fileWriter);

        // Step #4. Prepare data to be stored in above file.
        for (int i = 0; i < recipesLinkList1.size(); i++) {
            String name = recipesLinkList1.get(i);
            driver.navigate().to(name);
            List<WebElement> skladniki = driver.findElements(By.className("recipe-ing-list"));
            List<WebElement> nazwy = driver.findElements(By.xpath("//h1[@itemprop='name']"));
            for (WebElement naz : nazwy) {
                System.out.println(naz.getText()+"\n");
                // Step #5. Perform write operation.
                writer.write("\n"+naz.getText()+"\n\n");
                for (WebElement skla : skladniki) {

                    System.out.println("Skladniki: \n" + skla.getText());
                    writer.write("Skladniki: \n" + skla.getText());
                }
                System.out.println();
                writer.write("\n\n");
                driver.navigate().back();


            }
        }



        // Step #6. free the resources.
        writer.close();


*/

        //simplerecipes;
        RecipeTagsService recipeTagsService=new RecipeTagsServiceSimpleRecipes();
        RecipeTags recipeTags=new RecipeTags();
        recipeTags.setRecipeUrl("https://www.simplyrecipes.com/recipes/pasta_with_spinach_artichokes_and_ricotta/");
        recipeTags.setTitleClass(".recipe-callout");
        recipeTags.setIngredientsClass(".entry-details.recipe-ingredients");
        recipeTags.setInstructionsClass(".entry-details.recipe-method.instructions");


        System.out.println(recipeTagsService.singleRecipe(driver,recipeTags).toString());


         recipeTagsService.pageOfRecipes(driver,recipeTags,"https://www.simplyrecipes.com/recipes/ingredient/chicken/page/",2).forEach(System.out::println);











        driver.close();
        logger.info("webscraping zakonczony");
    }
}
