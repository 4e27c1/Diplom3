package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LKPage {

    final WebDriver driver;

    public LKPage(WebDriver driver) {
        this.driver = driver;
    }

    public static final By PROFILE = By.xpath("//a[text() = 'Профиль']");
    public static final By CONSTRUCTOR = By.xpath("//p[text()='Конструктор']");
    public static final By LOGO = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']");
    public static final By LOGOUT_LINK = By.xpath(".//button[text()='Выход']");

    public LKPage open() {
        driver.get(Environment.LK);
        return this;
    }

    public LKPage profileLinkClick() {
        driver.findElement(PROFILE).click();
        return this;
    }

    public LKPage constructorClick() {
        driver.findElement(CONSTRUCTOR).click();
        return this;
    }

    public LKPage logoClick() {
        driver.findElement(LOGO).click();
        return this;
    }

    public LKPage logoutClick() {
        driver.findElement(LOGOUT_LINK).click();
        return this;
    }
}
