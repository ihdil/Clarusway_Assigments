package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class Assign4_5 {

//Open the site: http://opencart.abstracta.us/index.php?route=account/login
//Login with that credentials
//Email: clarusway@gmail.com
//Password: 123456789
//Using the Search function do it with Data Provider for Mac, iPad and Samsung.

    WebDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // 5 seconds timeout
    }

    @Test
    public void MethodTest() {
        driver.navigate().to("http://opencart.abstracta.us/index.php?route=account/login");

        driver.findElement(By.id("input-email")).sendKeys("clarusway@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("123456789");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
    }
        @Test(dataProvider = "getData")
        public void TestTheValues(String search){
        driver.get("https://opencart.abstracta.us/index.php?route=account/account");
        driver.findElement(By.name("search")).sendKeys(search+ Keys.ENTER);
    }
@DataProvider
public Object[][] getData() {
    return new Object[][]{
            {"Mac"},
            {"iPad"},
            {"Samsung"},
    };
}
    @AfterClass
    public void afterMethod(){
        driver.quit();

    }
}