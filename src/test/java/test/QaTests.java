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
                .openUrl(TestValues.URL)
                .buttonLogin()
                .buttonEsiaAuth()
                .inputAuthForms(TestValues.LOGIN, TestValues.PASSWORD)
                .clickCv()
                .mainCandidatePage(TestValues.EXPECTED_CABINET);
    }
    @Test
    @Tag("ResumeTest")
    @DisplayName("Тест создания резюме")
    public void cvCreateResumeTest() {
        new MainNonAuthPage()
                .openUrl(TestValues.URL)
                .buttonLogin()
                .buttonEsiaAuth()
                .inputAuthForms(TestValues.LOGIN, TestValues.PASSWORD)
                .clickCv()
                .buttonCloseCookie()
                .buttonCreateResume()
                .fieldPositionName(TestValues.POSITION_NAME)
                .fieldSphere()
                .fieldSalary(TestValues.SALARY)
                .fieldRegion()
                .workExperienceDisable()
                .buttonPublish()
                .myResumeCheck(TestValues.EXPECTED_MY_RESUME);
    }
}
