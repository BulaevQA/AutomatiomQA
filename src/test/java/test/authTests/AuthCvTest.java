package test.authTests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import base.BrowserConfig;

import static core.classObjects.ClassObjects.*;

public class AuthCvTest extends BrowserConfig {

    @Test()
    @Tag("Auth")
    @Epic(value = "Тесты авторизации")
    @Description(value = "Тест авторизации соискателем")
    @DisplayName("Auth cv test")
    public void authTestCv() {
        // Открываем портал
        open.openUrl(testValues.url);
        click.clickButton("Согласен");
        click.clickButton("Войти");
        click.clickButton("«Госуслуги»");
        input.inputStringField("Телефон / Email / СНИЛС", testValues.login);
        input.inputStringField("Пароль", testValues.password);
        click.clickButton("Войти");
        click.clickButton("Частное лицо");
        // Делаем ассерт для подтверждения корректности теста
        Assertions.assertThat(actualAuth.actualValueCv()).isEqualTo(expectedAuth.expectedCvAuth());
    }
}
