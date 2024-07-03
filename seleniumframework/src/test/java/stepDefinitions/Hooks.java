package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import pageObjects.LoginPage;
import utils.TestSetup;

public class Hooks {

    TestSetup testSetup;

    LoginPage loginPage;

    public Hooks(TestSetup testSetup) throws IOException {
        this.testSetup = testSetup;
    }
    
    @Before
    public void setUp() throws IOException {
        testSetup.driver.manage().window().maximize();
    }

    @After
    public void tearDown() throws IOException {
        testSetup.driver.close();
    }

}
