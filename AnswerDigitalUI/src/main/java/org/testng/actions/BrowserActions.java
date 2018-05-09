package org.testng.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.driverinit.DriverInitialization;
import org.testng.propertymgr.PropertyManager;

import org.testng.waits.WebDriverWaits;

import java.util.Properties;

/**
 * Purpose: Defines all the browser actions needed to execute the tests.
 * @author Firoj Shaik
 *
 */
public class BrowserActions {


    private final Properties applicationProperty = new PropertyManager()
            .loadPropertyFile("application.properties");
    private final WebDriverWaits wait = new WebDriverWaits();
    private WebDriver driver;


    /**
     * Method for driver initialization.
     */
    protected void openURL() {
        try {
            driver = DriverInitialization.getDriver();

            System.out.println("Navigating to Application URL:"
                    + applicationProperty.getProperty("applicationURL"));
            driver.get(applicationProperty.getProperty("applicationURL"));
            driver.manage().window().maximize();
            System.out.println("Successfully navigated to the Application URL");
        } catch (Exception ex) {
            System.out.println("Error in navigating the URL:"
                    + applicationProperty.getProperty("applicationURL"));
            ex.printStackTrace();
            closeBrowser();
        }
    }

    /**
     * Method to reset the driver.
     */
    protected void closeBrowser() {
        System.out.println("Closing the browser");
        driver.quit();
        DriverInitialization.resetDriver();
        System.out.println("Successfully closed the browser" + "\n");
    }

    /**
     * Method for entering the value in the given element.
     * @param element
     * @param value
     * @throws TimeoutException
     */
    protected void enterText(By element, String value) throws TimeoutException {
        wait.waitForElementVisibility(driver, element).clear();
        driver.findElement(element).sendKeys(value);
        System.out.println("Entered text:" + value + " in text box with locator:" + element);
    }

    /**
     * Method for click action.
     * @param element
     * @throws TimeoutException
     */
    protected void click(By element) throws TimeoutException {

        wait.waitForElementClickable(driver, element).click();
        System.out.println("Clicked on element with locator:" + element);
    }

    /**
     * Method for playing video.
     * @param element
     * @throws TimeoutException
     */
    protected void play(By element) throws TimeoutException {
        wait.waitForElementClickable(driver, element).click();
        System.out.println("Play video by clicking on element with locator:" + element);
        wait.waitForTimePeriod(10000);
    }

    /**
     * Method to pause video.
     * @param element
     * @throws TimeoutException
     */
    protected void pause(By element) throws TimeoutException {
        wait.waitForElementClickable(driver, element).click();
        System.out.println("Pause video by clicking on element with locator:" + element);

    }

    /**
     * Method for button click using JavascriptExecutor.
     * @param element
     * @throws TimeoutException
     */
    protected void jsClick(By element) throws TimeoutException {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", wait.waitForElementClickable(driver, element));
        System.out.println("Clicked on element with locator:" + element);
    }

    /**
     * Method for comparison of the value present in the element with the expected value.
     * @param element
     * @param expected
     * @return
     */
    protected boolean compareElementValue(By element, String expected) {
        System.out.println("Result of Element Value comparison is " + wait.waitForElementVisibility(driver, element).getText().equals(expected));
        return wait.waitForElementVisibility(driver, element).getText().equals(expected);
    }


}
