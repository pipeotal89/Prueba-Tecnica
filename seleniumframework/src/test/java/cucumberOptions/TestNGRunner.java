package cucumberOptions;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/java/features", glue = "stepDefinitions", monochrome = true, tags = "@Login", plugin = {
        "pretty", "html:target/cucumber.html", "json:target/cucumber.json" })
public class TestNGRunner extends AbstractTestNGCucumberTests {

}
