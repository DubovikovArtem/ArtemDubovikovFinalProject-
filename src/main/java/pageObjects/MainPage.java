package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private final SelenideElement icon = $x("/html/body/app-root/div/app-navigation/mat-toolbar/button/span[1]/mat-icon");
    private final SelenideElement iconLogout = $x("//*[@id='mat-menu-panel-0']/div/button[2]");
    private final SelenideElement iconProfile = $(byText("Profile"));
    private final SelenideElement jobTitle = $("body > app-root > div > app-job > div > mat-card > mat-card-header > div.mat-card-header-text > mat-card-title");
    private final SelenideElement jobDescription = $("body > app-root > div > app-job > div > mat-card > mat-card-content > p");
    private final SelenideElement createNewComment = $x("/html/body/app-root/div/app-job/div/mat-card/form/mat-form-field/div/div[1]/div/textarea");
    private final SelenideElement buttonLeaveComment = $(byText("Leave comment"));

    @Step("Проверка корректности входа")
    public String checkLogIn() {
        icon.shouldBe(Condition.visible).click();
        String text = iconLogout.getText();
        return text;
    }

    @Step("Нажать кнопку logout")
    public void clickLogout() {
        icon.shouldBe(Condition.visible).click();
        iconLogout.click();
    }

    @Step("Перейти на вкладку profile")
    public void goToProfile() {
        icon.shouldBe(Condition.visible).click();
        iconProfile.click();
    }

    @Step("Выбрать обьявление")
    public void chooseJob(String jobTitle) {
        SelenideElement listOfJobs = $$("body > app-root > div > app-index > div > mat-card").findBy(Condition.text(jobTitle));
        SelenideElement listOfJobs1 = listOfJobs.$("body > app-root > div > app-index > div > mat-card > mat-card-actions > button");
        listOfJobs1.shouldBe(Condition.visible).click();
    }

    @Step("Получить описание объявления")
    public String getJobDescription() {
        String description = jobDescription.shouldBe(Condition.visible).getText();

        return description;
    }

    @Step("Получить имя объявления")
    public String getJobTitle() {
        String title = jobTitle.shouldBe(Condition.visible).getText();

        return title;
    }

    @Step("Создать комментарий в объявлении")
    public void createComment(String commentText) {
        createNewComment.sendKeys(commentText);
        buttonLeaveComment.click();
    }

    @Step("Выбрать и получить комментарий")
    public String chooseJobComment(String commentText) {
        SelenideElement comment = $$("body > app-root > div > app-job > div > div.comments > div > mat-card > mat-card-content > p").findBy(Condition.text(commentText));
        String text = comment.getText();
        return text;
    }
}
