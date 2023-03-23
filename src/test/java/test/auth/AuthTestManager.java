package test.auth;

import base.BrowserConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static pages.core.ClassObjects.*;

public class AuthTestManager extends BrowserConfig {

    @Test
    @Tag("Auth")
    @DisplayName("Auth test")
    public void authTest() {
        openUrl // Открываем УРЛ
                .openUrl(url);
        mainNonAuthPage // Авторизуемся на портале
                .buttonLogin()
                .buttonEsiaAuth()
                .authForm(login, password)
                .selectUser("Индивидуальный предприниматель");
        Assertions // Делаем ассерт для подтверждения корректности теста
                .assertEquals(hashMaps.expectedMainManager(), mainPage.actualAttributesManager());
    }
}
