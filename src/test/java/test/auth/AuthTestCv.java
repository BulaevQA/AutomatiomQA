package test.auth;

import helpers.HashMaps;
import org.junit.jupiter.api.*;
import base.BrowserConfig;
import pages.core.CorePage;
import pages.trudvsem.mainPrr.MainNonAuthPage;
import pages.trudvsem.mainPrr.MainPage;

public class AuthTestCv extends BrowserConfig {

    MainPage mainPage = new MainPage();
    HashMaps hashMaps = new HashMaps();
    CorePage corePage = new CorePage();
    MainNonAuthPage mainNonAuthPage = new MainNonAuthPage();

    @Test
    @Tag("Smoke")
    @DisplayName("Тест авторизации")
    public void authTest() {
        corePage // Открываем УРЛ
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
