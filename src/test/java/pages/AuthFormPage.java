package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

public class AuthFormPage {

    private final SelenideElement insertLogin = $x("//input[@id='login']");
    private final SelenideElement insertPassword = $x("//input[@id='password']");

    @Step(value = "Авторизация пользователем с данными {login} / {password}")
    public UserSelectPage authForm(String login, String password) {
        insertLogin.setValue(login);
        insertPassword.setValue(password).sendKeys(Keys.ENTER);
        return new UserSelectPage();
    }
}