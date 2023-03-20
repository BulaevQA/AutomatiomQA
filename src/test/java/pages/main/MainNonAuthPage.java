package pages.main;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.auth.LoginPage;

import static com.codeborne.selenide.Selenide.$x;

public class MainNonAuthPage {

    ///////////////// XPath \\\\\\\\\\\\\\\\\\\

    /**
     @login - Кнопка войти с переадресацией на /auth/login
     @cookies - Кнопка соглашения с использованием cookies
     */
    private final SelenideElement login = $x("//*[text()='Войти']");
    private final SelenideElement cookies = $x("//*[text()='Согласен']");

    ///////////////// Логика взаимодействия со страницей \\\\\\\\\\\\\\\\\\\

    /**
     === Метод открытия базового URL ===
     * @param url - https ссылка
     */
    @Step(value = "Открываем {url}")
    public MainNonAuthPage openUrl (String url){
        Selenide.open(url);
        return this;
    }

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
