//package March16Assign;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//
//public class Assign3 {
////( This task should be managed with keyboard actions )
//// go to https://www.google.com/
//// search for "Scroll Methods" by using an Actions object
//
//    WebDriver driver;
//    @BeforeEach
//    public void setUp(){
//    driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.navigate().to("https://www.google.com/");
//}
//@Test
//    public void searchingByAction(){
//    WebElement element = driver.findElement(By.id("APjFqb"));
//    Actions actions = new Actions(driver);
//    actions.sendKeys(element, "Scroll Methods").sendKeys(Keys.ENTER).perform();
//    Assertions.assertNotEquals("","Scroll Methods");
//
//}
//
//    @AfterEach
//    public void quitTabs(){
//        driver.quit();
//    }}
