package org.teleinformatyka;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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


        driver.get("https://aniagotuje.pl");


        driver.navigate().to("https://aniagotuje.pl/page/1");



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
//            List<WebElement> skladniki = driver.findElements(By.className("recipe-ing-list"));
            List<WebElement> skladniki = schemaOrgParser.getRecipeIngredient(driver);
            List<WebElement> calories = schemaOrgParser.getElementsByItemProp(driver, "calories");
            List<WebElement> description = schemaOrgParser.getElementsByItemProp(driver, "description");

            List<WebElement> nazwyPrzepisow = driver.findElements(By.xpath("//h1[@itemprop='name']"));

            for (WebElement naz : nazwyPrzepisow) {
                System.out.println(naz.getText()+"\n");
                // Step #5. Perform write operation.
                writer.write("\n"+naz.getText()+"\n\n");
                schemaOrgParser.printElements(skladniki, "Skladniki");
                schemaOrgParser.printElements(calories,"Kalorie");
                schemaOrgParser.printElements(description,"Opis");

//                for (WebElement skla : skladniki) {
//
//                    System.out.println("Skladniki: \n" + skla.getText());
//                    writer.write("Skladniki: \n" + skla.getText());
//
//                }

                System.out.println();
                writer.write("\n\n");
                driver.navigate().back();


            }
        }



        // Step #6. free the resources.
        writer.close();



        driver.close();
        logger.info("webscraping zakonczony");
    }
}
