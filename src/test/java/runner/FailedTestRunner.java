package runner;


import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "@target/failedRerun.txt",
        glue = {"stepDefinition"},
        monochrome = true,
        tags = "@tag",
        plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "junit:target/cucumber-reports/JunitReport.xml",
                "rerun:target/failedRerun.txt"
        }
)

public class FailedTestRunner {
}
