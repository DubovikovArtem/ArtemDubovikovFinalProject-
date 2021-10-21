package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class RegisterPage {
    public final SelenideElement usernameLink = $x("//*[@id='mat-input-0']");
    public final SelenideElement nameLink = $x("//*[@id='mat-input-1']");
    public final SelenideElement lastNameLink = $x("//*[@id='mat-input-2']");
    public final SelenideElement passwordLink = $x("//*[@id='mat-input-3']");
    public final SelenideElement confirmPasswordLink = $x("//*[@id='mat-input-4']");
    public final SelenideElement registerButtonLink = $x("//*[@id='controls']/button/span[1]");

    @Step("Ввести Username")
    public void inputUsername(String username) {
        usernameLink.sendKeys(username);
    }

    @Step("Ввести Name")
    public void inputName(String name) {
        nameLink.sendKeys(name);
    }

    @Step("Ввести Last Name")
    public void inputLastName(String lastName) {
        lastNameLink.sendKeys(lastName);
    }

    @Step("Ввести Password")
    public void inputPassword(String password) {
        passwordLink.sendKeys(password);
    }

    @Step("Ввести Confirm Password")
    public void inputConfirmPassword(String confirmPassword) {
        confirmPasswordLink.sendKeys(confirmPassword);
    }

    @Step("Нажать на кнопку регистрации")
    public void clickRegisterButton() {
        registerButtonLink.shouldBe(Condition.enabled).click();
    }
}
