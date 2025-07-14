package excitel.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber.html"},
        glue = {"excitel.stepDefinationFiles", "excitel.hook", "excitel.customDataTable", "excitel.customParameterType"},
        features = "src/test/resources/excitel"
)
public class TestngRunnerTest extends AbstractTestNGCucumberTests {

}