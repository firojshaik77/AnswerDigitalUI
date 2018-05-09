package org.testng.homepage;

import org.openqa.selenium.By;
import org.testng.propertymgr.PropertyManager;

import java.util.Properties;

/**
 * Purpose: Defines all the locators needed for executing the tests for who are we page.
 * @author Firoj Shaik
 *
 */
class WhoAreWeLocators {

    private final static Properties whoAreWeProperties = new PropertyManager()
            .loadPropertyFile("who_are_we.properties");

    static final By whoAreWeLocator = By.linkText(whoAreWeProperties
            .getProperty("whoAreWeLocator"));
    static By catalystLocator = By.xpath(whoAreWeProperties
            .getProperty("catalystLocator"));
    static By nurturationLocator = By.xpath(whoAreWeProperties
            .getProperty("nurturationLocator"));
    static By loveLocator = By.xpath(whoAreWeProperties
            .getProperty("loveLocator"));
    static By rightLocator = By.xpath(whoAreWeProperties
            .getProperty("rightLocator"));
    static By standLocator = By.xpath(whoAreWeProperties
            .getProperty("standLocator"));
    static By atmosphereVideoLocator = By.xpath(whoAreWeProperties
            .getProperty("atmosphereVideoLocator"));


}
