package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By emailField = By.cssSelector("input#email");
    private By passwordField = By.cssSelector("input#password");
    private By submitButton = By.cssSelector("button[type=\"submit\"]");
    private By signUpButton = By.cssSelector("a[href=\"/auth/sign-up\"]");
    private By registerConfirmation = By.xpath("//*[contains(text(),\"Successful registration!\")]");

    public void fillForm(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
    }

    public void submit() {
        driver.findElement(submitButton).click();
    }

    public void clickSignUp() {
        driver.findElement(signUpButton).click();
    }

    public boolean checkIfSubmitClickable() {
        return driver.findElement(submitButton).isEnabled();
    }

    public boolean checkIfRegistered() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        List<WebElement> toast = driver.findElements(registerConfirmation);
        for (WebElement e : toast) {
            if (e.isDisplayed()) return true;
        }
        return false;
    }

}
