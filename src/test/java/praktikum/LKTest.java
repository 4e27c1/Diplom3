package praktikum;

import org.junit.*;
import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import praktikum.pages.*;
import praktikum.user.User;
import praktikum.user.UserClient;
import praktikum.user.UserGenerator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class LKTest {

    public User user;
    public String accessToken = new String();
    @Rule
    public DriverRule driverRule = new DriverRule();

    @Before
    public void setUp() {
        user = UserGenerator.random();

        RegisterPage regPage = new RegisterPage(driverRule.getDriver()); //сначала регистрируемся
        regPage.open()
                .fillRegisterForm(user.getName(), user.getEmail(), user.getPassword());

        LoginPage loginPage = new LoginPage(driverRule.getDriver());
        loginPage.open()
                .login(user.getEmail(), user.getPassword());
    }

    @Test
    @DisplayName("Открытие Личного кабинета в авторизованной зоне")
    public void openLKWhenAuthorized(){
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.lkClick();

        LKPage lkPage = new LKPage(driverRule.getDriver());
        lkPage.profileLinkClick();
        String actualURL = driverRule.driver.getCurrentUrl();
        Assert.assertEquals("URL doesn't match", Environment.ACCOUNT_URL, actualURL);

        LocalStorage localStorage = ((WebStorage) driverRule.driver).getLocalStorage();
        accessToken = localStorage.getItem("accessToken");
        System.out.println(accessToken);
    }

    @Test
    @DisplayName("Проверка клика на конструктор из личного кабинета")
    public void ConstructorClickTest(){
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.lkClick();

        LKPage lkPage = new LKPage(driverRule.getDriver());
        lkPage.constructorClick();

        LocalStorage localStorage = ((WebStorage) driverRule.driver).getLocalStorage();
        accessToken = localStorage.getItem("accessToken");
        System.out.println(accessToken);

        String actualURL = driverRule.driver.getCurrentUrl();
        Assert.assertEquals("URL doesn't match", Environment.BASE_URL, actualURL);
    }

    @Test
    @DisplayName("Клик по логотипу из личного кабинета")
    public void LogoClick(){
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.lkClick();

        LKPage lkPage = new LKPage(driverRule.getDriver());
        lkPage.logoClick();

        LocalStorage localStorage = ((WebStorage) driverRule.driver).getLocalStorage();
        accessToken = localStorage.getItem("accessToken");
        System.out.println(accessToken);

        String actualURL = driverRule.driver.getCurrentUrl();
        Assert.assertEquals("URL doesn't match", Environment.BASE_URL, actualURL);
    }

    @Test
    @DisplayName("Клик на логаут из личного кабинета")
    public void LogoutClick(){
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.lkClick();

        LKPage lkPage = new LKPage(driverRule.getDriver());
        lkPage.logoutClick();

        LocalStorage localStorage = ((WebStorage) driverRule.driver).getLocalStorage();
        accessToken = localStorage.getItem("accessToken");
        System.out.println(accessToken);

        LoginPage loginPage = new LoginPage(driverRule.getDriver());
        String text = loginPage.findLogButton();
        assertThat("There was no transition to the login page",text, containsString("Войти"));
    }
    @After
    public void deleteUser() {
        UserClient.delete(accessToken);
    }

}
