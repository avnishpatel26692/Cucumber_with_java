package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/Task2.feature",
        plugin = {"pretty", "html:cucumber-report/html-report",
                "junit:cucumber-report/junit-report.xml",
                "json:cucumber-report/json-report.json"},
        //tags = {"@Scenario3"}, //{"@Feature1"} //{"~@Regression"} //{"@Regression"} //{"@scenario1, @scenario2, @scenario3"}
        dryRun = false,
        glue = {"stepDefinitions"}
)
public class CucumberRunner {
//
}
