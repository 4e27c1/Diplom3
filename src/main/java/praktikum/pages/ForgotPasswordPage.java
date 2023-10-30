package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    final WebDriver driver;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public static final By LOGIN_BUTTON = By.xpath("//*[@id=\"root\"]/div/main/div/div/p/a");

    public ForgotPasswordPage open(){
        driver.get(Environment.FORGOT_PASSWORD);
        return this;
    }

    public void clickLoginButton(){
        driver.findElement(LOGIN_BUTTON).click();
    }
}
