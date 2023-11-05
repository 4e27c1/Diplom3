package praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.pages.MainPage;

import java.time.Duration;

public class ConstructorTest {
    @Rule
    public DriverRule driverRule = new DriverRule();

    @Test
    @DisplayName("Отображение соуса в конструкторе после клика")
    public void SauceDisplayedTest() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.open()
                .waitWithDefaultTimeout()
                .sauceClick()
                .getActiveSauceTab();
        Assert.assertTrue(mainPage.checkScrollingToFirstPositions(mainPage.getFirstSauseLocator()));
    }

    @Test
    @DisplayName("Отображение булки в конструкторе после клика")
    public void BunDisplayedTest() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.open()
               .waitWithDefaultTimeout()
                .sauceClick()
                .waitWithDefaultTimeout()
                .bunClick()
                .getActiveBunTab();
        Assert.assertTrue(mainPage.checkScrollingToFirstPositions(mainPage.getFirstBunLocator()));
    }

    @Test
    @DisplayName("Отображение начинки в конструкторе после клика")
    public void FillingDisplayedTest() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.open()
                .waitWithDefaultTimeout()
                .fillingClick()
                .getActiveFillingTab();
        Assert.assertTrue(mainPage.checkScrollingToFirstPositions(mainPage.getFirstFillingLocator()));
    }
}
