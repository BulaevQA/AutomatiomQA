package test;

import helpers.TestValues;
import org.junit.jupiter.api.*;
import core.BrowserConfig;
import pages.*;

public class QaTests extends BrowserConfig {
    @Test
    @Tag("CvAuth")
    @DisplayName("Тест авторизации соискателя")
    public void cvAuthTest() {
        new MainNonAuthPage()
                .openUrl(TestValues.getURL())
                .buttonLogin()
                .buttonEsiaAuth()
                .authForm(TestValues.getLOGIN(), TestValues.getPASSWORD())
                .clickCv()
                .mainCandidatePage(TestValues.getEXPECTED_CABINET());
    }
    @Test
    @Tag("ResumeTest")
    @DisplayName("Тест создания резюме")
    public void cvCreateResumeTest() {
        new MainNonAuthPage()
                .openUrl(TestValues.getURL())
                .buttonLogin()
                .buttonEsiaAuth()
                .authForm(TestValues.getLOGIN(), TestValues.getPASSWORD())
                .clickCv()
                .buttonCloseCookie()
                .buttonCreateResume()
                .fieldPositionName(TestValues.getPOSITION_NAME())
                .fieldSphere()
                .fieldSalary(TestValues.getSALARY())
                .fieldRegion()
                .workExperienceDisable()
                .buttonPublish()
                .myResumeCheck(TestValues.getEXPECTED_MY_RESUME());
    }
}
