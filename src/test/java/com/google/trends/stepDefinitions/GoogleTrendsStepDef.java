package com.google.trends.stepDefinitions;

import com.google.trends.pages.BasePage;
import com.google.trends.pages.Compare;
import com.google.trends.pages.Explore;
import com.google.trends.utilities.BrowserUtils;
import com.google.trends.utilities.ConfigurationReader;
import com.google.trends.utilities.DriverFactory;
import io.cucumber.java.en.*;
import org.junit.Assert;


public class GoogleTrendsStepDef {
    BasePage basePage = new BasePage();
    Explore explore = new Explore();
    Compare compare = new Compare();


    @Given("I am on the google trends page")
    public void iAmOnTheGoogleTrendsPage() {
        String url = ConfigurationReader.getProperty("url");
        DriverFactory.getDriver().get(url);
        String expectedTitle= "Google Trends";
        BrowserUtils.assertTitle(expectedTitle);
    }

    @When("I enter first topic to the enter search term or a topic input box")
    public void iEnterSeleniumWebDriverToTheEnterSearchTermOrATopicInputBox() {
        String topic = ConfigurationReader.getProperty("firstTopic");
        basePage.searchTopic(topic);

    }

    @Then("You should be redirected to the explore page")
    public void youShouldBeRedirectedToTheExplorePage() {
        String expected = "Explore";
        Assert.assertEquals("Sustitle does not match ",expected, explore.getPageSubtitle());
    }

    @And("I enter second topic to the compare field")
    public void iEnterToTheCompareField() {
        String secondTopic=ConfigurationReader.getProperty("secondTopic");
        compare.compareTopic(secondTopic);
    }


    @Then("I should be on the compare page")
    public void iShouldBeOnTheComparePage() {
//        String expectedSubTitle= ConfigurationReader.getProperty("firstTopic")+", "+ConfigurationReader.getProperty("secondTopic")+" - Explore - Google Trends";
//        BrowserUtils.assertTitle(expectedSubTitle);
        String expectedSubtitle = "Compare";
        Assert.assertEquals("Subtitle does not match", expectedSubtitle, compare.getPageSubtitle());
    }


    @And("I select US, New York from the filters")
    public void iSelectUSNewYorkFromTheFilters() {
        compare.locationFilter("New York");
    }

    @And("I select 'Past 90 days' from the filters")
    public void iSelectPast90DaysFromTheFilters() {
        compare.timeRangeFilter();
    }

    @Then("I should be able to get the percentual ratio from the Compared breakdown by metro section")
    public void iShouldBeAbleToGetThePercentualRatioFromTheComparedBreakdownByMetroSection() {
        int firstTopicVolume = compare.volumeOfFirstTopic();
        System.out.println(ConfigurationReader.getProperty("firstTopic")+" volume is "+firstTopicVolume);
        Assert.assertTrue(firstTopicVolume>50);
    }
}
