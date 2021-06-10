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
        tags = {"@Scenario1, @Scenario2"},  // ~@Regression   (ne zapustit vsjo, chto s tegom @Regression.) Neskoljko tegov mozhno pisatj cherez ","
        dryRun = false,
        glue = {"stepDefinitions"}
)
public class CucumberRunner {
//
}
