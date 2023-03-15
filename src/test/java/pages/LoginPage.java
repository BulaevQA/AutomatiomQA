package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private final SelenideElement authByEsia = $x("//*[text()='«Госуслуги»']");
    @Step(value = "Авторизация через ЕСИА")
    public AuthFormPage buttonEsiaAuth() {
        authByEsia.click();
        return new AuthFormPage();
    }
}
