package pages.trudvsem.vacancy;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;
import static helpers.other.ClassObjects.meatBalls;

public class MyVacancyPage {

    private final SelenideElement
            vacancyNameCheck = $x("(//a[@data-content='title'])[last()]"),
            statusWaitForModeration = $x("(//div[@class='status status_warning']//span[text()='Ожидает модерации '])[last()]"),
            statusApproved = $x("(//div[@class='status ']//span[text()='Одобрена '])[last()]"),
            deleteVacancyModal = $x("(//div[@class='dropdown-menu dropdown-menu-right show']//button)[last()]"),
            confirmDeleteVacancy = $x("(//div[@class='modal__content'])/..//button[text()='Удалить']"),
            foundCandidateQuestion = $x("//div[@class='modal__content']//button[text()='Да']");

    /**
     === Получение наименование вакансии ===
     */
    @Step(value = "Получение наименования вакансии")
    public String vacancyName() {
        return vacancyNameCheck.should(exist, visible).getText();
    }

    /**
     === Получение статуса модерации вакансии ===
     */
    @Step(value = "Статус вакансии Ожидает модерации")
    public String statusWaitForModeration() {
       return statusWaitForModeration.should(exist, visible).getText().trim();
    }

    /**
     === Получение статуса модерации вакансии ===
     */
    @Step(value = "Статус вакансии Одобрена")
    public String statusApproved() {
        return statusApproved.should(exist, visible).getText().trim();
    }

    /**
     === Метод удаления вакансии ===
     */
    @Step(value = "Процесс удаления вакансии")
    public void deleteVacancy() {
        meatBalls.serviceMeatBalls();
        deleteVacancyModal.should(visible, enabled).click();
        confirmDeleteVacancy.should(visible, enabled).click();
        foundCandidateQuestion.should(visible, enabled).click();
    }
}
