package test;

import com.codeborne.selenide.junit5.ScreenShooterExtension;
import helpers.TestValues;
import org.junit.jupiter.api.*;
import core.BrowserConfig;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.*;

@ExtendWith({ScreenShooterExtension.class})
public class QaTests extends BrowserConfig {
    @Test
    @Tag("CvAuth")
    @DisplayName("Тест авторизации соискателя")
    public void cvAuthTest() {
        new MainNonAuthPage()
                .openUrl(TestValues.URL)
                .buttonLogin()
                .buttonEsiaAuth()
                .fieldLogin(TestValues.LOGIN)
                .fieldPassword(TestValues.PASSWORD)
                .clickCv();
        Assertions
                .assertTrue(new MainCvPage().mainCandidatePage().equals(TestValues.EXPECTED_CABINET));
    }
    @Test
    @Tag("ResumeTest")
    @DisplayName("Тест создания резюме")
    public void cvCreateResumeTest() {
        new MainNonAuthPage()
                .openUrl(TestValues.URL)
                .buttonLogin()
                .buttonEsiaAuth()
                .fieldLogin(TestValues.LOGIN)
                .fieldPassword(TestValues.PASSWORD)
                .clickCv()
                .buttonCloseCookie()
                .buttonCreateResume()
                .fieldPositionName(TestValues.POSITION_NAME)
                .fieldSphere()
                .randomSphere()
                .fieldSalary(TestValues.SALARY)
                .fieldRegion()
                .randomRegion()
                .workExperience()
                .buttonPublish();
        Assertions
                .assertTrue(new MyResumePage().myResumeCheck().equals(TestValues.EXPECTED_MY_RESUME));
    }
}
