package test.resumeTests;

import base.BrowserConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static core.classObjects.ClassObjects.*;

public class ResumeFullProcess extends BrowserConfig {

    @Test
    @Tag("Smoke")
    @DisplayName("Creation and moderation resume")
    public void resumeModerationTest() {
        //Авторизируемся на портал
        authTestCv.authTestCv();
        //Создаем резюме
        openLink.openLink("Создать резюме");
        resumeConstructorPage.pageTitle();
        input.inputValueField("Желаемая должность", testValues.position);
        dropDown.inputValueDropDown("Профессия", testValues.profession);
        dropDown.selectDropDown("Сфера деятельности", testValues.workSphere);
        input.inputValueField("Заработная плата (руб.)", testValues.salary);
        toggleSwitch.switchToggle("Есть опыт работы");
        click.clickButton("Сохранить и опубликовать");
        notificationCheck.notification();
        myResumePage.pageTitle();
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
        mainPage.pageTitle();
        openLink.openLink("Резюме");
        myResumePage.statusApproved();
        openLink.openLink(testValues.position);
        // Делаем ассерт для подтверждения корректности теста
        Assertions.assertEquals(expectedResume.expectedResume(), actualResume.actualValueResume());
        // Удаляем резюме
        click.clickButton("Мои резюме");
        openLink.openLink("Список моих резюме");
        myResumePage.pageTitle();
        myResumePage.deleteResume();
    }
}
