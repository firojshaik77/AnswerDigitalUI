package org.testng.homepage;

import org.openqa.selenium.By;
import org.testng.propertymgr.PropertyManager;
import java.util.Properties;

/**
 * Purpose: Defines all the locators needed for executing the tests for contact us page.
 * @author Firoj Shaik
 *
 */
class ContactUsLocators {

    private final static Properties contactusProperties = new PropertyManager()
            .loadPropertyFile("contactus.properties");

    static final By contactUsLocator = By.linkText(contactusProperties
            .getProperty("contactUsLocator"));
    static By fullNameLocator = By.name(contactusProperties
            .getProperty("fullNameLocator"));
    static By emailLocator = By.name(contactusProperties
            .getProperty("emailLocator"));
    static By queryLocator = By.name(contactusProperties
            .getProperty("queryLocator"));
    static By submitButtonLocator = By.xpath(contactusProperties
            .getProperty("submitButtonLocator"));
    static By nameErrMsgLocator = By.xpath(contactusProperties
            .getProperty("nameErrMsgLocator"));
    static By emailErrMsgLocator = By.xpath(contactusProperties
            .getProperty("emailErrMsgLocator"));
    static By contactErrMsgLocator = By.xpath(contactusProperties
            .getProperty("contactErrMsgLocator"));
    static By chosenContactErrMsgLocator = By.xpath(contactusProperties
            .getProperty("chosenContactErrMsgLocator"));
   
}
