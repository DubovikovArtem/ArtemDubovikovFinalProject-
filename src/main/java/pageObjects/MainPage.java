package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private final SelenideElement icon = $x("/html/body/app-root/div/app-navigation/mat-toolbar/button/span[1]/mat-icon");
    private final SelenideElement iconLogout = $x("//*[@id='mat-menu-panel-0']/div/button[2]");

    public String checkLogIn() {
    icon.shouldBe(Condition.visible).click();
    String text = iconLogout.getText();
    return text;
    }
}
