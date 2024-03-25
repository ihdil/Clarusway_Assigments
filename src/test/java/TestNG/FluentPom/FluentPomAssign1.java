package TestNG.FluentPom;


import AssignmentOfPOM.lambdatest.Login;
import TestNG.BaseClassTestNG;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FluentPomAssign1 extends BaseClassTestNG {
    /*
        go to url : https://ecommerce-playground.lambdatest.io/index.php?route=account/register
        register account test with fluent page object approach
     */
    @Test(description = "Successful Login")
    public void loginTest1(){
        String actualText = new Login(driver,bot)
                .goTo()
                .Register((String) testCaseData.get("FirstName"), (String) testCaseData.get("LastName"),(String) testCaseData.get("email"),(String) testCaseData.get("telephoneNumber"),(String) testCaseData.get("password"))
                .assertMessage();
        Assert.assertEquals(actualText, (String) testCaseData.get("ExpectedSuccessMessage"));
        logger.info("Login was successful as expected!");
    }
    @BeforeClass
    public void initializeTestDataReader(){
        testCaseData = (JSONObject) testData.get("expandTesting");
    }
}