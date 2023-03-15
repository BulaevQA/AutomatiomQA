package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class MainNonAuthPage {

    private final SelenideElement login = $x("//*[text()='Войти']");
    private final SelenideElement cookies = $x("//*[text()='Согласен']");

    @Step(value = "Открываем {url}")
    public MainNonAuthPage openUrl (String url){
        Selenide.open(url);
        return this;
    }

    @Step(value = "Клик войти")
    public LoginPage buttonLogin() {
        cookies.click();
        login.click();
        return new LoginPage();
    }
}
