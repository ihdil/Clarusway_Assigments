package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class Assign1_5 {
    /*
    Create tests that depend on each other
    Create beforeClass and set up settings.
    By creating interdependent tests;
    First go to Facebook.
    Then go to Google depending on Facebook,
    Then go to Amazon depending on Google
    Close the driver.
     */
    WebDriver driver;
    WebDriverWait wait;
    //    Create beforeClass and set up settings.
    @BeforeClass
    public void beforeMethod(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // 10 seconds timeout

    }
    @Test
    public void FBMethod(){
//        First go to Facebook.
        driver.navigate().to("https://www.facebook.com/");
    }
    @Test(dependsOnMethods = "FBMethod")
    public void GoogleMethod(){
//        Then go to Google depending on Facebook,
        driver.navigate().to("https://www.google.com/");
    }
    @Test(dependsOnMethods = "GoogleMethod")
    public void AmazonMethod(){
//        Then go to Amazon depending on Google
        driver.navigate().to("https://www.amazon.com/");
    }

    @AfterClass
    public void afterMethod(){
        driver.quit();

    }}