package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;


public class Assign5_5 {
    //Go to URL: http://crossbrowsertesting.github.io/
    //Click to To-Do App
    //Checking Box to do-4 and Checking Box to do-5
    //If both clicks worked, then the following List should be have length 2.
    //Assert that this is correct
    //Assert that the to do we added is present in the list
    //Archiving old todos
    //If our archive link worked, then the following list should have length 4.
    //Assert that this is true as well
    //Doing Cross Browser Testing.
    WebDriver driver;
    WebDriverWait wait;

    @Parameters({"target-browser"})
    @BeforeClass
    public void beforeMethod(String targetBrowser){
        switch (targetBrowser) {
            case "chrome" -> driver = new ChromeDriver();
            case "firefox" -> driver = new FirefoxDriver();
            case "edge" -> driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // 10 seconds timeout

    }

    @Test
    public void Assign5() {

        driver.navigate().to("http://crossbrowsertesting.github.io/");
        driver.findElement(By.xpath("//a[@href='todo-app.html']")).click();
        //Checking Box to do-4 and Checking Box to do-5
        //If both clicks worked, then the following List should be have length 2.
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        checkboxes.get(3).click();
        checkboxes.get(4).click();
        int selectedCheckboxCount = 0;
        for (WebElement checkbox : checkboxes) {
            if (checkbox.isSelected()) {
                // If selected, increment the counter
                selectedCheckboxCount++;
            }
        }
        Assert.assertEquals(selectedCheckboxCount, 2);
        //Assert that the to do we added is present in the list
        driver.findElement(By.id("todotext")).sendKeys("Do the HW");
        driver.findElement(By.id("addbutton")).click();
        for (WebElement newToDo : checkboxes) {
            Assert.assertTrue(newToDo.isDisplayed(), "The added to-do item is not present in the list");
        }

        //Archiving old todos
        driver.findElement(By.xpath("//a[@ng-click='todoList.archive()']")).click();
        List<WebElement> checkboxes1 = driver.findElements(By.xpath("//span[@class='done-false']"));
        int newTotal = checkboxes1.size();
            Assert.assertEquals(newTotal, 4);
        }



@AfterClass
public void afterMethod(){
    driver.quit();

}}