package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LKPage {

    final WebDriver driver;
    public LKPage(WebDriver driver){
        this.driver = driver;
    }
    public static final By PROFILE = By.xpath("//*[@id=\"root\"]/div/main/div/nav/ul/li[1]/a");
    public static final By CONSTRACTOR = By.xpath("//p[text()='Конструктор']");



    public LKPage open(){
        driver.get(Environment.LK);
        return this;
    }

    public String getProfileLink(){
        return driver.findElement(PROFILE).getText();
    }

    public LKPage profileLinkClick(){
        driver.findElement(PROFILE).click();
        return this;
    }

    public LKPage constructorClick(){
        driver.findElement(CONSTRACTOR).click();
        return this;
    }

}
