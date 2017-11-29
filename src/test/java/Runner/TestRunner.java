package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * Created by whaque on 27.04.17.
 */

@CucumberOptions(features = {"src/test/java/Features"}
    ,format = {"json:target/cucumber-report.json", "html:target/site/cucumber-pretty"}
    ,glue = "Steps")
public class TestRunner extends AbstractTestNGCucumberTests {
}
