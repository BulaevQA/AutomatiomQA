package test.authTests;

import base.BrowserConfig;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static core.classObjects.ClassObjects.*;

public class AuthManagerTest extends BrowserConfig {

    @Test
    @Tag("Auth")
    @Epic(value = "Тесты авторизации")
    @Description(value = "Тест авторизации работодателем")
    @DisplayName("Auth manager test")
    public void authTestManager() {
        // Открываем портал и авторизуемся
        openLink.openUrl(testValues.url);
        click.clickButton("Согласен");
        click.clickButton("Войти");
        click.clickButton("«Госуслуги»");
        input.inputStringField("Телефон / Email / СНИЛС", testValues.login);
        input.inputStringField("Пароль", testValues.password);
        click.clickButton("Войти");
        click.clickButton("Индивидуальный предприниматель");
        // Делаем ассерт для подтверждения корректности теста
        Assertions.assertThat(actualAuth.actualValueManager()).isEqualTo(expectedAuth.expectedManagerAuth());
    }
}
