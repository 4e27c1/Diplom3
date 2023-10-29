package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    final WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public static final By LOGIN_BUTTON = By.xpath(".//button[text()='Войти']");

    public String findLogButton(){
        return driver.findElement(LOGIN_BUTTON).getText();
    }
}
