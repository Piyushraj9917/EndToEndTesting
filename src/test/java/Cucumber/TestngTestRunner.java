package Cucumber;

import io.cucumber.plugin.event.StepDefinition;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/Cucumber",
        glue = "Piyush.StepDefinitions", monochrome = true,plugin = ("html:target/classes/cucumber.html"))
public class TestngTestRunner extends AbstractTestNGCucumberTests {

}
