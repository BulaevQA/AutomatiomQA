package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import conf.BrowserConfig;
import steps.AuthSteps;
import steps.ResumeSteps;

public class QaTests {

    BrowserConfig browserConfig = new BrowserConfig();
    AuthSteps authPrrSteps = new AuthSteps();
    ResumeSteps createCv = new ResumeSteps();

    @Test
    @Tag("CvAuth")
    @DisplayName("Тест авторизации соискателя")
    public void cvAuthTest() {
        browserConfig.browserConfig(); // Конфигурация браузера
        authPrrSteps.buttonLogin() // Авторизация
                .buttonEsiaAuth()
                .fieldLogin()
                .fieldPassword()
                .clickCv()
                .buttonCloseCookie()
                .myСabinetCheck();
    }
    @Test
    @Tag("ResumeTest")
    @DisplayName("Тест создание резюме")
    public void createResume() {
        browserConfig.browserConfig(); // Конфигурация браузера
        authPrrSteps.buttonLogin() // Авторизация
                .buttonEsiaAuth()
                .fieldLogin()
                .fieldPassword()
                .clickCv()
                .buttonCloseCookie()
                .myСabinetCheck();
        createCv.buttonCreateResume() // Создание резюме
                .fieldPositionName()
                .clickPhotoIcon()
                .importPhoto()
                .uploadPhoto()
                .fieldSphere()
                .randomSphere()
                .fieldSalary()
                .fieldRegion()
                .region()
                .radioButtonMail()
                .workExperience()
                .buttonPublish();
    }
}
