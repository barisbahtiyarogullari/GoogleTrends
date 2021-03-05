package com.google.trends.utilities;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {

    public static Wait wait = new WebDriverWait(DriverFactory.getDriver(),15);

    public static void assertTitle(String expectedTitle){
        String actualTitle = DriverFactory.getDriver().getTitle();
        Assert.assertEquals("Title does not match",expectedTitle,actualTitle);
    }

    public static void waitVisibilityOf(WebElement we){
        wait.until(ExpectedConditions.visibilityOf(we));
    }

    public static void waitClickableOf(WebElement we){
        wait.until(ExpectedConditions.elementToBeClickable(we));
    }

    public static void wait(int second){
        try {
            Thread.sleep(second* 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void scroll(WebElement we){
        ((JavascriptExecutor)DriverFactory.getDriver()).executeScript("arguments[0].scrollIntoView(true)",we);
    }






}

