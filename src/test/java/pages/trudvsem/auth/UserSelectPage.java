package pages.trudvsem.auth;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import pages.trudvsem.mainPrr.MainPage;

import static com.codeborne.selenide.Selenide.$x;

public class UserSelectPage {

    ///////////////// Методы \\\\\\\\\\\\\\\\\\\

    /**
     === Выбор пользователя для авторизации через ЕСИА ===
     * @param user - тип пользователя (Соикатель, ИП, ЮР лицо)
     */
    private void serviceUser(String user) {
        $x("//div[text()='"+user+"']").should(Condition.exist, Condition.enabled).click();
    }

    ///////////////// Логика взаимодействия со страницей \\\\\\\\\\\\\\\\\\\

    /**
     === Выбор пользователя для авторизации через ЕСИА ===
     * @param user - тип пользователя (Соикатель, ИП, ЮР лицо)
     */
    @Step(value = "Авторизуемся как {user}")
    public MainPage selectUser(String user) {
        serviceUser(user);
        return new MainPage();
    }
}
