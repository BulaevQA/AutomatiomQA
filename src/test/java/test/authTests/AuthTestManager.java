package test.authTests;

import base.BrowserConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static helpers.other.ClassObjects.*;

public class AuthTestManager extends BrowserConfig {

    @Test
    @Tag("Auth")
    @DisplayName("Auth manager test")
    public void authTest() {
        // Открываем портал и авторизуемся
        openLink.openUrl(testValues.url);
        click.clickButton("Согласен");
        click.clickButton("Войти");
        click.clickButton("«Госуслуги»");
        input.inputValueField("Телефон / Email / СНИЛС", testValues.login);
        input.inputValueField("Пароль", testValues.password);
        click.clickButton("Войти");
        click.clickButton("Индивидуальный предприниматель");
        // Делаем ассерт для подтверждения корректности теста
        Assertions.assertEquals(expectedHashMaps.expectedMainManager(), actualHashMaps.actualValueManager());
    }
}
