package org.teleinformatyka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;

public class schemaOrgParser {

    static  List<WebElement> getArticles(WebDriver driver){
        List<WebElement> Articles = driver.findElements(By.tagName("article"));
    return Articles;
    }


   public static List<WebElement> getRecipeIngredient(WebDriver driver){

        List<WebElement> Ingredients = driver.findElements(By.xpath("//li[@itemprop='recipeIngredient']"));

       return Ingredients;
    }

    public static List<WebElement> getElementsByItemProp(WebDriver driver, String  itemprop){

        List<WebElement> webElements = driver.findElements(By.xpath("//li[@itemprop='"+itemprop+"']"));

        return webElements;
    }

    static void printElements(List<WebElement> elements, String title){
        if(!title.isEmpty())
            System.out.print(title + "\n");
        Iterator itr = elements.iterator();
        while(itr.hasNext()){
            WebElement element = (WebElement) itr.next();
            String valToPrint = "";
            if(element.getText().isEmpty())
                valToPrint = element.getAttribute("content");
            else
                valToPrint = element.getText();
            System.out.print( valToPrint + "\n");
        }
    }

}
