package org.testng.homepage;

import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.actions.BrowserActions;
import org.testng.annotations.*;
import org.testng.utilities.ExcelRead;
import static org.testng.homepage.WhoAreWeLocators.*;


/**
 * Purpose: Automate the validation messages on contact us form 
 * @author Firoj Shaik
 *
 */
public class WhoAreWePageTest extends BrowserActions {


    private final String catalystTxt;
    private String nurturationTxt;
    private String putLoveTxt;
    private String doRightTxt;
    private String neverStandTxt;


    /**
     * @param catalystTxt
     * @param nurturationTxt
     * @param putLoveTxt
     * @param doRightTxt
     * @param neverStandTxt
     */
    @Factory(dataProvider = "ReadAssertionValues")
    public WhoAreWePageTest(String catalystTxt, String nurturationTxt, String putLoveTxt,
                            String doRightTxt, String neverStandTxt) {
        this.catalystTxt = catalystTxt;
        this.nurturationTxt = nurturationTxt;
        this.putLoveTxt = putLoveTxt;
        this.doRightTxt = doRightTxt;
        this.neverStandTxt = neverStandTxt;

    }


    /**
     * @return Object array
     */
    @DataProvider(name = "ReadAssertionValues")
    public static Object[][] readInputsFromExcel() {
        Object[][] str1 = ExcelRead.readTestData("WhoAreWePageData");
        return str1;
    }


    /**
     * Test scenario:Go to 'who are we' link on the website and assert the values of company 
     */
    @Test(priority = 1)
    public void TestCase1() {

        try {
            click(whoAreWeLocator);

            Assert.assertTrue(compareElementValue(catalystLocator,
                    catalystTxt));
            Assert.assertTrue(compareElementValue(nurturationLocator,
                    nurturationTxt));
            Assert.assertTrue(compareElementValue(loveLocator,
                    putLoveTxt));
            Assert.assertTrue(compareElementValue(rightLocator,
                    doRightTxt));
            Assert.assertTrue(compareElementValue(standLocator,
                    neverStandTxt));


        } catch (TimeoutException tm) {


            tm.printStackTrace();
        } catch (AssertionError as) {


            Assert.fail(as.getMessage());
        }
    }


    /**
     * Test Scenario: go to 'who are we' link on the website and play the video 'Answer Atmosphere'
     */
    @Test(priority = 2)
    public void TestCase2() {

        try {
            click(whoAreWeLocator);
            play(atmosphereVideoLocator);
            pause(atmosphereVideoLocator);


        } catch (TimeoutException tm) {


            tm.printStackTrace();
        } catch (AssertionError as) {

            Assert.fail(as.getMessage());
        }
    }


    /**
     * 
     */
    @BeforeTest
    public void beforeTest() {
        openURL();

    }

    /**
     * 
     */
    @AfterTest
    public void afterTest() {
        closeBrowser();
    }
}


