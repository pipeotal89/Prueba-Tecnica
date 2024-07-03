package stepDefinitions;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import utils.DataGeneration;
import utils.TestSetup;

public class LoginPageStepsDef {

    TestSetup testSetup;

    LoginPage loginPage;

    public LoginPageStepsDef(TestSetup testSetup) throws IOException {
        this.testSetup = testSetup;
        loginPage = testSetup.pageObjectManager.getLoginPage();
    }

    @Given("Usuario ingresa a la página")
    public void ingresoPaginaPrinicipal() {
        testSetup.driver.get("https://test-qa.inlaze.com");
    }

    @When("Usuario clickea para registrarse")
    public void moversePaginaRegistro() {
        loginPage.clickSignUp();
    }

    @When("Usuario llena el Login con datos correctos")
    public void llenarLoginCorrecto() {
        loginPage.fillForm("correctUser@mail.com", "correctUser1*");
    }

    @When("Usuario envía el Login")
    public void enviarLogin() {
        loginPage.submit();
    }

    @When("^Usuario llena el campo de (.+)$")
    public void llenarLoginIncompleto(String campo) {
        String email = DataGeneration.correctEmail();
        String password = DataGeneration.correctPassword();
        if (campo.equals("email")) loginPage.fillForm(email, "");
        else loginPage.fillForm("", password);
    }

    @Then("Cuenta del usuario se crea correctamente")
    public void verificarCuentaCreada() {
        boolean isRegistered = loginPage.checkIfRegistered();
        Assert.assertTrue(isRegistered, "Usuario no fue registrado correctamente");
    }

    @Then("Usuario es des-autenticado")
    public void verificarLogout() {
        WebDriverWait wait = new WebDriverWait(testSetup.driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains("/auth/sign-in"));
    }

    @Then("^Botón de enviar del Login debería estar (.+)$")
    public void verificarEstadoBoton(String estadoBoton) {
        boolean isClickable = loginPage.checkIfSubmitClickable();
        if (estadoBoton.equals("activado")) Assert.assertTrue(isClickable);
        else Assert.assertFalse(isClickable);
    }

}
