package test;

import owner.OwnerData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import settings.PrepareStep;
import steps.AuthPrr;
import steps.ResumeSteps;

public class NavigationTest {
    PrepareStep prepareStep = new PrepareStep();
    AuthPrr authPrr = new AuthPrr();
    ResumeSteps createCV = new ResumeSteps();
    OwnerData ownerData = new OwnerData();
    @Test
    @DisplayName("Тест навигации по резюме")
    public void cvConstructorTest() {
        prepareStep.browserConfig(); // Авторизация
        authPrr.clickLogIn()
                .clickESIA()
                .setLogin(ownerData.loginCv)
                .setPassword(ownerData.passCv)
                .clickCV();
        createCV.buttonCloseCookie() // Создание резюме
                .buttonCV()
                .navigation();
    }
}
