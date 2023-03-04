package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import conf.BrowserConfig;
import pages.*;

public class QaTests extends BrowserConfig {

    MainNonAuthPage mainNonAuthPage = new MainNonAuthPage();

    private final static String URL = System.getProperty("base_url", "http://localhost:8080/");
    private final static String LOGIN = System.getProperty("login", "admin");
    private final static String PASSWORD = System.getProperty("password", "admin");
    private final static String MY_CABINET = "Мой кабинт";

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
}
