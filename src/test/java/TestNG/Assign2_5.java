package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Assign2_5 {
    //Go to URL: https://opensource-demo.orangehrmlive.com/
    //Login with negative credentilas by Data Provider.
    //Then assert that ‘’Invalid credentials’’ is displayed.
    //Run it parallel with 3 threads
    //Generate Allure report
//    @DataProvider
//    public Object[][] getData(){
//        return new Object[][]{
//                {"admin*","admin123"},
//                {"admin12","123"},
//                {"Admin1","***00**"},
//                {"test","123"},
//                {"user","369"},
//        }
//    };

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeMethod(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Increased timeout to 10 seconds
    }

    @Test( dataProvider = "getData" )
    public void dataProvider(String username, String pass){
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
        //Login page valid credentials.
        wait.until(f -> {
            driver.findElement(By.name("username")).sendKeys(username);
            return true;
        });

        driver.findElement(By.name("password")).sendKeys(pass);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        // Assert that 'Invalid credentials' is displayed
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-alert oxd-alert--error']")));
        Assert.assertTrue(errorMessage.isDisplayed(), "Invalid credentials message is not displayed for username: " + username + " and password: " + pass);

    }
    @DataProvider
    public Object[][] getData() {
        return new Object[][]{
                {"admin*", "admin123"},
                {"admin12", "123"},
                {"Admin1", "***00**"},
                {"test", "123"},
                {"user", "369"}
        };
    }


    @AfterClass
    public void afterMethod(){
        driver.quit();
    }}

