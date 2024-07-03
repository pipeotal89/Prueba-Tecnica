package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.PageObjectManager;

public class TestSetup {

    public WebDriver driver;

    public PageObjectManager pageObjectManager;

    public TestSetup() {

        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "/src/test/java/resources/chromedriver.exe");
        driver = new ChromeDriver();
        
        pageObjectManager = new PageObjectManager(driver);

    }

}