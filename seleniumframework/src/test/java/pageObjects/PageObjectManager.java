package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    
    public WebDriver driver;

    public LoginPage loginPage;
    public SignUpPage signUpPage;
    public AuthenticatedPage authenticatedPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        loginPage = new LoginPage(driver);
        return loginPage;
    }
    
    public SignUpPage getSignUpPage() {
        signUpPage = new SignUpPage(driver);
        return signUpPage;
    }

    public AuthenticatedPage geAuthenticatedPage() {
        authenticatedPage = new AuthenticatedPage(driver);
        return authenticatedPage;
    }

}
