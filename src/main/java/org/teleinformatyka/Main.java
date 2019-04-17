package org.teleinformatyka;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException {
        BasicConfigurator.configure();
        logger.info("rozpoczecie webscraping");
        String projectPath = System.getProperty("user.dir");
        logger.info(projectPath);
        logger.info(projectPath + "/drivers/chromedriver/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //String url = "/przepis/jajka-faszerowane-tunczykiem";
        //int strona = 0;
        driver.get("https://aniagotuje.pl");

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
        for (int i = 0; i < recipesLinkList1.size(); i++) {
            String name = recipesLinkList1.get(i);
            driver.navigate().to(name);
            List<WebElement> skladniki = driver.findElements(By.className("recipe-ing-list"));
            List<WebElement> nazwy = driver.findElements(By.xpath("//h1[@itemprop='name']"));
            for (WebElement naz : nazwy) {
                System.out.println(naz.getText()+"\n");
                for (WebElement skla : skladniki) {

                    System.out.println("Skladniki: \n" + skla.getText());

                }
                System.out.println();
                Thread.sleep(3000);
                driver.navigate().back();


            }
        }
        Thread.sleep(3000);
        driver.close();
        logger.info("webscraping zakonczony");
    }
}
