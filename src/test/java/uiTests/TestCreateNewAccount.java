package uiTests;

import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegisterPage;

import static com.codeborne.selenide.Selenide.open;

public class TestCreateNewAccount extends BaseTest{

    @Test
    public void testCreateNewAccount() {
        open(url + "home");
        HomePage homePage = new HomePage();
        homePage.openPageCreateAccount();

        RegisterPage registerPage = new RegisterPage();
        registerPage.inputUsername(username);
        registerPage.inputName(name);
        registerPage.inputLastName(lastName);
        registerPage.inputPassword(password);
        registerPage.inputConfirmPassword(password);
        registerPage.clickRegisterButton();
    }
}
