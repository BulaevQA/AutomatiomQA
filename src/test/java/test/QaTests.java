package test;

import helpers.OwnerData;
import helpers.TestValues;
import org.junit.jupiter.api.*;
import core.BrowserConfig;
import pages.*;

public class QaTests extends BrowserConfig {

    @Test
    @Tag("CvAuth")
    @DisplayName("Тест авторизации соискателя")
    public void cvAuthTest(TestValues testValues, OwnerData ownerData) {
        new MainNonAuthPage()
                .openUrl(testValues.getURL())
                .buttonLogin()
                .buttonEsiaAuth()
                .authForm(ownerData.authLoginCv(), ownerData.authPassCv())
                .clickCv()
                .mainCandidatePage(testValues.getEXPECTED_CABINET());
    }
    @Test
    @Tag("ResumeTest")
    @DisplayName("Тест создания резюме")
    public void cvCreateResumeTest(TestValues testValues) {
        new MainNonAuthPage()
                .openUrl(testValues.getURL())
                .buttonLogin()
                .buttonEsiaAuth()
                .authForm(testValues.getLOGIN(), testValues.getPASSWORD())
                .clickCv()
                .buttonCloseCookie()
                .buttonCreateResume()
                .fieldPositionName(testValues.getPOSITION_NAME())
                .fieldSphere()
                .fieldSalary(testValues.getSALARY())
                .fieldRegion()
                .workExperienceDisable()
                .buttonPublish()
                .myResumeCheck(testValues.getEXPECTED_MY_RESUME());
    }
}
