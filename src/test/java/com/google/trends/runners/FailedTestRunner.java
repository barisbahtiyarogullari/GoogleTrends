package com.google.trends.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "json:target/failed.json",
                "html:target/failed-default-report"
        },
        features = "@target/rerun.txt",
        glue = "com/google/trends/stepDefinitions"
)
public class FailedTestRunner {
}
