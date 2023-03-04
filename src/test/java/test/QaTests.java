package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import conf.BrowserConfig;
import pages.AuthPage;
import pages.MainCvPage;
import pages.MainNonAuthPage;
import pages.ResumeConstructorPage;

public class QaTests extends BrowserConfig {

    MainNonAuthPage mainPage = new MainNonAuthPage();
    AuthPage authPage = new AuthPage();
    MainCvPage mainCvPage = new MainCvPage();
    ResumeConstructorPage resumeConstructorPage = new ResumeConstructorPage();

    private final static String URL = System.getProperty("base_url", "http://localhost:8080/");
    private final static String LOGIN = "login";
    private final static String LOGIN_VALUE = "admin";
    private final static String PASSWORD = "password";
    private final static String PASSWORD_VALUE = "admin";
    /*
    Тест авторизации соискателя
    */
    @Test
    @Tag("CvAuth")
    @DisplayName("Тест авторизации соискателя")
    public void cvAuthTest() {
        mainPage.openUrl(URL);
        mainPage.buttonLogin();
        authPage.buttonEsiaAuth();
        authPage.fieldLogin(LOGIN, LOGIN_VALUE);
        authPage.fieldPassword(PASSWORD, PASSWORD_VALUE);
        mainCvPage.myСabinetCheck();
//                 browserConfig();
//        authPage.buttonLogin()
//                .buttonEsiaAuth()
//                .fieldLogin()
//                .fieldPassword()
//                .clickCv()
//                .buttonCloseCookie()
//                .myСabinetCheck();
    }
    /*
    Тест создания резюме соискателем
    */
//    @Test
//    @Tag("ResumeTest")
//    @DisplayName("Тест создание резюме")
//    public void createResume() {
//                 browserConfig();
//        authPage.buttonLogin()
//                .buttonEsiaAuth()
//                .fieldLogin()
//                .fieldPassword()
//                .clickCv()
//                .buttonCloseCookie()
//                .myСabinetCheck();
//        resumeConstructorPage.buttonCreateResume()
//                .fieldPositionName()
//                .clickPhotoIcon()
//                .importPhoto()
//                .uploadPhoto()
//                .fieldSphere()
//                .randomSphere()
//                .fieldSalary()
//                .fieldRegion()
//                .region()
//                .radioButtonMail()
//                .workExperience()
//                .buttonPublish()
//                .myResumeCheck();
//    }
}
