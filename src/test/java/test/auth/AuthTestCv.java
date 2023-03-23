package test.auth;

import org.junit.jupiter.api.*;
import base.BrowserConfig;

import static pages.core.ClassObjects.*;

public class AuthTestCv extends BrowserConfig {

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
                .selectUser("Частное лицо");
        Assertions // Делаем ассерт для подтверждения корректности теста
                .assertEquals(hashMaps.expectedMainCv(), mainPage.actualAttributesCv());
    }
}
