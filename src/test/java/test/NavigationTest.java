package test;

import owner.OwnerData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import settings.PrepareStep;
import steps.AuthPrr;
import steps.ResumeSteps;

import static com.codeborne.selenide.Selenide.open;
import static settings.PrepareStep.siteUrl;

public class NavigationTest {
    PrepareStep prepareStep = new PrepareStep();
    AuthPrr authPrr = new AuthPrr();
    ResumeSteps createCV = new ResumeSteps();
    OwnerData ownerData = new OwnerData();
    @Test
    @DisplayName("Тест навигации по резюме")
    public void cvConstructorTest() {
        prepareStep.browserConfig(); // Конфигурация браузера
        authPrr.clickLogIn() // Авторизация
                .clickEsia()
                .setLogin()
                .setPassword()
                .clickCV();
        createCV.buttonCloseCookie() // Создание резюме
                .buttonCV()
                .navigation();
    }
}
