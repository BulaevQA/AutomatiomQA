package pages.trudvsem.mainPrr;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.trudvsem.auth.LoginPage;

import static com.codeborne.selenide.Selenide.$x;

public class MainNonAuthPage {

    ///////////////// XPath \\\\\\\\\\\\\\\\\\\

    private final SelenideElement login = $x("//*[text()='Войти']");
    private final SelenideElement cookies = $x("//*[text()='Согласен']");

    ///////////////// Логика взаимодействия со страницей \\\\\\\\\\\\\\\\\\\

    /**
     === Метод для перехода на страницу авторизации пользователя ===
     */
    @Step(value = "Клик войти")
    public LoginPage buttonLogin() {
        cookies.should(Condition.enabled).click();
        login.should(Condition.enabled).click();
        return new LoginPage();
    }
}
