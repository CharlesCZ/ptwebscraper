package org.teleinformatyka.config;


import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class SeleniumConfig {


    @Bean
    public WebDriver webDriver(){

        log.info("rozpoczecie webscraping");
        String projectPath = System.getProperty("user.dir");
        log.info(projectPath);
        log.info(projectPath + "/drivers/chromedriver/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
        return driver;
    }
}
