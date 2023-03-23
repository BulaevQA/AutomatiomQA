package test.resume;

import base.BrowserConfig;
import helpers.HashMaps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.adm.MainAdmPage;
import pages.core.CorePage;
import pages.trudvsem.mainPrr.MainPage;
import pages.trudvsem.myResume.MyResumePage;
import test.auth.AuthTestCv;

public class ResumeFullProcess extends BrowserConfig {

    MainAdmPage mainAdmPage = new MainAdmPage();
    CorePage corePage = new CorePage();
    HashMaps hashMaps = new HashMaps();
    MyResumePage myResumePage = new MyResumePage();
    AuthTestCv authTestCv = new AuthTestCv();
    MainPage mainPage = new MainPage();

    @Test
    @Tag("Smoke")
    @DisplayName("Создание и модерация резюме")
    public void resumeModerationTest() {
        authTestCv // Авторизируемся на ПРР
                .authTest();
        mainPage // Открываем конструктор резюме и заполняем его
                .buttonCreateResume()
                .inputValueField("Желаемая должность", "Автотест")
                .inputValueDropDown("Профессия", "Учитель-артодонт", "Учитель", 1500)
                .selectDropDown("Сфера деятельности", "Домашний персонал")
                .inputValueField("Заработная плата (руб.)", "30000")
                .switchToggle("Есть опыт работы")
                .clickButton("Сохранить и опубликовать");
        corePage // Открываем АРМ АДМ и находим наше резюме
                .openUrl(urlAdm, 1000)
                .inputValueField("Имя пользователя", loginAdm)
                .inputValueField("Пароль", passwordAdm)
                .clickButton("Вход", "2")
                .clickButton("Модерация")
                .clickButton("Модерация резюме")
                .inputValueField("Дата от", "22.03.2023");
        mainAdmPage // Ищем резюме по названию резюме
                .moderationButtons("2")
                .moderationObject("Автотест");
        corePage // Проводим положительную модерацию резюме
                .switchToActiveWindow(2000)
                .clickButton("Модерация", "2")
                .clickCheckboxes("Проводимые проверки", 2000)
                .clickButton("Модерация", 1000, "3")
                .openUrl(url + "auth/candidate/cvs", 1000);
        Assertions // Делаем ассерт для подтверждения корректности теста
                .assertEquals(hashMaps.expectedMinResumeModerated(), myResumePage.actualAttributes());
        myResumePage // Удаляем резюме
                .deleteResume(1000);
    }
}
