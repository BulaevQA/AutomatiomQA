package pages.trudvsemPages.vacancyPage;

import base.BrowserConfig;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;
import static core.classObjects.ClassObjects.*;

public class MyVacancyPage extends BrowserConfig {

    private final SelenideElement
            pageTitle = $x("//h1[@class][text()[normalize-space()='Вакансии компании']]"),
            vacancyNameCheck = $x("(//a[@data-content='title'])[last()]"),
            statusWaitForModeration = $x("(//div[@class='status status_warning']//span[text()='Ожидает модерации '])[last()]"),
            statusApproved = $x("(//div[@class='status ']//span[text()='Одобрена '])[last()]"),
            deleteModalWindow = $x("//div[@class='dropdown-menu dropdown-menu-right show' and @style]"),
            deleteVacancyModal = $x("//div[@class='dropdown-menu dropdown-menu-right show']//button"),
            confirmDeleteVacancy = $x("(//div[@class='modal__content'])/..//button[text()='Удалить']"),
            foundCandidateQuestion = $x("//div[@class='modal__content']//button[text()='Да']");

    /**
     === Провека заголовка страницы ===
     */
    @Step(value = "Проверка заголовка страницы")
    public boolean pageTitle() {
        return pageTitle.should(visible).exists();
    }

    /**
     === Получение наименования вакансии
     */
    @Step(value = "Получение наименования вакансии")
    public String vacancyName() {
        return vacancyNameCheck.should(exist, visible).getText();
    }

    /**
     === Проверка статуса модерации ===
     */
    @Step(value = "Статус вакансии Ожидает модерации найден")
    public boolean statusWaitForModeration() {
       return statusWaitForModeration.should(visible).exists();
    }

    /**
     === Проверка статуса модерации ===
     */
    @Step(value = "Статус вакансии Одобрена найден")
    public boolean statusApproved() {
        return statusApproved.should(visible).exists();
    }

    /**
     === Процесс удаления вакансии
     */
    @Step(value = "Удаляем вакансию")
    public void deleteVacancy() {
        click.clickMeatBalls();
        deleteVacancyModal.should(visible, enabled, appear).click();
        switchWindow.switchToActiveWindow();
        confirmDeleteVacancy.should(visible, enabled).click();
        foundCandidateQuestion.should(visible, enabled).click();
        switchWindow.switchToDefaultWindow();
    }
}
