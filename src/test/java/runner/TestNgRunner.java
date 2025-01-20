package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions
        (
                features = "./src/test/java/features",
                glue = {"stepDefinition"},
                monochrome = true,//Display the console more readability
                tags = "@tag2",//"@tag or @tag2","@tag and @tag2" we can also assigne feature level
                dryRun = false, //true: Checks if all the Steps have the StepDefinition
                strict = false, // Will fail execution if there are undefined or pending Steps
                plugin = {"pretty", "html:target/cucumber-reports/cucumber-pretty",
                        "json:target/cucumber-reports/CucumberTestReport.json",
                        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                        "rerun:target/failedRerun.txt" // it will create the file path of failed scenarios
                }
        )
public class TestNgRunner extends AbstractTestNGCucumberTests {

}
