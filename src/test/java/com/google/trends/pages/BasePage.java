package com.google.trends.pages;

import com.google.trends.utilities.BrowserUtils;
import com.google.trends.utilities.DriverFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage(){
        PageFactory.initElements(DriverFactory.getDriver(),this);
    }

    @FindBy(id = "input-254")
    private WebElement enterASearchTermOrTopicInput;

    @FindBy(css = "h2[class='header-sub-title']")
    private WebElement pageSubtitle;
    @FindBy(xpath = "(//div[@class='hierarchy-select ng-pristine ng-valid'])[1]")
    private WebElement selectLocation;

    @FindBy(xpath = "//div[@class='hierarchy-autocomplete']//input")
    private WebElement inputLocation;

    @FindBy(xpath = "//*[@id='compare-pickers-wrapper']//custom-date-picker")
    private WebElement timeRange;

    @FindBy(xpath = "//div[contains(text(),'Past 90 days')]")
    private WebElement selectTime;

    @FindBy(css = "div[class='label-text multi-heat-item']")
    private WebElement comparedBreakDownNY;

    @FindBy(xpath = "//span[@class='progress-bar-multi-heat-volume']")
    private WebElement barVolume;



    public void locationFilter (String location){
        selectLocation.click();
        inputLocation.sendKeys(location +Keys.ARROW_DOWN+Keys.ENTER);
    }
    public void timeRangeFilter(){
        BrowserUtils.waitClickableOf(timeRange);
        BrowserUtils.wait(1);
        timeRange.click();
        BrowserUtils.waitVisibilityOf(selectTime);
        selectTime.click();
    }

    public int volumeOfFirstTopic(){
        String volume = barVolume.getAttribute("style");
        return Integer.parseInt( (volume.substring(volume.length()-5,volume.length()-2)).trim() );
    }

    public void searchTopic(String topic){
        BrowserUtils.waitVisibilityOf(enterASearchTermOrTopicInput);
        enterASearchTermOrTopicInput.click();
        enterASearchTermOrTopicInput.sendKeys(topic, Keys.ENTER);
    }

    public String getPageSubtitle(){
        return pageSubtitle.getText();
    }

}
