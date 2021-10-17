package uiTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LogInPage;
import pageObjects.MainPage;
import pageObjects.ProfilePage;

import static com.codeborne.selenide.Selenide.open;

public class TestProfilePage extends BaseTest {
    private final String jobName = "title";

    @BeforeMethod
    public void logIn() {
        open(url + "home");
        HomePage homePage = new HomePage();
        homePage.openLogInPage();

        LogInPage logInPage = new LogInPage();
        logInPage.login(username, password);

        MainPage mainPage = new MainPage();
        mainPage.goToProfile();
    }

    /**
     * Пользователь может залогиниться, перейти на страницу Profile и изменить свои данные, проверить что новые данные отображаются корректно
     */
    @Test
    public void testUpdateProfile() {
        String name = "ArtemTestNameUpdate";
        String lastName = "ArtemTestLastNameUpdate";
        String expectedResult = name + " " + lastName;

        ProfilePage profilePage = new ProfilePage();
        profilePage.clickEditInfoButton();
        profilePage.setInputEditInfoName(name);
        profilePage.setInputEditInfoLasName(lastName);
        profilePage.clickEditInfoUpdateButton();
        String result = profilePage.checkUpdateResult();

        Assert.assertEquals(result, expectedResult);
    }

    /**
     * Пользователь может залогиниться, перейти на страницу Profile и создать новое объявление. Проверить, что оно отображается в секции My Jobs
     */
    @Test
    public void testAddNewJob() {
        ProfilePage profilePage = new ProfilePage();
        profilePage.createNewJob();
        profilePage.addTitleToJob(jobName);
        profilePage.addDescriptionToJob("description");
        profilePage.addPriseToJob("1000");
        profilePage.createJobButton();

        String result = profilePage.returnJobName(jobName);
        Assert.assertEquals(result, jobName);
    }

    /**
     * Пользователь может залогиниться, перейти на страницу Profile, просмотреть список всех
     * своих объявлений, увидеть количество комментариев для каждого. Так же он может удалить какое-то из объявлений.
     */
    @Test
    public void testDeleteJob() {
        ProfilePage profilePage = new ProfilePage();
        profilePage.deleteJob(jobName);
    }

}
