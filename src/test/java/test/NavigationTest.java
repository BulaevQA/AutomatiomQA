package test;

import owner.OwnerData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import settings.PrrUrl;
import steps.AuthPrr;
import steps.ResumeSteps;

public class NavigationTest {
    PrrUrl prrUrl = new PrrUrl();
    AuthPrr authPRR = new AuthPrr();
    ResumeSteps createCV = new ResumeSteps();
    OwnerData ownerData = new OwnerData();
    @Test
    @DisplayName("Тест навигации по резюме")
    public void cvConstructorTest() {
        prrUrl.openBrowser(); // Авторизация
        authPRR.clickLogIn()
                .clickESIA()
                .setLogin(ownerData.loginCv)
                .setPassword(ownerData.passCv)
                .clickCV();
        createCV.buttonCloseCookie() // Создание резюме
                .buttonCV()
                .navigation();
    }
}
