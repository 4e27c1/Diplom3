package praktikum;

import groovy.xml.StreamingDOMBuilder;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.StringUtils;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import praktikum.pages.ForgotPasswordPage;
import praktikum.pages.LoginPage;
import praktikum.pages.MainPage;
import praktikum.pages.RegisterPage;
import praktikum.user.User;
import praktikum.user.UserClient;
import praktikum.user.UserGenerator;

public class LoginTest {
    private User user;
    private String accessToken = new String();
    @Rule
    public DriverRule driverRule = new DriverRule();

    @Before
    public void setUp() {
        user = UserGenerator.random();

        RegisterPage regPage = new RegisterPage(driverRule.getDriver()); //сначала регистрируемся
        regPage.open()
                .fillRegisterForm(user.getName(), user.getEmail(), user.getPassword());
    }

    @Test
    @DisplayName("Логин по кнопке Войти в аккаунт")
    public void enterAccountButtonLogin() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.open()
                .enterAccountClick();  //кликаем на кнопку Войти в аккаунт на главной странице

        LoginPage loginPage = new LoginPage(driverRule.getDriver());
        loginPage.login(user.getEmail(), user.getPassword()); //заполняем форму авторизации и кликаем Войти

        MatcherAssert.assertThat(loginPage.findOrderButton(), true);   // смотрим, что появилась кнопка "Оформить заказ", то есть авторизованная зона

        LocalStorage localStorage = ((WebStorage) driverRule.driver).getLocalStorage();
        String accessToken = localStorage.getItem("accessToken");
        System.out.println(accessToken);
    }

    @Test
    @DisplayName("Логин через ссылку личный кабинет")
    public void enterWithLKLink() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.open()
                .lkClick(); //клик на ссылку Личный кабинет на главной

        LoginPage loginPage = new LoginPage(driverRule.getDriver());
        loginPage.login(user.getEmail(), user.getPassword());       //заполняем форму авторизации и кликаем Войти

        MatcherAssert.assertThat(loginPage.findOrderButton(), true);   // смотрим, что появилась кнопка "Оформить заказ", то есть авторизованная зона

        LocalStorage localStorage = ((WebStorage) driverRule.driver).getLocalStorage();
        String accessToken = localStorage.getItem("accessToken");
        System.out.println(accessToken);
    }

    @Test
    @DisplayName("Переход на логин со страницы авторизации")
    public void LoginFromRegisterPage() {
        RegisterPage regPage = new RegisterPage(driverRule.getDriver());
        regPage.open()                                                  //открываем страницу регистрации
                .loginButtonClick();                                    //клик на Войти

        LoginPage loginPage = new LoginPage(driverRule.getDriver());    //открываем страницу логина
        loginPage.login(user.getEmail(), user.getPassword());           //заполняем

        MatcherAssert.assertThat(loginPage.findOrderButton(), true);   // смотрим, что появилась кнопка "Оформить заказ", то есть авторизованная зона

        LocalStorage localStorage = ((WebStorage) driverRule.driver).getLocalStorage();
        String accessToken = localStorage.getItem("accessToken");
        System.out.println(accessToken);
    }

    @Test
    @DisplayName("переход на логин со страницы восстановления пароля и авторизация")
    public void LoginFromForgotPasswordPage() {
        ForgotPasswordPage fgPage = new ForgotPasswordPage(driverRule.getDriver()); //открываем страницу забыл пароль
        fgPage.open()
                .clickLoginButton();                                               //клик на Войти

        LoginPage loginPage = new LoginPage(driverRule.getDriver());    //открываем страницу логина
        loginPage.login(user.getEmail(), user.getPassword());           //заполняем

        MatcherAssert.assertThat(loginPage.findOrderButton(), true);   // смотрим, что появилась кнопка "Оформить заказ", то есть авторизованная зона

        LocalStorage localStorage = ((WebStorage) driverRule.driver).getLocalStorage();
        String accessToken = localStorage.getItem("accessToken");
        System.out.println(accessToken);

    }

    @After
    public void deleteUser() {
        UserClient.delete(accessToken);
    }
}
