package March16Assign;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class Assign7 {
    // Go to amazon.com
    // Take Full Page Screenshot.
    // Take any spesific WebElement ScreenShot
    protected WebDriver driver;
    @BeforeEach
    public void beforeEach() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
    }
    @Test
    public void screenShot() throws IOException {
        // Go to amazon.com
        driver.get("https://www.amazon.com/");
        TakesScreenshot ss = (TakesScreenshot)driver;
        // Take Full Page Screenshot.
        File fullScreenShot = ss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(fullScreenShot,new File("C:\\Users\\hadee\\IdeaProjects\\Assignments\\Test-output\\ScreenShots\\image1.png"));
        // Take any spesific WebElement ScreenShot
        WebElement amazonlogo = driver.findElement(By.xpath("//i[@class='a-icon a-logo']"));
        File amazonslogo = amazonlogo.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(amazonslogo,new File("C:\\Users\\hadee\\IdeaProjects\\Assignments\\Test-output\\ScreenShots\\image2.png"));
    }
    @AfterEach
    public void quitTab() {
        driver.quit();


    }
}
