package uiTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LogInPage;
import pageObjects.MainPage;

import static com.codeborne.selenide.Selenide.open;

public class TestLogIn extends BaseTest {

    @Test(description = "Пользователь может залогиниться")
    public void testLogin() {
        open(url + "home");
        HomePage homePage = new HomePage();
        homePage.openLogInPage();

        LogInPage logInPage = new LogInPage();
        logInPage.login(username, password);

        MainPage mainPage = new MainPage();
        String text = mainPage.checkLogIn();
        Assert.assertEquals(text, "Logout");
    }
}
