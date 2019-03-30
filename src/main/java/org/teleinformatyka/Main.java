package org.teleinformatyka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.stream.Stream;

public class Main {

   public static void main(String[] args) throws InterruptedException {
      String projectPath=System.getProperty("user.dir");
       System.out.println(projectPath);
       System.out.println(projectPath+"/drivers/chromedriver/chromedriver.exe");
     System.setProperty("webdriver.chrome.driver",projectPath+"/drivers/chromedriver/chromedriver.exe");
       WebDriver driver=new ChromeDriver();

       driver.get("https://www.seleniumhq.org/");
       Thread.sleep(3000);
       driver.close();

   }
}
