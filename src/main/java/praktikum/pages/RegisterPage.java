package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    final WebDriver driver;
    private final By registerLink = By.xpath(".//a[text()='Зарегистрироваться']");
    private final By nameInput = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input");
    private final By emailInput = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input");
    private final By pwdInput = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/div/input");
    private final By regButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By incorrectPassword = By.xpath("//p[text()='Некорректный пароль']");

    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }
    //открываем страницу регистрации
    public RegisterPage open() {
        driver.get(Environment.REGISTER_URL);
        return this;
    }

    //клик на "зарегистрироваться"
    public RegisterPage registerClick(){
        driver.findElement(registerLink).click();
        return this;
    }

    //клик на инпут имени и его заполнение
    public RegisterPage namelInput(String name){
        driver.findElement(nameInput).click();
        driver.findElement(nameInput).sendKeys(name);
        return this;
    }
    //клик на инпут емайла и его заполнение
    public RegisterPage emailInput(String email){
        driver.findElement(emailInput).click();
        driver.findElement(emailInput).sendKeys(email);
        return this;
    }
    //клик на инпут пароля и его заполнение
    public RegisterPage pwdInput(String password){
        driver.findElement(pwdInput).click();
        driver.findElement(pwdInput).sendKeys(password);
        return this;
    }
    //клик на "Зарегистрироваться"
    public RegisterPage regClick(){
        driver.findElement(regButton).click();
        return this;
    }
    public void fillRegisterForm(String name, String email, String password) {
        namelInput(name);
        emailInput(email);
        pwdInput(password);
        regClick();
    }

    public String incorrectPasswordTextAppear(){
        return driver.findElement(incorrectPassword).getText();
    }
}
