package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    final WebDriver driver;
    public MainPage (WebDriver driver){
        this.driver = driver;
    }

    public static final By VOITI_V_ACCOUNT_BUTTON = By.xpath(".//button[text()='Войти в аккаунт']");
    public static final By LK_LINK = By.xpath("//*[@id=\"root\"]/div/header/nav/a/p");

    public MainPage open() {
        driver.get(Environment.BASE_URL);
        return this;
    }

    public MainPage enterAccountClick(){
        driver.findElement(VOITI_V_ACCOUNT_BUTTON).click();
        return  this;
    }

    public MainPage lkClick(){
        driver.findElement(LK_LINK).click();
        return this;
    }

    public MainPage waitWithDefaultTimeout(){
        new WebDriverWait(driver, Duration.ofSeconds(Environment.DEFAULT_TIMEOUT));
        return this;
    }
}
