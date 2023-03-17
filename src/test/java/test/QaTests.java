package test;

import org.junit.jupiter.api.*;
import core.BrowserConfig;
import pages.*;

public class QaTests extends BrowserConfig {

    private final String url = System.getProperty("base_url", "localhost:8080");
    private final String login = System.getProperty("login", "admin");
    private final String password = System.getProperty("password", "admin");

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
                .uploadPhoto()
                .inputValueIntoField("Желаемая должность", "Программист")
                .selectRandomIntoDropDown("Сфера деятельности")
                .inputValueIntoDropDown("Профессия", "Учитель")
                .inputValueIntoField("Заработная плата (руб.)", "30000")
                .inputValueIntoField("Готов приступить к работе с", "01.01.2024")
                .inputValueIntoDropDown("Населенный пункт", "город")
                .resumeConstructorToggle("Есть опыт работы")
                .inputValueIntoDropDown("Выберите навыки", "умение")
                .inputValueIntoDropDown("Выберите навыки", "умение", "2")
                .selectRandomIntoDropDown("Образование")
                .inputValueIntoDropDown("Учебное заведение", "Университет")
                .selectFirstValueDropDownField("Специальность по диплому")
                .functionButtons("Сохранить и опубликовать")
                .myResumeCheck("Мои резюме");
    }
}
