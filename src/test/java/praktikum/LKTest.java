package praktikum;

import org.junit.*;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import praktikum.pages.*;
import praktikum.user.User;
import praktikum.user.UserClient;
import praktikum.user.UserGenerator;

public class LKTest {

    public User user;
    //private String accessToken = new String();
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
        String accessToken = localStorage.getItem("accessToken");
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
        String accessToken = localStorage.getItem("accessToken");
        System.out.println(accessToken);

        String actualURL = driverRule.driver.getCurrentUrl();
        Assert.assertEquals("URL doesn't match", Environment.BASE_URL, actualURL);

    }
    @After
    public void deleteUser() {
        UserClient.delete(accessToken);
    }

}
