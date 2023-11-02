package praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import praktikum.pages.MainPage;

public class ConstructorTest {
    @Rule
    public DriverRule driverRule = new DriverRule();

    @Test
    @DisplayName("Отображение соуса в конструкторе после клика")
    public void SauceDisplayedTest() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.open()
                .waitWithDefaultTimeout()
                .sauceClick();
        Assert.assertTrue(mainPage.checkScrollingToFirstPositions(mainPage.getFirstSauseLocator()));
    }

    @Test
    @DisplayName("Отображение соуса в конструкторе после клика")
    public void BunDisplayedTest() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.open()
               .waitWithDefaultTimeout()
                .sauceClick()
                .waitWithDefaultTimeout()
                .bunClick();
        Assert.assertTrue(mainPage.checkScrollingToFirstPositions(mainPage.getFirstBunLocator()));
    }

    @Test
    @DisplayName("Отображение начинки в конструкторе после клика")
    public void FillingDisplayedTest() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.open()
                .waitWithDefaultTimeout()
                .fillingClick();
        Assert.assertTrue(mainPage.checkScrollingToFirstPositions(mainPage.getFirstFillingLocator()));
    }
}
