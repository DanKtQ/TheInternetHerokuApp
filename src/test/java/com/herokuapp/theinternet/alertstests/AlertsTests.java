package com.herokuapp.theinternet.alertstests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.JavaScriptAlertsPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;

public class AlertsTests extends TestUtilities {

    @Test
    public void jsAlertTest() {
        log.info("Starting jsAlertTest");

        // open main page
        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        welcomePage.openPage();

        // Click on JavaScript Alerts link
        JavaScriptAlertsPage alertsPage = welcomePage.clickJavaScriptAlertsLink();

        // Click JS Alert button
        alertsPage.openJSAlert();
        sleep(1000);

        // Get alert text
        String alertMessage = alertsPage.getAlertText();

        // Click OK button
        alertsPage.acceptAlert();

        // Get Results text
        String result = alertsPage.getResultText();
        sleep(1000);
        // Verifications
        // 1 - Alert text is expected
        Assert.assertTrue(alertMessage.equals("I am a JS Alert"),
                "Alert message is not expected. \nShould be 'I am a JS Alert', but it is '" + alertMessage + "'");

        // 2 - Result text is expected
        Assert.assertTrue(result.equals("You successfully clicked an alert"),
                "result is not expected. \nShould be 'You successfuly clicked an alert', but it is '" + result + "'");
    }

    @Test
    public void jsDismissTest() {
        log.info("Starting jsDismissTest");

        // open main page
        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        welcomePage.openPage();

        // Click on JavaScript Alerts link
        JavaScriptAlertsPage alertsPage = welcomePage.clickJavaScriptAlertsLink();

        // Click JS Confirm button
        alertsPage.openJSConfirm();
        sleep(1000);
        // Get alert text
        String alertMessage = alertsPage.getAlertText();

        // Click Cancel button
        alertsPage.dismissAlert();

        // Get Results text
        String result = alertsPage.getResultText();
        sleep(1000);
        // Verifications
        // 1 - Alert text is expected
        Assert.assertTrue(alertMessage.equals("I am a JS Confirm"),
                "Alert message is not expected. \nShould be 'I am a JS Confirm', but it is '" + alertMessage + "'");

        // 2 - Result text is expected
        Assert.assertTrue(result.equals("You clicked: Cancel"),
                "result is not expected. \nShould be 'You clicked: Cancel', but it is '" + result + "'");
    }

    @Test
    public void jsPromptTest() {
        log.info("Starting jsDismissTest");

        // open main page
        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        welcomePage.openPage();

        // Click on JavaScript Alerts link
        JavaScriptAlertsPage alertsPage = welcomePage.clickJavaScriptAlertsLink();

        // Click JS Prompt button
        alertsPage.openJSPrompt();
        sleep(1000);
        // Get alert text
        String alertMessage = alertsPage.getAlertText();

        // Type text into alert
        alertsPage.typeTextIntoAlert("Hello Alert, it's Thor here");
        sleep(1000);
        // Get Results text
        String result = alertsPage.getResultText();
        sleep(1000);
        // Verifications
        // 1 - Alert text is expected
        Assert.assertTrue(alertMessage.equals("I am a JS prompt"),
                "Alert message is not expected. \nShould be 'I am a JS prompt', but it is '" + alertMessage + "'");

        // 2 - Result text is expected
        Assert.assertTrue(result.equals("You entered: Hello Alert, it's Thor here"),
                "result is not expected. \nShould be 'You entered: Hello Alert, its Thor here', but it is '" + result
                        + "'");
    }
}