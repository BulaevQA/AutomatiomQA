package test;

import faker.UserData;
import steps.ResumeSteps;
import steps.AuthPrr;
import settings.PrrUrl;
import cfg.OwnerData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CvConstructorTest {

    PrrUrl prrUrl = new PrrUrl();
    AuthPrr authPRR = new AuthPrr();
    ResumeSteps createCV = new ResumeSteps();
    UserData userData = new UserData();
    OwnerData ownerData = new OwnerData();

    @Test
    @DisplayName("Тест создание резюме")
    public void cvConstructorTest() {
        prrUrl.openBrowser();
        authPRR.clickLogIn()
                .clickESIA()
                .setLogin(ownerData.loginCv)
                .setPassword(ownerData.passCv)
                .clickCV();
        createCV.buttonCloseCookie()
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
