package org.testng.homepage;

import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.actions.BrowserActions;
import org.testng.annotations.*;
import org.testng.utilities.ExcelRead;

import static org.testng.homepage.ContactUsLocators.*;

/**
 * Purpose: Automate the validation messages on contact us form 
 * @author Firoj Shaik
 *
 */
public class ContactUsPageTest extends BrowserActions {

    private final String nameValue;
    private String emailValue;
    private String queryValue;
    private String nameErrMsg;
    private String emailErrMsg;
    private String contactErrMsg;
    private String chosenContactErrMsg;


    /**
     * @param nameValue
     * @param emailValue
     * @param queryValue
     * @param nameErrMsg
     * @param emailErrMsg
     * @param contactErrMsg
     * @param chosenContactErrMsg
     */
    @Factory(dataProvider = "ReadInputValues")
    public ContactUsPageTest(String nameValue, String emailValue, String queryValue,
                             String nameErrMsg, String emailErrMsg,
                             String contactErrMsg, String chosenContactErrMsg) {
        this.nameValue = nameValue;
        this.emailValue = emailValue;
        this.queryValue = queryValue;
        this.nameErrMsg = nameErrMsg;
        this.emailErrMsg = emailErrMsg;
        this.contactErrMsg = contactErrMsg;
        this.chosenContactErrMsg = chosenContactErrMsg;
    }


    /**
     * @return
     */
    @DataProvider(name = "ReadInputValues")
    public static Object[][] readInputsFromExcel() {
        Object[][] str = ExcelRead.readTestData("ContactUsPageData");
        return str;
    }


    /**
     * Test case to send query on empty form and assert validation messages
     */
    @Test(priority = 1)
    public void TestCase1() {

        try {
            click(contactUsLocator);
            jsClick(submitButtonLocator);
            Assert.assertTrue(compareElementValue(nameErrMsgLocator,
                    nameErrMsg));
            Assert.assertTrue(compareElementValue(emailErrMsgLocator,
                    emailErrMsg));
            Assert.assertTrue(compareElementValue(contactErrMsgLocator,
                    contactErrMsg));
            Assert.assertTrue(compareElementValue(chosenContactErrMsgLocator,
                    chosenContactErrMsg));


        } catch (TimeoutException tm) {


            tm.printStackTrace();
        } catch (AssertionError as) {


            Assert.fail(as.getMessage());
        }
    }

    /**
     * Test case to Fill out Name and email only and send query and assert error messages
     */
    @Test(priority = 2)
    public void Testcase2() {

        try {
            click(contactUsLocator);
            enterText(fullNameLocator, nameValue);
            enterText(emailLocator, emailValue);
            jsClick(submitButtonLocator);
            Assert.assertTrue(compareElementValue(contactErrMsgLocator,
                    contactErrMsg));
            Assert.assertTrue(compareElementValue(chosenContactErrMsgLocator,
                    chosenContactErrMsg));


        } catch (TimeoutException tm) {


            tm.printStackTrace();
        } catch (AssertionError as) {


            Assert.fail(as.getMessage());
        }
    }

    /**
     * Test case to Fill out name , email and message but do not select who is the query for and assert error message
     */
    @Test(priority = 3)
    public void Testcase3() {

        try {
            click(contactUsLocator);
            enterText(fullNameLocator, nameValue);
            enterText(emailLocator, emailValue);
            enterText(queryLocator, queryValue);
            jsClick(submitButtonLocator);
            Assert.assertTrue(compareElementValue(chosenContactErrMsgLocator,
                    chosenContactErrMsg));


        } catch (TimeoutException tm) {


            tm.printStackTrace();
        } catch (AssertionError as) {

            Assert.fail(as.getMessage());
        }
    }


    /**
     * Invoke the method for driver initialization.
     */
    @BeforeTest
    public void beforeTest() {
        openURL();

    }

    /**
     * Invoke to method to close the browser and reset the driver.
     */
    @AfterTest
    public void afterTest() {
        closeBrowser();

    }
}


