package test;

import faker.FakerData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import conf.BrowserConfig;
import pages.*;

public class QaTests extends BrowserConfig {

    static MainNonAuthPage mainNonAuthPage = new MainNonAuthPage();
    static FakerData fakerData = new FakerData();

    private final static String URL = System.getProperty("base_url", "http://localhost:8080/");
    private final static String LOGIN = System.getProperty("login", "admin");
    private final static String PASSWORD = System.getProperty("password", "admin");
    private final static String MY_CABINET = "Мой кабинет";
    private final static String POSITION_NAME = "Автотест";
    private final static String SALARY = fakerData.randomSalary();
    private final static String MY_RESUME = "Мои резюме";
//    private final static String URL = "https://hotfix2.rtportal.show.pbs.bftcom.com/";
//    private final static String LOGIN = "89674407691";
//    private final static String PASSWORD = "Ex3t8yh96mj!";

    /*
    Тест авторизации соискателя
    */

    @Test
    @Tag("CvAuth")
    @DisplayName("Тест авторизации соискателя")
    public void cvAuthTest() {
        Assertions.assertTrue(mainNonAuthPage.openUrl(URL).buttonLogin().buttonEsiaAuth().fieldLogin(LOGIN)
                .fieldPassword(PASSWORD).clickCv().myСabinetCheck().equals(MY_CABINET));

    }

    @Test
    @Tag("ResumeTest")
    @DisplayName("Тест создания резюме")
    public void cvCreateResumeTest() {
        Assertions.assertTrue(mainNonAuthPage.openUrl(URL).buttonLogin().buttonEsiaAuth().fieldLogin(LOGIN)
                .fieldPassword(PASSWORD).clickCv().buttonCloseCookie().buttonCreateResume()
                .clickPhotoIcon().importPhoto().uploadPhoto().fieldPositionName(POSITION_NAME).fieldSphere()
                .randomSphere().fieldSalary(SALARY).fieldRegion().randomRegion().workExperience().buttonPublish()
                .myResumeCheck().equals(MY_RESUME));
    }
}
