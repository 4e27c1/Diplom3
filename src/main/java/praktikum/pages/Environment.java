package praktikum.pages;

public class Environment {
    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site/";
    public static final String LOGIN_URL = "https://stellarburgers.nomoreparties.site/account";
    public static final String ACCOUNT_URL = "https://stellarburgers.nomoreparties.site/account/profile";
    public static final String REGISTER_URL = "https://stellarburgers.nomoreparties.site/register";
    public static final String FORGOT_PASSWORD = "https://stellarburgers.nomoreparties.site/forgot-password";
    public static final String LK = "https://stellarburgers.nomoreparties.site/account/profile";
    public static final String USER_CREATE = "api/auth/register";
    public static final String USER_DELETE = "/api/auth/user";
    public static final int DEFAULT_TIMEOUT = 10;

    public static final String CHROME_DRIVER = System.getProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    public static final String CHROME_BINARY = System.getProperty("webdriver.chrome.binary", "/opt/chrome-for-testing/chrome");
    public static final String YANDEX_DRIVER = System.getProperty("webdriver.chrome.driver", "src/main/resources/chromedriver114.exe");
   public static final String YANDEX_BINARY = System.getProperty("webdriver.yandex.binary", "C:\\Program Files\\Yandex\\YandexBrowser\\Application\\browser.exe");
}
