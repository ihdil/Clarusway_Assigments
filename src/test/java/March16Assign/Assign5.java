package March16Assign;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assign5 {
     /*   Go to URL: http://facebook.com
        getCookies,
        addCookie,
        deleteCookieNamed,
        deleteAllCookies
     */
     WebDriver driver;

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://facebook.com");
    }
    @Test
    public void testCookies(){
//        getCookies,
        var cookie = driver.manage().getCookies();
        int numberOfCookies = cookie.size();
        System.out.println("---------------"+numberOfCookies);
//        addCookie

        driver.manage().addCookie(new Cookie("new Cookie","i am a new cookie hehehe"));
        var cookie2= driver.manage().getCookies();
        int numberOfCookies2 = cookie2.size();
        System.out.println("---------------"+numberOfCookies2);

//        deleteCookieNamed
        driver.manage().deleteCookieNamed("dpr");
//        deleteAllCookies
        driver.manage().deleteAllCookies();
        var cookie3 = driver.manage().getCookies();
        int numberOfCookies3 = cookie3.size();
        System.out.println("---------------"+numberOfCookies3);
    }




    @AfterEach
    public void quitTabs(){
        driver.quit();
    }}

