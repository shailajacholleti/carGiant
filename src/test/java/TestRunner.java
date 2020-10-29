import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/Features/wishlist.feature",
        glue = {"stepDefs"},
        plugin ={"pretty", "html:target/cucumber-html-report", "json:target/jsonReports/cucumber-report.json"},
        tags = {"@carGiant"}
)

public class TestRunner {
}
