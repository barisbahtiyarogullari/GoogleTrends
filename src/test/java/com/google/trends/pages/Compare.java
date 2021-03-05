package com.google.trends.pages;

import com.google.trends.utilities.BrowserUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Compare extends BasePage{

    @FindBy(xpath = "//*[@id='explorepage-content-header']/explore-pills/div/button")
    private WebElement compareButton;

    @FindBy(xpath = "(//input[contains(@id,'input-')])[2]")
    private WebElement compareButton2;


    public void compareTopic(String secondTopic){
        compareButton.click();
        BrowserUtils.waitVisibilityOf(compareButton2);
        compareButton2.sendKeys(secondTopic+ Keys.ARROW_DOWN + Keys.ENTER);
    }


}
