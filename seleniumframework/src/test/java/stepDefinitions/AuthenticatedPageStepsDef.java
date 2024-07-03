package stepDefinitions;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AuthenticatedPage;
import utils.TestSetup;

public class AuthenticatedPageStepsDef {

    TestSetup testSetup;

    AuthenticatedPage authenticatedPage;

    public AuthenticatedPageStepsDef(TestSetup testSetup) throws IOException {
        this.testSetup = testSetup;
        authenticatedPage = testSetup.pageObjectManager.geAuthenticatedPage();
    }

    @When("Usuario se desloguea de su cuenta")
    public void salirCuenta() {
        authenticatedPage.logout();
    }

    @Then("Usuario es redirigido a su perfil")
    public void verificarIngreso() {
        WebDriverWait wait = new WebDriverWait(testSetup.driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains("/panel"));
    }

    @Then("Usuario puede ver su nombre en el perfil")
    public void verificarNombreVisible() {
        authenticatedPage.checkName();
    }
}
