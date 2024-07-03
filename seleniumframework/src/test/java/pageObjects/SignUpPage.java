package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {

    public WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private By nameField = By.cssSelector("input#full-name");
    private By emailField = By.cssSelector("input#email");
    private By passwordField = By.cssSelector("input#password");
    private By confirmPasswordField = By.cssSelector("input#confirm-password");
    private By submitButton = By.cssSelector("button[type=\"submit\"]");

    public void fillForm(String name, String email, String password, String passwordConfirm) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(confirmPasswordField).sendKeys(passwordConfirm);
    }

    public void submit() {
        driver.findElement(submitButton).click();
    }

    public boolean checkIfSubmitClickable() {
        return driver.findElement(submitButton).isEnabled();
    }

}
