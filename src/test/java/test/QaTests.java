package test;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import core.BrowserConfig;
import pages.*;

public class QaTests extends BrowserConfig {

    private final String url = System.getProperty("base_url", "https://rtportal.show.pbs.bftcom.com/");
    private final String login = System.getProperty("login", "89674407691");
    private final String password = System.getProperty("password", "Ex3t8yh96mj!");
    private final String positionName = new Faker().bothify("Автотест####");

    @Test
    @Tag("CvAuth")
    @DisplayName("Тест авторизации соискателя")
    public void cvAuthTest() {
        new MainNonAuthPage()
                .openUrl(url)
                .buttonLogin()
                .buttonEsiaAuth()
                .authForm(login, password)
                .selectUser("Частное лицо");
        Assertions.assertEquals(new MainCvPage().mainCandidatePage(), "Мой кабинет");
    }
    @Test
    @Tag("ResumeTest")
    @DisplayName("Тест создания резюме")
    public void cvCreateResumeTest() {
        new MainNonAuthPage()
                .openUrl(url)
                .buttonLogin()
                .buttonEsiaAuth()
                .authForm(login, password)
                .selectUser("Частное лицо")
                .buttonCreateResume()
                .inputFieldValue("Желаемая должность", positionName)
                .dropDownField("Сфера деятельности")
                .inputFieldValue("Заработная плата (руб.)", "30000")
                .resumeConstructorToggle("Есть опыт работы")
                .functionalButtons("Сохранить и опубликовать")
                .myResumeCheck("Мои резюме");

    }
}
