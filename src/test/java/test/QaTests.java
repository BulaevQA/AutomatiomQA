package test;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import core.BrowserConfig;
import pages.*;

public class QaTests extends BrowserConfig {

    private final String url = System.getProperty("base_url", "localhost");
    private final String login = System.getProperty("login", "admin");
    private final String password = System.getProperty("password", "admin");
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
                .dropDownField("Профессия", "Нет такой профессии", "1")
                .inputFieldValue("Заработная плата (руб.)", "30000")
                .inputFieldValue("Готов приступить к работе с", "01.01.2024")
                .resumeConstructorToggle("Есть опыт работы")
                .functionalButtons("Сохранить и опубликовать")
                .myResumeCheck("Мои резюме");
    }
}
