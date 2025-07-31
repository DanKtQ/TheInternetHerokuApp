package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePageObject {

    private String pageUrl = "https://the-internet.herokuapp.com/secure";

    private By logOutButtonLocator = By.xpath("//a[@class='button secondary radius']");
    private By secureAreaLocator = By.id("flash");

    public SecureAreaPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    //get URL variable from PageObject
    public String getPageUrl() {
        return pageUrl;
    }

    public void waitForPageToLoad() {
        waitForUrlToLoad(pageUrl);
    }

    //method which return boolean for log out button
    public boolean isLogOutButtonVisible() {
        try {
            return driver.findElement(logOutButtonLocator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    //method which returns text of this message
    public String messageText() {
        return driver.findElement(secureAreaLocator).getText();
    }
}
