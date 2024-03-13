package March16Assign;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Assign4 {
    /*
   Go to Amazon
   Scroll to the bottom of the page using a robot
   Click on the "Back to top" web element
   Click on the Amazon logo at the bottom of the page (in the footer) using JavascriptExecutor
   Use Actions to type "ClarusWay" in the search box and perform the search
*/
    protected WebDriverWait wait;
    WebDriver driver;
    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.amazon.com/stores/page/CDF3296F-98B9-4A3E-BCA2-4834A6E96166");
    }
    @Test
    public void testMethod() throws AWTException {
//        Scroll to the bottom of the page using a robot
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_PAGE_DOWN);
        r.keyRelease(KeyEvent.VK_PAGE_DOWN);

        //        Click on the "Back to top" web element
         driver.findElement(By.id("navBackToTop")).click();
//        Click on the Amazon logo at the bottom of the page (in the footer) using JavascriptExecutor
        WebElement logoToClick = driver.findElement(By.xpath("//a[@aria-label='Amazon US Home']"));
        JavascriptExecutor s = (JavascriptExecutor)driver;
        s.executeScript("arguments[0].click();",logoToClick);
//        Use Actions to type "ClarusWay" in the search box and perform the search
        Actions actions = new Actions(driver);
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        actions.sendKeys(searchBox, "ClarusWay").sendKeys(Keys.ENTER).perform();
    }

@AfterEach
public void quitTabs(){
    driver.quit();
}}