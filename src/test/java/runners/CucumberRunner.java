package runners;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
     // features = "src/test/resources/features/Sample5.feature",
        features = "src/test/resources/features/SamplePO.feature",
        plugin = {"pretty", "html:cucumber-report/html-report",
                "junit:cucumber-report/junit-report.xml",
                "json:cucumber-report/json-report.json"},
        tags = {"@Scenario3"},
        //tags = {"@Scenario1"},
        dryRun = false,
        glue = {"stepDefinitions"}
)
public class CucumberRunner {
//
}