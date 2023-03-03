package test;

import faker.UserData;
import org.junit.jupiter.api.Tag;
import steps.ResumeSteps;
import steps.AuthPrr;
import settings.PrepareStep;
import owner.OwnerData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        prepareStep.browserConfig();
        authPrr.clickLogIn()
                .clickESIA()
                .setLogin(ownerData.loginCv)
                .setPassword(ownerData.passCv)
                .clickCV();
        createCv.buttonCloseCookie()
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
