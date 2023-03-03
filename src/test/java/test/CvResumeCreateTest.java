package test;

import faker.UserData;
import org.junit.jupiter.api.Tag;
import steps.ResumeSteps;
import steps.AuthPrrSteps;
import conf.PrepareStep;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CvResumeCreateTest {

    PrepareStep prepareStep = new PrepareStep();
    AuthPrrSteps authPrrSteps = new AuthPrrSteps();
    ResumeSteps createCv = new ResumeSteps();
    UserData userData = new UserData();

    @Test
    @Tag("ResumeTest")
    @DisplayName("Тест создание резюме")
    public void createResume() {
        prepareStep.browserConfig(); // Конфигурация браузера
        authPrrSteps.clickLogIn() // Авторизация
                .clickEsia()
                .setLogin()
                .setPassword()
                .clickCV();
        createCv.buttonCloseCookie() // Создание резюме
                .buttonCV()
                .positionName()
                .clickPhoto()
                .importPhoto()
                .uploadPhoto()
                .clickSphere()
                .randomSphere()
                .salary(userData.salary)
                .clickRegion()
                .region()
                .favoriteMail()
                .lvlWork()
                .buttonSaveResume()
                .pageMyResume();
    }
}
