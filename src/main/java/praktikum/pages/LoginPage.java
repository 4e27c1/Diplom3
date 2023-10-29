package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    final WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public static final By LOGIN_BUTTON = By.xpath("//*[@id=\"root\"]/div/main/div/form/button");
    public static final By EMAIL_INPUT = By.xpath(".//input[@name='name']");
    public static final By PASSWORD_INPUT = By.xpath(".//input[@name='Пароль']");
    public static final  By MAKE_ORDER_BUTTON = By.xpath(".//button[text()='Оформить заказ']");

    public String findLogButton(){
        return driver.findElement(LOGIN_BUTTON).getText();
    }

    public Boolean loginButton1(){
        return driver.findElement(LOGIN_BUTTON).isDisplayed();
    }

    public LoginPage emailInput(String email){
        driver.findElement(EMAIL_INPUT).click();
        driver.findElement(EMAIL_INPUT).sendKeys(email);
        return this;
    }

    public LoginPage pwdInput(String password){
        driver.findElement(PASSWORD_INPUT).click();
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        return this;
    }

    public LoginPage clickLoginButton(){
        driver.findElement(LOGIN_BUTTON).click();
        return this;
    }

    public void login(String email, String password){
        emailInput(email);
        pwdInput(password);
        clickLoginButton();
    }
    public LoginPage waitWithDefaultTimeout(){
        new WebDriverWait(driver, Duration.ofSeconds(Environment.DEFAULT_TIMEOUT));
        return this;
    }

    public String findOrderButton(){
        return driver.findElement(MAKE_ORDER_BUTTON).getText();
    }
}
