package test;

import methods.TextValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import conf.PrepareStep;
import steps.AuthPrrSteps;

public class CvAuthTest {

    PrepareStep prepareStep = new PrepareStep();
    AuthPrrSteps authPrrSteps = new AuthPrrSteps();
    TextValidator textValidator = new TextValidator();

    @Test
    @Tag("CvAuth")
    @DisplayName("Тест авторизации соискателя")
    public void cvAuthTest() {
        prepareStep.browserConfig(); // Конфигурация браузера
        authPrrSteps.clickLogIn() // Авторизация
                .clickEsia()
                .setLogin()
                .setPassword()
                .clickCV()
                .myСabinetCheck();

    }
}
