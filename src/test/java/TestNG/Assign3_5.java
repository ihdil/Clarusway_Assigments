package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Assign3_5 {
    /* go to "https://practicetestautomation.com/practice-test-login/"
enter username - "student"
enter password - "incorrectPassword"
and login
SOFT ASSERT the error message shown
SOFT ASSERT the error message is "Your password is invalid!" */
    WebDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void beforeMethod(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // 10 seconds timeout

    }
    @Test
    public void FBMethod() {
//        enter username - "student"
//        enter password - "incorrectPassword"
//        and login
        driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("incorrectPassword");
        driver.findElement(By.id("submit")).click();
        SoftAssert softAssert = new SoftAssert();
        WebElement errorMessage = driver.findElement(By.id("error"));
//        SOFT ASSERT the error message shown
        softAssert.assertTrue(errorMessage.isDisplayed());
//        SOFT ASSERT the error message is "Your password is invalid!" */
        softAssert.assertEquals(errorMessage.getText(),"Your password is invalid!");
        softAssert.assertAll();

    }

    @AfterClass
    public void afterMethod(){
        driver.quit();

    }}

