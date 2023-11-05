package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    final WebDriver driver;
    private final By nameInput = By.xpath("//fieldset[1]/div/div/input");
    private final By emailInput = By.xpath("//fieldset[2]/div/div/input");
    private final By pwdInput = By.xpath("//input[@type=\"password\"]");
    private final By regButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By incorrectPassword = By.xpath("//p[text()='Некорректный пароль']");
    private final By loginLink = By.xpath("//a[text()='Войти']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    //открываем страницу регистрации
    public RegisterPage open() {
        driver.get(Environment.REGISTER_URL);
        return this;
    }

    //клик на инпут имени и его заполнение
    public RegisterPage namelInput(String name) {
        driver.findElement(nameInput).click();
        driver.findElement(nameInput).sendKeys(name);
        return this;
    }

    //клик на инпут емайла и его заполнение
    public RegisterPage emailInput(String email) {
        driver.findElement(emailInput).click();
        driver.findElement(emailInput).sendKeys(email);
        return this;
    }

    //клик на инпут пароля и его заполнение
    public RegisterPage pwdInput(String password) {
        driver.findElement(pwdInput).click();
        driver.findElement(pwdInput).sendKeys(password);
        return this;
    }

    //клик на "Зарегистрироваться"
    public RegisterPage regClick() {
        driver.findElement(regButton).click();
        return this;
    }

    //запонение формы регистрации и клик на кнопку Зарегистрироваться
    public void fillRegisterForm(String name, String email, String password) {
        namelInput(name);
        emailInput(email);
        pwdInput(password);
        regClick();
    }

    //получение уведомления о коротком пароле
    public String incorrectPasswordTextAppear() {
        return driver.findElement(incorrectPassword).getText();
    }

    //клик на кнопку Войти на странице регистрации
    public RegisterPage loginButtonClick() {
        driver.findElement(loginLink).click();
        return this;
    }
}
