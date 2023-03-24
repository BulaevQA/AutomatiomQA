package pages.trudvsem.auth;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

public class EsiaAuthFormPage {

    ///////////////// XPath \\\\\\\\\\\\\\\\\\\

    private final SelenideElement
            insertLogin = $x("//input[@id='login']"),
            insertPassword = $x("//input[@id='password']");

    ///////////////// Логика взаимодействия со страницей \\\\\\\\\\\\\\\\\\\

    /**
     === Заполнение формы авторизации ===
     * @param login - Логин пользователя
     * @param password - Пароль пользователя
     */
    @Step(value = "Авторизация пользователем с данными {login} / {password}")
    public UserSelectPage authForm(String login, String password) {
        insertLogin.should(Condition.editable).setValue(login);
        insertPassword.should(Condition.editable).setValue(password).sendKeys(Keys.ENTER);
        return new UserSelectPage();
    }
}