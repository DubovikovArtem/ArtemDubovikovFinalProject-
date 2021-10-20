package uiTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LogInPage;
import pageObjects.MainPage;
import pageObjects.RegisterPage;

import static com.codeborne.selenide.Selenide.open;

public class TestCreateNewAccount extends BaseTest{

    @Test(description = "Проверка создания нового аккаунта")
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

        open(url + "home");
        HomePage homePage1 = new HomePage();
        homePage1.openLogInPage();

        LogInPage logInPage = new LogInPage();
        logInPage.login(username, password);

        MainPage mainPage = new MainPage();
        String text = mainPage.checkLogIn();
        Assert.assertEquals(text, "Logout");
    }
}
