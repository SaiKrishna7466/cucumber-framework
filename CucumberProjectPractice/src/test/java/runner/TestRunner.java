package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions", "hooks"},
        plugin = {"pretty", "html:target/cucumber-report.html","json:target/cucumber.json", "junit:target/cucumber.xml"},
        monochrome = true,
        dryRun = false,
        tags = "@test"
        
)
public class TestRunner extends AbstractTestNGCucumberTests {
}