package com.google.trends.stepDefinitions;

import com.google.trends.utilities.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class SetUpAndTearDown {

    // This class will run before and after each scenario. Cucumber Annotations used.

    @Before
    public void setUp(Scenario scenario){
        //DriverFactory.getDriver().manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            byte [] screenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        System.out.println("End of scenario:    " + scenario.getName());
        DriverFactory.quit();
    }
}
