package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/Task1.feature",
        plugin = {"pretty", "html:cucumber-report/html-report",
                "junit:cucumber-report/junit-report.xml",
                "json:cucumber-report/json-report.json"},
//        tags = {"@Scenario1"}, //will run all tests under @Feature1
//        tags = {"@Scenario1"}, //will run only this scenario
//        tags = {"@Regression"}, //will run all tests with annotation @Regression
//        tags = {"@Scenario, @Scenario2"}, //will run scenario1 and scenario2
//        tags = {"@Scenario1", "@Scenario2"}, //
//        tags = {"@Working"}, //
//        tags = {"@NotWorking"},
//        tags = {"@Working, @NotWorking"},
        tags = {"@Feature"},
        dryRun = false,
        glue = {"stepDefinitions"}
)
public class CucumberRunner {
//
}
