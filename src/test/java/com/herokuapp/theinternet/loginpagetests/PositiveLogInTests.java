package com.herokuapp.theinternet.loginpagetests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.SecureAreaPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLogInTests extends TestUtilities {

    @Test
    public void logInTest() {
        log.info("Starting logIn test");

        // open main page
        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        welcomePage.openPage();

        // Click on Form Authentication link
        LoginPage loginPage = welcomePage.clickFormAuthenticationLink();

        // execute Login
        SecureAreaPage secureAreaPage = loginPage.logIn("tomsmith", "SuperSecretPassword!");

        // verifications
        // new url
        secureAreaPage.waitForPageToLoad();
        Assert.assertEquals(secureAreaPage.getCurrentUrl(), secureAreaPage.getPageUrl());

        // log out button is visible
        Assert.assertTrue(secureAreaPage.isLogOutButtonVisible(), "Log out button is not visible");

        // Successful log in message
        String expectedSuccessMessage = "You logged into a secure area!";
        String actualSuccessMessage = secureAreaPage.messageText();
        Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
                "actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
                        + expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);
    }
}
