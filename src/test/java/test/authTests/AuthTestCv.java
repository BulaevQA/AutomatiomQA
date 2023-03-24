package test.authTests;

import org.junit.jupiter.api.*;
import base.BrowserConfig;

import static helpers.other.ClassObjects.*;

public class AuthTestCv extends BrowserConfig {

    @Test
    @Tag("Auth")
    @DisplayName("Auth cv test")
    public void authTest() {
        // Открываем портал и авторизуемся
        openLink.openUrl(url);
        click.clickButton("Согласен");
        click.clickButton("Войти", "2");
        input.inputValueField("Телефон / Email / СНИЛС", login);
        input.inputValueField("Пароль", password);
        click.clickButton("Войти");
        click.clickButton("Частное лицо");
        // Делаем ассерт для подтверждения корректности теста
        Assertions.assertEquals(expectedHashMaps.expectedMainCv(), actualHashMaps.actualValueCv());
    }
}
