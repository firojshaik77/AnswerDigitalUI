package org.testng.driverinit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.propertymgr.PropertyManager;


import java.util.Properties;

/**
 * Purpose: Defines all the methods needed for driver initialization.
 * @author Firoj Shaik
 *
 */
public class DriverInitialization {

    private static final Properties browserName = new PropertyManager()
            .loadPropertyFile("application.properties");

    private static WebDriver driver = null;

    /**
     * Method to initialization the driver based the browser property.
     * @return WebDriver
     */
    public static WebDriver getDriver() {

        if (driver == null) {

            if ("IE".equals(browserName.getProperty("browser"))) {
                System.out.println("**Internet Explorer Browser**");
                System.setProperty("webdriver.ie.driver",
                        ".\\src\\main\\resources\\org\\drivers\\IEDriverServer.exe");
                System.out.println("Launching the Internet Explorer Browser");
                driver = new InternetExplorerDriver();
            } else if ("FF".equals(browserName.getProperty("browser"))) {
                System.out.println("**FireFox Browser**");
                System.setProperty("webdriver.gecko.driver",
                        ".\\src\\main\\resources\\org\\drivers\\geckodriver.exe");
              DesiredCapabilities caps = new DesiredCapabilities();

                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "7");
                caps.setCapability("browser", "Firefox");
                caps.setCapability("browser_version", "46.0");
                caps.setCapability("marionette", false);
                System.out.println("Launching FireFox Browser"); 
                driver = new FirefoxDriver(caps);

            } else if ("CH".equals(browserName.getProperty("browser"))) {
                System.out.println("**Chrome Browser**");
                System.setProperty("webdriver.chrome.driver",
                        ".\\src\\main\\resources\\org\\drivers\\chromedriver.exe");
                System.out.println("Launching the Chrome Browser");
                driver = new ChromeDriver();
            }
        }
        System.out.println("Returning the instance of:" + driver.toString());
        return driver;
    }

    /**
     * Method for resetting driver.
     */
    public static void resetDriver() {
        System.out.println("Resetting the instance of:" + driver.toString() + " to null");
        driver = null;
    }

}
