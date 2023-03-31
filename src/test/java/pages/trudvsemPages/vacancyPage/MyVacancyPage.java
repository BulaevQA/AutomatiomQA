package pages.trudvsemPages.vacancyPage;

import base.BrowserConfig;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;
import static core.classObjects.ClassObjects.meatBalls;

public class MyVacancyPage extends BrowserConfig {

    private final SelenideElement
            pageTitle = $x("//h1[@class][text()[normalize-space()='Вакансии компании']]"),
            vacancyNameCheck = $x("(//a[@data-content='title'])[last()]"),
            statusWaitForModeration = $x("(//div[@class='status status_warning']//span[text()='Ожидает модерации '])[last()]"),
            statusApproved = $x("(//div[@class='status ']//span[text()='Одобрена '])[last()]"),
            deleteVacancyModal = $x("(//div[@class='dropdown-menu dropdown-menu-right show']//button)[last()]"),
            confirmDeleteVacancy = $x("(//div[@class='modal__content'])/..//button[text()='Удалить']"),
            foundCandidateQuestion = $x("//div[@class='modal__content']//button[text()='Да']");


    @Step(value = "Получение заголоска страницы")
    public boolean pageTitle() {
        return pageTitle.should(visible).exists();
    }

    @Step(value = "Получение наименования вакансии")
    public String vacancyName() {
        return vacancyNameCheck.should(exist, visible).getText();
    }

    @Step(value = "Статус вакансии Ожидает модерации")
    public boolean statusWaitForModeration() {
       return statusWaitForModeration.should(visible).exists();
    }

    @Step(value = "Статус вакансии Одобрена")
    public boolean statusApproved() {
        return statusApproved.should(visible).exists();
    }

    @Step(value = "Процесс удаления вакансии")
    public void deleteVacancy() {
        meatBalls.serviceMeatBalls();
        deleteVacancyModal.should(visible, enabled).click();
        confirmDeleteVacancy.should(visible, enabled).click();
        foundCandidateQuestion.should(visible, enabled).click();
    }
}
