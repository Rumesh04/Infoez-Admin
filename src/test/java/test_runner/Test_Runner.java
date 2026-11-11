package test_runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\java\\Features\\Overview.feature", glue = { "step_definition",
		"hooks" }, monochrome = !true, dryRun = !true, plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}, tags = "@Enquiry")

public class Test_Runner {

}
