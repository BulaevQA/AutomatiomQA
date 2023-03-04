package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

public class AuthFormPage {

    private final static SelenideElement INSERT_LOGIN = $x("//input[@id='login']");
    private final static SelenideElement INSERT_PASSWORD = $x("//input[@id='password']");

    @Step(value = "Ввод логина")
    public AuthFormPage fieldLogin(String login) {
        INSERT_LOGIN.setValue(login);
        return this;
    }
    @Step(value = "Ввод пароля")
    public UserSelectPage fieldPassword(String password) {
       INSERT_PASSWORD.setValue(password);
       INSERT_PASSWORD.sendKeys(Keys.ENTER);
       return new UserSelectPage();
    }
}