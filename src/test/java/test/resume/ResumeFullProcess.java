package test.resume;

import base.BrowserConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static pages.core.ClassObjects.*;

public class ResumeFullProcess extends BrowserConfig {

    @Test
    @Tag("Smoke")
    @DisplayName("Creation and moderation resume")
    public void resumeModerationTest() {
        //Авторизируемся на портал
        authTestCv.authTest();
        //Создаем резюме
        mainPage.buttonCreateResume();
        inputValueField.inputValueField("Желаемая должность", "Автотест");
        inputValueDropDown.inputValueDropDown("Профессия", "Учитель-артодонт", "Учитель", 1500);
        selectDropDown.selectDropDown("Сфера деятельности", "Домашний персонал");
        inputValueField.inputValueField("Заработная плата (руб.)", "30000");
        toggleSwitch.switchToggle("Есть опыт работы");
        clickButton.clickButton("Сохранить и опубликовать");
        // Открываем АРМ АДМ и находим наше резюме
        openUrl.openUrl(urlAdm, 1000);
        inputValueField.inputValueField("Имя пользователя", loginAdm);
        inputValueField.inputValueField("Пароль", passwordAdm);
        clickButton.clickButton("Вход", "2");
        clickButton.clickButton("Модерация");
        clickButton.clickButton("Модерация резюме");
        inputValueField.inputValueField("Дата от", "22.03.2023");
        mainAdmPage.moderationButtons("2");
        mainAdmPage.moderationObject("Автотест");
        // Проводим положительную модерацию резюме
        switchWindow.switchToActiveWindow(2000);
        clickButton.clickButton("Модерация", "2");
        clickCheckbox.clickCheckboxes("Проводимые проверки", 2000);
        clickButton.clickButton("Модерация", 1000, "3");
        openUrl.openUrl(url + "auth/candidate/cvs", 1000);
        // Делаем ассерт для подтверждения корректности теста
        Assertions.assertEquals(hashMaps.expectedMinResumeModerated(), myResumePage.actualAttributes());
        myResumePage.deleteResume();
    }
}
