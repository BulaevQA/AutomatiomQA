package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import settings.PrepareStep;
import steps.AuthPrr;

public class CvAuth {

    PrepareStep prepareStep = new PrepareStep();
    AuthPrr authPrr = new AuthPrr();

    @Test
    @Tag("CvAuth")
    @DisplayName("Тест создание резюме")
    public void cvConstructorTest() {
        prepareStep.browserConfig(); // Конфигурация браузера
        authPrr.clickLogIn() // Авторизация
                .clickEsia()
                .setLogin()
                .setPassword()
                .clickCV();
    }
}
