package AssignmentOfPOM.lambdatest;

import engine.ActionBot;
import engine.PropertiesReader;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends Pages{
    private final String url = PropertiesReader.props.getProperty("baseUrl");
    private final By firstNameInput = By.xpath("//input[@id='input-firstname']"); //practice
    private final By lastNameInput = By.xpath("//input[@id='input-lastname']"); //SuperSecretPassword!
    private final By emailInput = By.xpath("//input[@id='input-email']"); //SuperSecretPassword!
    private final By telephoneInput = By.xpath("//input[@id='input-telephone']"); //SuperSecretPassword!
    private final By passwordInput = By.xpath("//input[@id='input-password']");
    private final By passwordConInput = By.xpath("//input[@id='input-confirm']");
    private final By clikOnCheck = By.xpath("//input[@id='input-agree']");

    private final By continueButton = By.xpath("//input[@type='submit']");
    private final By flashMessageLabel = By.xpath("//h1[@class='page-title my-3']");

    public Login(WebDriver driver, ActionBot bot) {
        super(driver, bot);
    }

    @Step("Given I am on the login page")
    public Login goTo(){
        bot.navigate(url);
        return this;
    }

//    @Step ("When I successfully perform the login action")
//    public Secure successfulLogin(String username, String password){
//        login(username, password);
//        return new Secure(driver,bot);
//    }

    @Step ("When I fail to perform the login action")
    public Login Register(String firstName, String lastName , String email,String telephone,String password){
        login(firstName, lastName,email,telephone,password);
        return this;
    }

    private void login(String firstName, String lastName , String email,String telephone,String password){
        bot.type(firstNameInput, firstName);
        bot.type(lastNameInput, lastName);
        bot.type(emailInput, email);
        bot.type(telephoneInput, telephone);
        bot.type(passwordInput, password);
        bot.type(passwordConInput, password);
        bot.click(clikOnCheck);
        bot.click(continueButton);
    }

    @Step ("Then I will be see an error message")
    public String assertMessage(){
        return bot.getText(flashMessageLabel);
    }

}
