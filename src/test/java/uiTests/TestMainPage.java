package uiTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LogInPage;
import pageObjects.MainPage;

import static com.codeborne.selenide.Selenide.*;

public class TestMainPage extends BaseTest {
    @BeforeMethod
    public void logIn() {
        open(url + "home");
        HomePage homePage = new HomePage();
        homePage.openLogInPage();

        LogInPage logInPage = new LogInPage();
        logInPage.login(username, password);
    }

    /**
     * Пользователь может залогиниться, выбрать объявление на главной странице, просмотреть его детали, оставить комментарий.
     */
    @Test
    public void testMainPageJobLeaveComment() {
        MainPage mainPage = new MainPage();
        mainPage.chooseJob("title");

        String jobTitle = mainPage.getJobTitle();
        String jobDescription = mainPage.getJobDescription();

        Assert.assertEquals(jobTitle, "title");
        Assert.assertEquals(jobDescription, "description");

        mainPage.createComment("automation1");
        String comment = mainPage.chooseJobComment("automation1");

        Assert.assertEquals(comment, "automation1");

    }
}
