//package March16Assign;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WindowType;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//
//import java.util.ArrayList;
//import java.util.Set;
//
//public class Assign1 {
//    //Go to URL: https://the-internet.herokuapp.com/windows
//    //Verify the text: “Opening a new window”
//    //Verify the title of the page is “The Internet”
//    //Click on the “Click Here” button
//    //Verify the new window title is “New Window”
//    //Go back to the previous window and then verify the title: “The Internet”
//    WebDriver driver;
//
//    @BeforeEach
//    public void setUp(){
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.navigate().to("https://testpages.eviltester.com/styled/index.html");
//    }
//
//    @Test
//    public void testMethod() {
//        //Verify the text: “Opening a new window”
//        String text = driver.findElement(By.tagName("h3")).getText();
//        Assertions.assertEquals("Opening a new window", text , "They Are Not Matched!");
//        String current1 = driver.getWindowHandle();
//        //Verify the title of the page is “The Internet”
//        String TitleText= driver.getTitle();
//        Assertions.assertEquals("The Internet",TitleText);
//        //Click on the “Click Here” button
//        driver.findElement(By.linkText("Click Here")).click();
//        Set<String> WindowsHandles1 = driver.getWindowHandles();
//        for (String w : WindowsHandles1){
//            if(!w.equals(current1)){
//                driver.switchTo().window(w);
//            }
//        }
//        String current2 = driver.getWindowHandle();
//        //Verify the new window title is “New Window”
//        Assertions.assertEquals("New Window",driver.getTitle());
//        //Go back to the previous window and then verify the title: “The Internet”
//        driver.switchTo().window(new ArrayList<>(driver.getWindowHandles()).get(0));
////        Set<String> WindowsHandles2 = driver.getWindowHandles();
////        for (String w : WindowsHandles2){
////            if(!w.equals(current2)){
////                driver.switchTo().window(w);
////            }
////        }
//        Assertions.assertEquals("The Internet",driver.getTitle(),"not matched");
//    }
//    @AfterEach
//    public void quitTabs(){
//        driver.quit();
//    }}
