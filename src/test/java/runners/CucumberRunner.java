package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/Task1.feature",
        //from feature file, should change the feature name at the end
        plugin = {"pretty", "html:cucumber-report/html-report",
                "junit:cucumber-report/junit-report.xml",
                "json:cucumber-report/json-report.json"},
        tags = {"@Scenario1, @Scenario2"},
        // FROM feature file certain scenario
        // Scenarios with the same tag (@Scenario1) name can be executed at the same time.
        // If they are separated by comma, then different scenarios can be run at the same time
        // Some scenarios can have multiple tags: @Scenario1 @Regression. Some scenarios with ~ sign before scenario can be excluded
        // Tag of the Feature (@Feature1) can be provided here, then all scenarios under the Feature will be executed
        dryRun = false,
        // With false its executing the test
        // "true" creates all the steps definitions. Implements missing step definitions.
        glue = {"stepDefinitions"}
)
public class CucumberRunner {
//
}
