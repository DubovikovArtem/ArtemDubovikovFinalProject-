package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ProfilePage {
    private final SelenideElement editInfoButton = $x("/html/body/app-root/div/app-profile/div/div[1]/button[1]");
    private final SelenideElement inputEditInfoName = $x("//*[@id='mat-input-2']");
    private final SelenideElement inputEditInfoLastName = $x("//*[@id='mat-input-3']");
    private final SelenideElement inputEditInfoUpdateButton = $(byText("Update"));
    private final SelenideElement inputEditInfoUpdateResult = $x("/html/body/app-root/div/app-profile/div/div[2]/div[2]/h3");

    private final SelenideElement addJobButton = $x("/html/body/app-root/div/app-profile/div/div[2]/app-my-jobs/div/div/button/span[1]");
    private final SelenideElement inputCreateJobTitle = $x("/html/body/app-root/div/app-profile/div/div[2]/app-add-job/div/form/mat-form-field[1]/div/div[1]/div[3]/input");
    private final SelenideElement inputCreateJobDescription = $x("/html/body/app-root/div/app-profile/div/div[2]/app-add-job/div/form/mat-form-field[2]/div/div[1]/div[3]/textarea");
    private final SelenideElement inputCreateJobPrise = $x("/html/body/app-root/div/app-profile/div/div[2]/app-add-job/div/form/mat-form-field[3]/div/div[1]/div[3]/input");
    private final SelenideElement inputCreateJobButton = $x("/html/body/app-root/div/app-profile/div/div[2]/app-add-job/div/form/div/button");
    private final ElementsCollection jobTitle = $$("div > mat-card  > mat-card-header > div.mat-card-header-text>mat-card-title");

    @Step("Клик по кнопке edit info")
    public void clickEditInfoButton() {
        editInfoButton.shouldBe(Condition.visible).click();
    }

    @Step("Ввод имени в поле name d edit info")
    public void setInputEditInfoName(String name) {
        inputEditInfoName.shouldBe(Condition.visible).clear();
        inputEditInfoName.shouldBe(Condition.visible).sendKeys(name);
    }

    @Step("Ввод имени в поле name d edit info")
    public void setInputEditInfoLasName(String lastName) {
        inputEditInfoLastName.shouldBe(Condition.visible).clear();
        inputEditInfoLastName.shouldBe(Condition.visible).sendKeys(lastName);
    }

    @Step("Нажатие по кнопке Update")
    public void clickEditInfoUpdateButton() {
        inputEditInfoUpdateButton.shouldBe(Condition.enabled).click();
    }

    @Step("Проверка результата")
    public String checkUpdateResult() {
        String result = inputEditInfoUpdateResult.shouldBe(Condition.visible).getText();
        return result;
    }

    @Step("Создать новое обьявление")
    public void createNewJob() {
        addJobButton.shouldBe(Condition.visible).click();
    }

    @Step("Добавить название обьявления")
    public void addTitleToJob(String addTitle) {
        inputCreateJobTitle.shouldBe(Condition.visible).sendKeys(addTitle);
    }

    @Step("Добавить описание")
    public void addDescriptionToJob(String description) {
        inputCreateJobDescription.shouldBe(Condition.visible).sendKeys(description);
    }

    @Step("Добавить стоимость")
    public void addPriseToJob(String prise) {
        inputCreateJobPrise.shouldBe(Condition.visible).sendKeys(prise);
    }

    @Step("Нажать на кнопку создать обьявление")
    public void createJobButton() {
        inputCreateJobButton.shouldBe(Condition.enabled).click();
    }

    @Step("Возвращение результат поиска обьявления")
    public String returnJobName(String jobName) {
        String name = jobTitle.find(Condition.text(jobName)).getText();
        return name;
    }

    @Step("Выбор и удаление обьявления")
    public void deleteJob(String jobName) {
        SelenideElement jobTitle = $$("body > app-root > div > app-profile > div > div.row > app-my-jobs > div > mat-card").findBy(Condition.text(jobName));
        SelenideElement deleteButton = jobTitle.$("mat-card-actions > button");
        deleteButton.click();
        Selenide.switchTo().alert().accept();
    }
}
