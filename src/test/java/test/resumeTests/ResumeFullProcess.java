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
        getPageTitle.pageTitleIsVisible("Создание резюме");
        input.inputValueField("Желаемая должность", testValues.position);
        dropDown.inputValueDropDown("Профессия", testValues.profession);
        dropDown.selectDropDown("Сфера деятельности", testValues.workSphere);
        input.inputValueField("Заработная плата (руб.)", testValues.salary);
        toggleSwitch.switchToggle("Есть опыт работы");
        click.clickButton("Сохранить и опубликовать");
        notificationCheck.notificationCheck();
        getPageTitle.pageTitleIsVisible("Мои резюме");
        myResumePage.statusWaitForModeration();
        // Открываем АРМ АДМ и находим наше резюме
        openLink.openUrl(testValues.urlAdm);
        input.inputValueField("Имя пользователя", testValues.loginAdm);
        input.inputValueField("Пароль", testValues.passwordAdm);
        click.clickButton("Вход", "2");
        click.clickButton("Модерация");
        click.clickButton("Модерация резюме");
        input.inputValueField("Дата от", testValues.currentDate);
        click.clickButton("Применить");
        mainAdmPage.moderationObject(testValues.position);
        // Проводим положительную модерацию резюме
        switchWindow.switchToActiveWindow();
        click.clickButton("Модерация", "2");
        click.clickCheckboxes("Проводимые проверки");
        click.clickButton("Модерация", "3");
        openLink.openUrl(testValues.url);
        getPageTitle.pageTitleIsVisible("Мой кабинет");
        openLink.openLink("Резюме");
        getPageTitle.pageTitleIsVisible("Мои резюме");
        myResumePage.statusApproved();
        openLink.openLink(testValues.position);
        // Делаем ассерт для подтверждения корректности теста
        Assertions.assertEquals(expectedHashMaps.expectedResume(), actualHashMaps.actualValueResume());
        // Удаляем резюме
        click.clickButton("Мои резюме");
        openLink.openLink("Список моих резюме");
        getPageTitle.pageTitleIsVisible("Мои резюме");
        myResumePage.deleteResume();
    }
}
