package com.google.trends.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;


public class Explore extends BasePage{


    @FindBy(xpath = "(//*[contains(@id,'input-')])[1]")
    public WebElement searchTopic;


}
