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

    // pobiera przepis każdy przepis z 1 strony tylko raz i wpisuje składniki
    public static void main(String[] args) throws InterruptedException {
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        System.out.println(projectPath + "/drivers/chromedriver/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //String url = "/przepis/jajka-faszerowane-tunczykiem";

        driver.get("https://aniagotuje.pl");

        List<WebElement> listOfInputElements = driver.findElements(By.tagName("a"));

        List<String> recipesLinkList= listOfInputElements.stream()
                .map(webElement -> webElement.getAttribute("href"))
                .filter(Objects::nonNull)
                .filter(s ->!s.contains("przepisy"))
                .filter(s -> s.contains("https://aniagotuje.pl/przepis"))
                .filter(s -> !s.contains("#"))
                .distinct()
                .collect(Collectors.toList());

        for(int i=0; i<recipesLinkList.size();i++) {
            String name = recipesLinkList.get(i);
            driver.navigate().to(name);
            List<WebElement> skladniki = driver.findElements(By.className("recipe-ing-list"));

            for (WebElement skla : skladniki) {

                System.out.println( "Skladniki: \n"+skla.getText());

            }
            System.out.println();
            Thread.sleep(3000);
            driver.navigate().back();
        }

       /*Thread.sleep(3000);
       for (int i = 1; i < 4; i++) {
           driver.findElement(By.className("page-item")).findElement(By.xpath("//a[@href='/page/" + i + "']")).click();
           Thread.sleep(3000);
       } // "przegląda pierwsze 4 strony

       Thread.sleep(3000);*/


    }
}
