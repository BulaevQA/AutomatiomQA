package test.vacancyTests;

import base.BrowserConfig;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static core.classObjects.ClassObjects.*;

public class VacancyFullProcess extends BrowserConfig {

    @Test
    @Tag("Smoke")
    @Epic(value = "Конструкторы")
    @Description(value = "Тест создания, модерации и удаления вакансии")
    @DisplayName("Creation and moderation vacancy")
    public void createVacancyTest() {
        // Авторизируемся на ПРР
        authTestManager.authTestManager();
        // Созадем вакансию
        openLink.openLink("Добавить вакансию", "3");
        dropDown.inputNewValueDropDown("Название вакансии", testValues.position);
        dropDown.inputValueDropDown("Профессия", testValues.profession);
        dropDown.selectDropDown("Сфера деятельности", testValues.workSphere);
        input.inputIframeField("Обязанности", testValues.jobFields);
        input.inputIframeField("Требования", testValues.jobFields);
        input.inputStringField("Контактное лицо", testValues.myName);
        click.clickButton("Сохранить и опубликовать");
        myVacancyPage.pageTitle();
        myVacancyPage.statusWaitForModeration();
        // Открываем АРМ АДМ и находим нашу вакансию
        openLink.openUrl(testValues.urlAdm);
        input.inputStringField("Имя пользователя", testValues.loginAdm);
        input.inputStringField("Пароль", testValues.passwordAdm);
        click.clickButton("Вход", "2");
        click.clickButton("Модерация");
        click.clickButton("Модерация вакансий");
        input.inputStringField("Дата от", testValues.currentDate);
        click.clickButton("Применить");
        mainAdmPage.moderationObject(testValues.position);
        // Проводим положительную модерацию вакансии
        switchWindow.switchToActiveWindow();
        click.clickButton("Модерация", "2");
        click.clickCheckboxes("Проводимые проверки");
        click.clickButton("Модерация", "3");
        openLink.openUrl(testValues.url);
        mainPage.pageTitle();
        openLink.openLink("Вакансии компании");
        myVacancyPage.pageTitle();
        myVacancyPage.statusApproved();
        openLink.openLink(testValues.position);
        // Делаем ассерт для подтверждения корректности теста
        Assertions.assertThat(actualVacancy.actualValueVacancy()).isEqualTo(expectedVacancy.expectedVacancy());
        // Удаляем вакансию
        click.clickButton("Вакансии компании");
        openLink.openLink("Управление вакансиями");
        myVacancyPage.pageTitle();
        myVacancyPage.deleteVacancy();
    }
}
