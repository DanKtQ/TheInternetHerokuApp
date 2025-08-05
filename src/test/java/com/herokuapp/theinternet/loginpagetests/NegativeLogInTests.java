package com.herokuapp.theinternet.loginpagetests;

import com.herokuapp.theinternet.base.CsvDataProviders;
import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class NegativeLogInTests extends TestUtilities {

    @Test(priority = 1, dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
    public void negativeLogInTest(Map<String, String> testData) {
        // Data
        String no = testData.get("no");
        String username  = testData.get("username");
        String password = testData.get("password");
        String expectedErrorMessage = testData.get("expectedMessage");
        String description = testData.get("description");

        log.info("Starting negativeLogInTest #" + no + " for " + description);

        // open main page
        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        welcomePage.openPage();

        // Click on Form Authentication link
        LoginPage loginPage = welcomePage.clickFormAuthenticationLink();

        // enter username and password
        loginPage.negativeLogIn(username, password);

        // Verification
        loginPage.waitForMessageTextToLoad();
        String actualErrorMessage = loginPage.messageText();
        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),"actualErrorMessage does not contain expected text.");
    }

}
