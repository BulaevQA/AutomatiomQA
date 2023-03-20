package test;

import org.junit.jupiter.api.*;
import core.BrowserConfig;
import pages.main.MainNonAuthPage;

public class QaTests extends BrowserConfig {

    private final String url = System.getProperty("base_url", "localhost:8080");
    private final String login = System.getProperty("login", "admin");
    private final String password = System.getProperty("password", "admin");
    private final String filePath = "src/test/resources/cvPhoto.png";

    @Test
    @Tag("ResumeTest")
    @DisplayName("Тест создания резюме")
    public void createResumeTest() {
        new MainNonAuthPage()
                .openUrl(url)
                .buttonLogin()
                .buttonEsiaAuth()
                .authForm(login, password)
                .selectUser("Частное лицо")
                .buttonCreateResume()
                .inputValueField("Желаемая должность", "Программист")
                .selectRandomIntoDropDown("Сфера деятельности")
                .inputValueDropDown("Профессия", "Учитель", "Учитель")
                .inputValueField("Заработная плата (руб.)", "30000")
                .clickButton("Сохранить и опубликовать");
    }
}
