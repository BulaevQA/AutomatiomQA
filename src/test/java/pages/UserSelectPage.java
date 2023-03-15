package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class UserSelectPage {
    @Step(value = "Авторизуемся как {user}")
    public MainCvPage selectUser(String user) {
        final SelenideElement userConfirm = $x("//div[text()='" + user + "']");
        userConfirm.click();
        return new MainCvPage();
    }
}
