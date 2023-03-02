package test;

import faker.UserData;
import steps.ResumeSteps;
import steps.AuthPrr;
import settings.PrrUrl;
import owner.OwnerData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CvConstructorTest {

    PrrUrl prrUrl = new PrrUrl();
    AuthPrr authPrr = new AuthPrr();
    ResumeSteps createCv = new ResumeSteps();
    UserData userData = new UserData();
    OwnerData ownerData = new OwnerData();

    @Test
    @DisplayName("Тест создание резюме")
    public void cvConstructorTest() {
        prrUrl.openBrowser();
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
                .pageMyResume()
                .urlCheck();
    }
}
