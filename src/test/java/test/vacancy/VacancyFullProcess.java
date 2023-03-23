package test.vacancy;

import base.BrowserConfig;
import helpers.HashMaps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.adm.MainAdmPage;
import pages.core.CorePage;
import pages.trudvsem.mainPrr.MainPage;
import pages.trudvsem.myVacancy.MyVacancyPage;
import test.auth.AuthTestCv;
import test.auth.AuthTestManager;

public class VacancyFullProcess extends BrowserConfig {

    CorePage corePage = new CorePage();
    MainPage mainPage = new MainPage();
    MainAdmPage mainAdmPage = new MainAdmPage();
    HashMaps hashMaps = new HashMaps();
    MyVacancyPage myVacancyPage = new MyVacancyPage();
    AuthTestManager authTestManager = new AuthTestManager();

    @Test
    @Tag("Smoke")
    @DisplayName("Создание и модерация вакансии")
    public void createVacancyTest() {
        authTestManager // Авторизируемся на ПРР
                .authTest();
        mainPage // Открываем конструктор резюме и заполняем его
                .buttonCreateVacancy()
                .inputValueDropDown("Название вакансии", "Автотест", "Автотест", 1500)
                .inputValueDropDown("Профессия", "Учитель", "Учитель")
                .selectDropDown("Сфера деятельности", "Высший менеджмент")
                .inputIframeField("Обязанности", "Обязанность на рабочем месте")
                .inputIframeField("Требования", "Требование для рабочего места")
                .inputValueField("Контактное лицо", "Булаев Денис")
                .clickButton("Сохранить и опубликовать");
        corePage // Открываем АРМ АДМ и находим нашу вакансию
                .openUrl(urlAdm, 1000)
                .inputValueField("Имя пользователя", loginAdm)
                .inputValueField("Пароль", passwordAdm)
                .clickButton("Вход", "2")
                .clickButton("Модерация")
                .clickButton("Модерация вакансий")
                .inputValueField("Дата от", "22.03.2023");
        mainAdmPage // Ищем вакансию по названию вакансии
                .moderationButtons("2")
                .moderationObject("Автотест");
        corePage // Проводим положительную модерацию вакансии
                .switchToActiveWindow(2000)
                .clickButton("Модерация", "2")
                .clickCheckboxes("Проводимые проверки", 2000)
                .clickButton("Модерация", 1000, "3")
                .openUrl(url + "auth/manager/vacancies", 3500);
        Assertions // Делаем ассерт для подтверждения корректности теста
                .assertEquals(hashMaps.expectedVacancyModerated(), myVacancyPage.actualAttributes());
        myVacancyPage // Удаляем вакансию
                .deleteVacancy(1000);
    }
}
