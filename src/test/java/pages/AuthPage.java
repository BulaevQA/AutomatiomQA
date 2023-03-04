package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

public class AuthPage {

    private final static SelenideElement ESIA_AUTH = $x("//div[@class='mb-3 row']");
    private final static SelenideElement INSERT_LOGIN = $x("//input[@id='login']");
    private final static SelenideElement INSERT_PASSWORD = $x("//input[@id='password']");
    private final static SelenideElement CV_CONFIRM = $x("//button[@id='individual_button']");

    @Step(value = "Авторизация через ЕСИА")
    public void buttonEsiaAuth() {
        ESIA_AUTH.click();
    }
    @Step(value = "Ввод логина")
    public void fieldLogin(String login) {
        INSERT_LOGIN.setValue(login);
    }
    @Step(value = "Ввод пароля")
    public void fieldPassword(String password) {
       INSERT_PASSWORD.setValue(password);
       INSERT_PASSWORD.sendKeys(Keys.ENTER);
    }
    @Step(value = "Выбор соискателя")
    public void clickCv() {
        CV_CONFIRM.click();
    }
}