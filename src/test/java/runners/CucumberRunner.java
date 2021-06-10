package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/Sample3.feature",
        plugin = {"pretty", "html:cucumber-report/html-report",
                "junit:cucumber-report/junit-report.xml",
                "json:cucumber-report/json-report.json"},
        //tags = {"@Sample1"},
        //tags = {"@scenario1, @scenario2, @scenario3"},
        //tags = {"@Feature1"},
        //tags = {"@scenario1", "@scenario2"},
        //tags = {"@Feature2", "@scenario1"},
        tags = {"@Feature2"},
        //tags = {"@NotWorking"},
        dryRun = false,
        //dryRun = true,
        glue = {"stepDefinitions"}
)
public class CucumberRunner {
//
}