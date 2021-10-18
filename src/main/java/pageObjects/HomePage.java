package pageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    private final SelenideElement createAccountLink = $("body > app-root > div > app-home > div > div:nth-child(5) > a");
    private final SelenideElement logInLink = $("body > app-root > div > app-home > div > div:nth-child(4) > a");
    public final SelenideElement username = $("#mat-input-17");
    public final SelenideElement name = $("#mat-input-18");
    public final SelenideElement lastName = $("#mat-input-19");
    public final SelenideElement password = $("#mat-input-20");
    public final SelenideElement confirmPassword = $("#mat-input-21");

    @Step("Переход на страницу регистрации")
    public RegisterPage openPageCreateAccount(){
        createAccountLink.click();
        return new RegisterPage();
    }

    @Step("Переход на страницу логина")
    public void openLogInPage(){
        logInLink.click();
    }

}
