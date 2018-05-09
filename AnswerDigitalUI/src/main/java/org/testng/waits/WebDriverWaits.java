package org.testng.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Purpose: Defines all the methods needed for wait
 * @author Firoj Shaik
 *
 */
public class WebDriverWaits {

    private final int timeOut = 30;


    /**
     * @param driver
     * @param locator
     * @return
     * @throws TimeoutException
     */
    public WebElement waitForElementVisibility(WebDriver driver, By locator)
            throws TimeoutException {
        try {
            WebElement element;
            System.out.println("Waiting for the visibility of the element:" + locator);
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            element = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(locator));
            System.out.println("WebElement Visible. Proceeding further...");
            return element;
        } catch (TimeoutException tm) {
            throw new TimeoutException(
                    "Time Out Exception while waiting for the visibility of the element:" + locator + "\n");
        }
    }

    /**
     * @param driver
     * @param locator
     * @return
     * @throws TimeoutException
     */
    public WebElement waitForElementClickable(WebDriver driver, By locator)
            throws TimeoutException {
        try {
            WebElement element = null;
            System.out.println("Waiting for element to be clickable :" + locator);
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            System.out.println("WebElement Visible. Proceeding further...");
            return element;
        } catch (TimeoutException tm) {
            throw new TimeoutException(
                    "Time Out Exception while waiting for the element to be clickable:" + locator + "\n");
        }
    }

    /**
     * @param timeOut
     */
    public void waitForTimePeriod(int timeOut) {
        try {
            System.out.println("Thread.sleep activated for " + timeOut / 1000 + " seconds");
            Thread.sleep(timeOut);
            System.out.println("Ended after waiting for " + timeOut / 1000 + " seconds");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
