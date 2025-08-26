package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "features/login.feature", 
				glue = { "stepDefinitions", "hooks" },
//       		dryRun = true,
//				tags = "@UIValidation", 
				plugin = { "pretty", "html:reports/cucumber.html","json:reports/cucumber.json" }, 
				monochrome = true
				)
public class TestRunner extends AbstractTestNGCucumberTests {
}
