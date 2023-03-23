package test.vacancy;

import base.BrowserConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static pages.core.ClassObjects.*;

public class VacancyFullProcess extends BrowserConfig {

    @Test
    @Tag("Smoke")
    @DisplayName("Creation and moderation vacancy")
    public void createVacancyTest() {
        // Авторизируемся на ПРР
        authTestManager.authTest();
        // Созадем вакансию
        mainPage.buttonCreateVacancy();
        inputValueDropDown.inputValueDropDown("Название вакансии", "Автотест", "Автотест", 1500);
        inputValueDropDown.inputValueDropDown("Профессия", "Учитель", "Учитель");
        selectDropDown.selectDropDown("Сфера деятельности", "Высший менеджмент");
        inputIframe.inputIframeField("Обязанности", "Обязанность на рабочем месте");
        inputIframe.inputIframeField("Требования", "Требование для рабочего места");
        inputValueField.inputValueField("Контактное лицо", "Булаев Денис");
        clickButton.clickButton("Сохранить и опубликовать");
        // Открываем АРМ АДМ и находим нашу вакансию
        openUrl.openUrl(urlAdm, 1000);
        inputValueField.inputValueField("Имя пользователя", loginAdm);
        inputValueField.inputValueField("Пароль", passwordAdm);
        clickButton.clickButton("Вход", "2");
        clickButton.clickButton("Модерация");
        clickButton.clickButton("Модерация вакансий");
        inputValueField.inputValueField("Дата от", "22.03.2023");
        mainAdmPage.moderationButtons("2");
        mainAdmPage.moderationObject("Автотест");
        // Проводим положительную модерацию вакансии
        switchWindow.switchToActiveWindow(2000);
        clickButton.clickButton("Модерация", "2");
        clickCheckbox.clickCheckboxes("Проводимые проверки", 2000);
        clickButton.clickButton("Модерация", 1000, "3");
        openUrl.openUrl(url + "auth/manager/vacancies", 3500);
        // Делаем ассерт для подтверждения корректности теста
        Assertions.assertEquals(hashMaps.expectedVacancyModerated(), myVacancyPage.actualAttributes());
        // Удаляем вакансию
        myVacancyPage.deleteVacancy();
    }
}
