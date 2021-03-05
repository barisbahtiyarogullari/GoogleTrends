package com.google.trends.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

                features = "src/test/resources/features",
                glue = "com/google/trends/stepDefinitions",
                plugin = {
                        "pretty",
                        "rerun:target/rerun.txt",
                        "html:target/cucumber-html-reports.html",
                        "json:target/cucumber.json"
                },

                tags="@GoogleTrends"
        )

public class CucumberRunner {
}
