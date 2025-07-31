package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditorPage extends BasePageObject {

    private By editorLocator = By.id("tinymce");
    private By frame = By.tagName("iframe");

    public EditorPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /** Get text from TinyMCE WYSIWYG Editor */
    public String getEditorText() {
        switchToFrame(frame);
        waitForVisibilityOf(editorLocator);
        WebElement editor = find(editorLocator);

        // Use textContent instead of getText()
        String text = editor.getAttribute("textContent");
        log.info("Text from TinyMCE WYSIWYG Editor: " + text);

        driver.switchTo().defaultContent();
        return text;
    }

}