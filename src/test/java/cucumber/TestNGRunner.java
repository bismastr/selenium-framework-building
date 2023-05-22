package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/cucumber",glue = "bismastrFramework.stepDefinitions", monochrome = true)
public class TestNGRunner extends AbstractTestNGCucumberTests {

}
