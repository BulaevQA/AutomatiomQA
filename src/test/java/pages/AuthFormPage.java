package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

public class AuthFormPage {

    private final static SelenideElement INSERT_LOGIN = $x("//input[@id='login']");
    private final static SelenideElement INSERT_PASSWORD = $x("//input[@id='password']");

    @Step(value = "Авторизация пользователем с данными {login} / {password}")
    public UserSelectPage inputAuthForms(String login, String password) {
        INSERT_LOGIN.setValue(login);
        INSERT_PASSWORD.setValue(password).sendKeys(Keys.ENTER);
        return new UserSelectPage();
    }
}