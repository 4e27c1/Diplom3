package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import praktikum.pages.MainPage;
import praktikum.pages.RegisterPage;
import praktikum.user.User;
import praktikum.user.UserGenerator;

public class ConstructorTest {
    private User user;
    private String accessToken = new String();
    @Rule
    public DriverRule driverRule = new DriverRule();

    @Test
    @DisplayName("Отображение соуса в конструкторе после клика")
    public void SauseDisplayedTest() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.open()
                .waitWithDefaultTimeout()
                .sauceClick();
        Assertions.assertTrue(mainPage.checkScrollingToFirstPositions(mainPage.getFirstSauseLocator()));
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
        Assertions.assertTrue(mainPage.checkScrollingToFirstPositions(mainPage.getFirstBunLocator()));
    }

    @Test
    @DisplayName("Отображение начинки в конструкторе после клика")
    public void FillingDisplayedTest() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.open()
                .waitWithDefaultTimeout()
                .fillingClick();
        Assertions.assertTrue(mainPage.checkScrollingToFirstPositions(mainPage.getFirstFillingLocator()));
    }
}
