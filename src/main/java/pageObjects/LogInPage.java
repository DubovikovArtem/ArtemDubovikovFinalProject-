package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class LogInPage {
    public final SelenideElement loginLink = $x("//*[@id='mat-input-0']");
    public final SelenideElement passwordLink = $x("//*[@id='mat-input-1']");
    public final SelenideElement loginButton = $x("//*[@id='controls']/button/span[1]");

    @Step("LogIn")
    public void login(String login, String password){
        loginLink.sendKeys(login);
        passwordLink.sendKeys(password);
        loginButton.shouldBe(Condition.enabled).click();
    }
}
