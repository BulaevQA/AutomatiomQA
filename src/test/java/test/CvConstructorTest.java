package test;

import faker.UserData;
import org.junit.jupiter.api.Tag;
import steps.ResumeSteps;
import steps.AuthPrr;
import settings.PrepareStep;
import owner.OwnerData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static settings.PrepareStep.siteUrl;

public class CvConstructorTest {

    PrepareStep prepareStep = new PrepareStep();
    AuthPrr authPrr = new AuthPrr();
    ResumeSteps createCv = new ResumeSteps();
    UserData userData = new UserData();
    OwnerData ownerData = new OwnerData();

    @Test
    @Tag("ResumeTest")
    @DisplayName("Тест создание резюме")
    public void cvConstructorTest() {
        prepareStep.browserConfig(); // Конфигурация браузера
        open(siteUrl);
        authPrr.clickLogIn() // Авторизация
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
