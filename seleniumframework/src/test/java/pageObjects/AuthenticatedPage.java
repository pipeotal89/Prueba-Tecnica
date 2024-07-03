package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AuthenticatedPage {

public WebDriver driver;

    public AuthenticatedPage(WebDriver driver) {
        this.driver = driver;
    }

    private By nameLabel = By.cssSelector("div.dropdown h2.font-bold");
    private By userImage = By.cssSelector("img[src=\"/assets/rengoku.webp\"]");
    private By logoutButton = By.xpath("//*[contains(text(),\"Logout\")]");

    public void checkName() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String name = driver.findElement(nameLabel).getText();
        Assert.assertEquals(name, "Juan Otalora");
    }

    public void logout() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(userImage).click();
        driver.findElement(logoutButton).click();
    }

}
