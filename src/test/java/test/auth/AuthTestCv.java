package test.auth;

import org.junit.jupiter.api.*;
import base.BrowserConfig;

import static helpers.ClassObjects.*;

public class AuthTestCv extends BrowserConfig {

    @Test
    @Tag("Auth")
    @DisplayName("Auth test")
    public void authTest() {
        openLink // Открываем УРЛ
                .openUrl(url);
        mainNonAuthPage // Авторизуемся на портале
                .buttonLogin()
                .buttonEsiaAuth()
                .authForm(login, password)
                .selectUser("Частное лицо");
        Assertions // Делаем ассерт для подтверждения корректности теста
                .assertEquals(expectedHashMaps.expectedMainCv(), actualHashMaps.actualValueCv());
    }
}
