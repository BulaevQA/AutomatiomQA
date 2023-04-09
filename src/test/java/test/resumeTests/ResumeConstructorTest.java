package test.resumeTests;

import base.BrowserConfig;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static core.classObjects.ClassObjects.*;

public class ResumeConstructorTest extends BrowserConfig {

    @Test
    @Tag("Smoke")
    @Epic(value = "Конструкторы")
    @Description(value = "Тест создания, модерации и удаления резюме")
    @DisplayName("Creation and moderation resume")
    public void resumeModerationTest() {
        //Авторизируемся на портал
        authTestCv.authTestCv();
        //Создаем резюме
        openLink.openLink("Создать резюме");
        resumeConstructorPage.pageTitle();
        input.inputStringField("Желаемая должность", testValues.position);
        dropDown.selectDropDown("Сфера деятельности", testValues.workSphere);
        input.inputStringField("Заработная плата (руб.)", testValues.salary);
        toggleSwitch.switchToggle("Есть опыт работы");
        click.clickButton("Сохранить и опубликовать");
        myResumePage.pageTitle();
        myResumePage.statusWaitForModeration();
        // Открываем АРМ АДМ и находим наше резюме
        switchWindow.openWindowType(testValues.newTab);
        openLink.openUrl(testValues.urlAdm);
        input.inputStringField("Имя пользователя", testValues.loginAdm);
        input.inputStringField("Пароль", testValues.passwordAdm);
        click.clickButton("Вход", "2");
        click.clickButton("Модерация");
        click.clickButton("Модерация резюме");
        input.inputStringField("Дата от", testValues.currentDate);
        click.clickButton("Применить");
        mainAdmPage.moderationObject(testValues.position);
        // Проводим положительную модерацию резюме
        switchWindow.switchToActiveWindow();
        click.clickButton("Модерация", "2");
        click.clickCheckboxes("Проводимые проверки");
        click.clickButton("Модерация", "3");
        mainAdmPage.checkModerationObject(testValues.position);
        switchWindow.switchBetweenWindows(0);
        myResumePage.pageTitle();
        myResumePage.statusApproved();
        openLink.openLink(testValues.position);
        // Делаем ассерт для подтверждения корректности теста
        Assertions.assertThat(actualResume.actualValueResume()).isEqualTo(expectedResume.expectedResume());
        // Удаляем резюме
        click.clickButton("Мои резюме");
        openLink.openLink("Список моих резюме");
        myResumePage.pageTitle();
        myResumePage.deleteResume();
    }
}
