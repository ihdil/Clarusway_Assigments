package March16Assign;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assign2 {

     /*
Go to URL: http://demo.guru99.com/test/drag_drop.html
Drag and drop the BANK button to the Account section in DEBIT SIDE
Drag and drop the SALES button to the Account section in CREDIT SIDE
Drag and drop the 5000 button to the Amount section in DEBIT SIDE
Drag and drop the second 5000 button to the Amount section in CREDIT SIDE
Verify the visibility of Perfect text.
*/
     WebDriver driver;
//    Actions action ;
    protected WebDriverWait wait;


    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://demo.guru99.com/test/drag_drop.html");
//        action = new Actions(driver);

    }

    @Test
    public void testMethods() {
        testMethod1();
        testMethod2();
        testMethod3();
        testMethod4();
        String perfectText = driver.findElement(By.xpath("(//a[@class='button button-green'])[1]")).getText();
        Assertions.assertEquals("Perfect!",perfectText);
    }


    public void testMethod1(){
//        Drag and drop the BANK button to the Account section in DEBIT SIDE
        WebElement bank = driver.findElement(By.id("credit2"));
        WebElement Account_section_in_DEBIT = driver.findElement(By.xpath("(//div[@class='ui-widget-content'])[2]"));
        new org.openqa.selenium.interactions.Actions(driver).dragAndDrop(bank, Account_section_in_DEBIT).perform();}
    public void testMethod2(){
//        Drag and drop the SALES button to the Account section in CREDIT SIDE
        WebElement sales = driver.findElement(By.id("credit1"));
            WebElement Account_section_in_CREDIT = driver.findElement(By.xpath("(//div[@class='ui-widget-content'])[4]"));
        new org.openqa.selenium.interactions.Actions(driver).dragAndDrop(sales, Account_section_in_CREDIT).perform();}
    public void testMethod3(){
//        Drag and drop the 5000 button to the Amount section in DEBIT SIDE
        WebElement Number1 = driver.findElement(By.xpath("(//li[@class='block13 ui-draggable'])[1]"));
        WebElement Amount_section_in_DEBIT = driver.findElement(By.xpath("(//div[@class='ui-widget-content'])[3]"));
        new org.openqa.selenium.interactions.Actions(driver).dragAndDrop(Number1, Amount_section_in_DEBIT).perform();}

    public void testMethod4() {
//        Drag and drop the second 5000 button to the Amount section in CREDIT SIDE
        WebElement Number2 = driver.findElement(By.xpath("(//li[@class='block13 ui-draggable'])[2]"));
        WebElement Amount_section_in_CREDIT = driver.findElement(By.xpath("(//div[@class='ui-widget-content'])[5]"));
        new org.openqa.selenium.interactions.Actions(driver).dragAndDrop(Number2, Amount_section_in_CREDIT).perform();
    }



    @AfterEach
    public void quitTabs(){
        driver.quit();
    }}
