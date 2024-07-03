package stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.SignUpPage;
import utils.DataGeneration;
import utils.TestSetup;

public class SignUpPageStepsDef {

    TestSetup testSetup;

    SignUpPage signUpPage;

    public SignUpPageStepsDef(TestSetup testSetup) throws IOException {
        this.testSetup = testSetup;
        signUpPage = testSetup.pageObjectManager.getSignUpPage();
    }

    @When("Usuario llena el formulario con información válida")
    public void moversePaginaRegistro() {
        String fullName = DataGeneration.fullName();
        String email = DataGeneration.correctEmail();
        String password = DataGeneration.correctPassword();
        signUpPage.fillForm(fullName, email, password, password);
    }

    @When("Usuario envía el formulario")
    public void enviarRegistro() {
        signUpPage.submit();
    }

    @When("Usuario ingresa el formulario con {int} nombres")
    public void ingresarCantidadDeNombres(int cant) {
        String name = "";
        for (int i = 0; i < cant; i++) {
            name += DataGeneration.oneName();
            name += " ";
        }
        String email = DataGeneration.correctEmail();
        String password = DataGeneration.correctPassword();
        signUpPage.fillForm(name, email, password, password);
    }

    @When("^Usuario ingresa removiendo (.+) del correo$")
    public void enviarCorreoIncompleto(String removed) {
        String fullName = DataGeneration.fullName();
        String email = DataGeneration.incorrectEmail(removed);
        String password = DataGeneration.correctPassword();
        signUpPage.fillForm(fullName, email, password, password);
    }

    @When("Usuario ingresa con un email ya registrado")
    public void enviarCorreoRepetido() {
        String fullName = DataGeneration.fullName();
        String email = "registeredUser@mail.com";
        String password = DataGeneration.correctPassword();
        signUpPage.fillForm(fullName, email, password, password);
    }

    @When("^Usuario ingresa sin (.+) en la contraseña$")
    public void enviarContraIncompleta(String removed) {
        String fullName = DataGeneration.fullName();
        String email = DataGeneration.correctEmail();
        String password = DataGeneration.incorrectPassword(removed);
        signUpPage.fillForm(fullName, email, password, password);
    }

    @When("^Usuario llena el formulario dejando (.+) vacío$")
    public void enviarConCamposIncompletos(String field) {
        String fullName = DataGeneration.fullName();
        String email = DataGeneration.correctEmail();
        String password = DataGeneration.correctPassword();
        switch (field) {
            case "email": 
                email = "";
                break;
            case "nombre": 
                fullName = "";
                break;
            default:
                password = "";
                break;
        }
        signUpPage.fillForm(fullName, email, password, password);
    }

    @When("Usuario llena el formulario con dos contraseñas diferentes")
    public void enviarConContraDiferente() {
        String fullName = DataGeneration.fullName();
        String email = DataGeneration.correctEmail();
        String password = DataGeneration.correctPassword();
        String password2 = DataGeneration.correctPassword();
        signUpPage.fillForm(fullName, email, password, password2);
    }

    @Then("^Botón de enviar del formulario debería estar (.+)$")
    public void verificarEstadoBoton(String estadoBoton) {
        boolean isClickable = signUpPage.checkIfSubmitClickable();
        if (estadoBoton.equals("activado")) Assert.assertTrue(isClickable);
        else Assert.assertFalse(isClickable);
    }

}
