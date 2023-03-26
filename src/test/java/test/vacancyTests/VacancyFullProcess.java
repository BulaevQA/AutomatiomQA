package test.vacancyTests;

import base.BrowserConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static helpers.other.ClassObjects.*;

public class VacancyFullProcess extends BrowserConfig {

    @Test
    @Tag("Smoke")
    @DisplayName("Creation and moderation vacancy")
    public void createVacancyTest() {
        // Авторизируемся на ПРР
        authTestManager.authTest();
        // Созадем вакансию
        openLink.openLink("Добавить вакансию", "3");
        getPageTitle.pageTitleIsVisible("Создание вакансии");
        dropDown.inputValueDropDown("Название вакансии", testValues.position);
        dropDown.inputValueDropDown("Профессия", testValues.profession);
        dropDown.selectDropDown("Сфера деятельности", testValues.workSphere);
        input.inputIframeField("Обязанности", testValues.jobFields);
        input.inputIframeField("Требования", testValues.jobFields);
        input.inputValueField("Контактное лицо", testValues.myName);
        click.clickButton("Сохранить и опубликовать");
        getPageTitle.pageTitleIsVisible("Вакансии компании");
        myVacancyPage.statusWaitForModeration();
        // Открываем АРМ АДМ и находим нашу вакансию
        openLink.openUrl(testValues.urlAdm);
        input.inputValueField("Имя пользователя", testValues.loginAdm);
        input.inputValueField("Пароль", testValues.passwordAdm);
        click.clickButton("Вход", "2");
        click.clickButton("Модерация");
        click.clickButton("Модерация вакансий");
        input.inputValueField("Дата от", testValues.currentDate);
        click.clickButton("Применить");
        mainAdmPage.moderationObject(testValues.position);
        // Проводим положительную модерацию вакансии
        switchWindow.switchToActiveWindow();
        click.clickButton("Модерация", "2");
        click.clickCheckboxes("Проводимые проверки");
        click.clickButton("Модерация", "3");
        openLink.openUrl(testValues.url);
        openLink.openLink("Вакансии компании");
        myVacancyPage.statusApproved();
        openLink.openLink(testValues.position);
        // Делаем ассерт для подтверждения корректности теста
        Assertions.assertEquals(expectedHashMaps.expectedVacancy(), actualHashMaps.actualValueVacancy());
        // Удаляем вакансию
        click.clickButton("Вакансии компании");
        openLink.openLink("Управление вакансиями");
        getPageTitle.pageTitleIsVisible("Вакансии компании");
        myVacancyPage.deleteVacancy();
    }
}
