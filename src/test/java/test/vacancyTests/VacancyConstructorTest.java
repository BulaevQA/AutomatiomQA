package test.vacancyTests;

import base.BrowserConfig;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;

import static core.classObjects.ClassObjects.*;

public class VacancyConstructorTest extends BrowserConfig {

    @Test
    @Tag("Smoke")
    @Epic(value = "Конструкторы")
    @Description(value = "Тест создания, модерации и удаления вакансии")
    @DisplayName("Creation and moderation vacancy")
    public void createVacancyTest() {
        // Авторизируемся на ПРР
        authTestManager.authTestManager();
        // Открываем конструктор вакансии
        open.openLink("Добавить вакансию", "3");
        vacancyConstructorPage.pageTitle();
        // Заполняем конструктор и подтверждаем создание вакансии
        dropDown.inputNewValueDropDown("Название вакансии", testValues.position);
        dropDown.inputValueDropDown("Профессия", testValues.profession);
        dropDown.selectDropDown("Сфера деятельности", testValues.workSphere);
        input.inputIframeField("Обязанности", testValues.jobFields);
        input.inputIframeField("Требования", testValues.jobFields);
        input.inputStringField("Контактное лицо", testValues.myName);
        click.clickButton("Сохранить и опубликовать");
        myVacancyPage.pageTitle();
        myVacancyPage.statusWaitForModeration();
        // Открываем АРМ АДМ и переходим на страницу подерации
        switchWindow.openWindowType(testValues.newTab);
        open.openUrl(testValues.urlAdm);
        input.inputStringField("Имя пользователя", testValues.loginAdm);
        input.inputStringField("Пароль", testValues.passwordAdm);
        click.clickButton("Вход", "2");
        click.clickButton("Модерация");
        click.clickButton("Модерация вакансий");
        input.inputStringField("ОГРН", testValues.ogrn);
        click.clickButton("Применить");
        mainAdmPage.moderationObject(testValues.position);
        // Проводим положительную модерацию вакансии
        switchWindow.switchToActiveWindow();
        click.clickButton("Модерация", "2");
        click.clickCheckboxes("Проводимые проверки");
        click.clickButton("Модерация", "3");
        mainAdmPage.checkModerationObject(testValues.position);
        switchWindow.switchBetweenWindows(0);
        myVacancyPage.pageTitle();
        myVacancyPage.statusApproved();
        open.openLink(testValues.position);
        // Делаем ассерт для подтверждения корректности теста
        Assertions.assertThat(actualVacancy.actualValueVacancy()).isEqualTo(expectedVacancy.expectedVacancy());
        // Удаляем вакансию
        click.clickButton("Вакансии компании", "3");
        myVacancyPage.pageTitle();
        myVacancyPage.deleteVacancy();
    }
}
