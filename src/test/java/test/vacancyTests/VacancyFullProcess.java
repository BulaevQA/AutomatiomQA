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
        openLink.openLink("Добавить вакансию");
        dropDown.inputValueDropDown("Название вакансии", "Автотест", "Автотест", 1500);
        dropDown.inputValueDropDown("Профессия", "Учитель", "Учитель");
        dropDown.selectDropDown("Сфера деятельности", "Высший менеджмент");
        input.inputIframeField("Обязанности", "Обязанность на рабочем месте");
        input.inputIframeField("Требования", "Требование для рабочего места");
        input.inputValueField("Контактное лицо", "Булаев Денис");
        click.clickButton("Сохранить и опубликовать");
        // Открываем АРМ АДМ и находим нашу вакансию
        openLink.openUrl(urlAdm, 1000);
        input.inputValueField("Имя пользователя", loginAdm);
        input.inputValueField("Пароль", passwordAdm);
        click.clickButton("Вход", "2");
        click.clickButton("Модерация");
        click.clickButton("Модерация вакансий");
        input.inputValueField("Дата от", getCurrentDate.getCurrentDate());
//        mainAdmPage.moderationButtons("2");
        mainAdmPage.moderationObject("Автотест");
        // Проводим положительную модерацию вакансии
        switchWindow.switchToActiveWindow(2000);
        click.clickButton("Модерация", "2");
        click.clickCheckboxes("Проводимые проверки", 2000);
        click.clickButton("Модерация", 1000, "3");
        openLink.openUrl(url+"auth/manager/vacancies", 3500);
        // Делаем ассерт для подтверждения корректности теста
        Assertions.assertEquals(expectedHashMaps.expectedVacancy(), actualHashMaps.actualValueVacancy());
        // Удаляем вакансию
        myVacancyPage.deleteVacancy();
    }
}
