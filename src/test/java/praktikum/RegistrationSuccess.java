package praktikum;

import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import praktikum.pages.LoginPage;
import praktikum.pages.RegisterPage;
import praktikum.user.User;
import praktikum.user.UserGenerator;

public class RegistrationSuccess {
private User user;
private User userShortPwd;
    @Rule
    public DriverRule driverRule = new DriverRule();

    @Before
    public void setUp() {
        user  = UserGenerator.random();
        userShortPwd = UserGenerator.generic();
        System.out.println(userShortPwd.getPassword());
            }

    @Test
    public void RegistrationSuccessful(){
        RegisterPage regPage = new RegisterPage(driverRule.getDriver());
        regPage.open()
                .fillRegisterForm(user.getName(), user.getEmail(), user.getPassword());

        LoginPage logPage = new LoginPage(driverRule.getDriver());
        MatcherAssert.assertThat(logPage.findLogButton(), true);
    }

    @Test
    public void RegistrationWithShortPwd()  {
        RegisterPage regPage = new RegisterPage(driverRule.getDriver());
        regPage.open()
                .fillRegisterForm(userShortPwd.getName(), userShortPwd.getEmail(), userShortPwd.getPassword());
        MatcherAssert.assertThat(regPage.incorrectPasswordTextAppear(), true);

    }
}
