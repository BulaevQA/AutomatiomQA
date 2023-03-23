package test.resume;

import base.BrowserConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static helpers.ClassObjects.*;

public class ResumeFullProcess extends BrowserConfig {

    @Test
    @Tag("Smoke")
    @DisplayName("Creation and moderation resume")
    public void resumeModerationTest() {
        //Авторизируемся на портал
        authTestCv.authTest();
        //Создаем резюме
        mainPage.buttonCreateResume();
        input.inputValueField("Желаемая должность", "Автотест");
        dropDown.inputValueDropDown("Профессия", "Учитель-артодонт", "Учитель", 1500);
        dropDown.selectDropDown("Сфера деятельности", "Домашний персонал");
        input.inputValueField("Заработная плата (руб.)", "30000");
        toggleSwitch.switchToggle("Есть опыт работы");
        click.clickButton("Сохранить и опубликовать");
        // Открываем АРМ АДМ и находим наше резюме
        openLink.openUrl(urlAdm, 1000);
        input.inputValueField("Имя пользователя", loginAdm);
        input.inputValueField("Пароль", passwordAdm);
        click.clickButton("Вход", "2");
        click.clickButton("Модерация");
        click.clickButton("Модерация резюме");
        input.inputValueField("Дата от", "22.03.2023");
        mainAdmPage.moderationButtons("2");
        mainAdmPage.moderationObject("Автотест");
        // Проводим положительную модерацию резюме
        switchWindow.switchToActiveWindow(2000);
        click.clickButton("Модерация", "2");
        click.clickCheckboxes("Проводимые проверки", 2000);
        click.clickButton("Модерация", 1000, "3");
        openLink.openUrl(url + "auth/candidate/cvs", 1000);
        // Делаем ассерт для подтверждения корректности теста
        Assertions.assertEquals(expectedHashMaps.expectedResume(), actualHashMaps.actualValueResume());
        // Удаляем резюме
        myResumePage.deleteResume();
    }
}
