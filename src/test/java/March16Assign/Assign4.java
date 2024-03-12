package March16Assign;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;

public class Assign4 {
    /*
   Go to Amazon
   Scroll to the bottom of the page using a robot
   Click on the "Back to top" web element
   Click on the Amazon logo at the bottom of the page (in the footer) using JavascriptExecutor
   Use Actions to type "ClarusWay" in the search box and perform the search
*/
    WebDriver driver;
    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.amazon.com/");
    }
    @Test
    public void testMethod() throws AWTException {
//        Scroll to the bottom of the page using a robot
        Robot r = new Robot();
        r.mouseWheel(4);
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
}
