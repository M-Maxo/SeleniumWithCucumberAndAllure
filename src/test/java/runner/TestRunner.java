package runner;

import io.cucumber.testng.CucumberOptions;
import testBase.TestBase;


@CucumberOptions(features="src/test/java/features",
glue={"steps"},
plugin = {"pretty",
"json:target/cucumber-report/cucumber.json"},
monochrome = true )

public class TestRunner extends TestBase
{

}
