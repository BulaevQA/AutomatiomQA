package test.authTests;

import org.junit.jupiter.api.*;
import base.BrowserConfig;

import static core.classObjects.ClassObjects.*;

public class AuthCvTest extends BrowserConfig {

    @Test
    @Tag("Auth")
    @DisplayName("Auth cv test")
    public void authTestCv() {
        // Открываем портал и авторизуемся
        openLink.openUrl(testValues.url);
        click.clickButton("Согласен");
        click.clickButton("Войти");
        click.clickButton("«Госуслуги»");
        input.inputValueField("Телефон / Email / СНИЛС", testValues.login);
        input.inputValueField("Пароль", testValues.password);
        click.clickButton("Войти");
        click.clickButton("Частное лицо");
        // Делаем ассерт для подтверждения корректности теста
        Assertions.assertEquals(expectedAuth.expectedCvAuth(), actualAuth.actualValueCv());
    }
}
