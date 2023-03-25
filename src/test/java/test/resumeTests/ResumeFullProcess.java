package test.resumeTests;

import base.BrowserConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static helpers.other.ClassObjects.*;

public class ResumeFullProcess extends BrowserConfig {

    @Test
    @Tag("Smoke")
    @DisplayName("Creation and moderation resume")
    public void resumeModerationTest() {
        //Авторизируемся на портал
        authTestCv.authTest();
        //Создаем резюме
        openLink.openLink("Создать резюме");
        input.inputValueField("Желаемая должность", "Автотест");
        dropDown.inputValueDropDown("Профессия", "Учитель");
        dropDown.selectDropDown("Сфера деятельности", "Домашний персонал");
        input.inputValueField("Заработная плата (руб.)", "30000");
        toggleSwitch.switchToggle("Есть опыт работы");
        click.clickButton("Сохранить и опубликовать");
        // Открываем АРМ АДМ и находим наше резюме
        openLink.openUrl(urlAdm);
        input.inputValueField("Имя пользователя", loginAdm);
        input.inputValueField("Пароль", passwordAdm);
        click.clickButton("Вход", "2");
        click.clickButton("Модерация");
        click.clickButton("Модерация резюме");
        input.inputValueField("Дата от", getCurrentDate.getCurrentDate());
        click.clickButton("Применить");
        mainAdmPage.moderationObject("Автотест");
        // Проводим положительную модерацию резюме
        switchWindow.switchToActiveWindow();
        click.clickButton("Модерация", "2");
        click.clickCheckboxes("Проводимые проверки");
        click.clickButton("Модерация", "3");
        openLink.openUrl(url+"auth/candidate/cvs");
        // Делаем ассерт для подтверждения корректности теста
        Assertions.assertEquals(expectedHashMaps.expectedResume(), actualHashMaps.actualValueResume());
        // Удаляем резюме
        myResumePage.deleteResume();
    }
}
