package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private final static SelenideElement ESIA_AUTH = $x("//div[@class='mb-3 row']");
    @Step(value = "Авторизация через ЕСИА")
    public AuthFormPage buttonEsiaAuth() {
        ESIA_AUTH.click();
        return new AuthFormPage();
    }
}
