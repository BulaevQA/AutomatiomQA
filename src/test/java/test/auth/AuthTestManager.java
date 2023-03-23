package test.auth;

import base.BrowserConfig;
import helpers.HashMaps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.core.CorePage;
import pages.trudvsem.mainPrr.MainNonAuthPage;
import pages.trudvsem.mainPrr.MainPage;

public class AuthTestManager extends BrowserConfig {

    MainPage mainPage = new MainPage();
    HashMaps hashMaps = new HashMaps();
    CorePage corePage = new CorePage();
    MainNonAuthPage mainNonAuthPage = new MainNonAuthPage();

    @Test
    @Tag("Auth")
    @DisplayName("Тест авторизации")
    public void authTest() {
        corePage // Открываем УРЛ
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
