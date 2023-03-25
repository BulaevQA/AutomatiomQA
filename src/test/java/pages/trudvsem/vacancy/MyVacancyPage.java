package pages.trudvsem.vacancy;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;
import static helpers.other.ClassObjects.meatBalls;

public class MyVacancyPage {

    private final SelenideElement
            myVacancyTitleCheck = $x("//h1[text()='Вакансии компании']"),
            vacancyNameCheck = $x("(//a[@data-content='title'])[last()]"),
            vacancyModStatusCheck = $x("(//div[contains(@class, 'status ')]//span[@class])[last()]"),
            deleteVacancyModal = $x("(//div[@class='dropdown-menu dropdown-menu-right show']//button)[last()]"),
            confirmDeleteVacancy = $x("(//div[@class='modal__content'])[last()]//div[3]//*[text()='Удалить']"),
            foundCandidateQ = $x("//div[@class='modal__content']//*[text()='Да']");

    /**
     === Получение загаовка старницы Вакансии компании ===
     */
    @Step(value = "Получение заголовка страницы")
    public String myVacancyTitle() {
        return myVacancyTitleCheck.should(exist, visible).getText();
    }

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
    @Step(value = "Получение статуса модерации ")
    public String moderationStatus() {
       return vacancyModStatusCheck.should(exist, visible).getText();
    }

    /**
     === Метод удаления вакансии ===
     */
    @Step(value = "Процесс удаления вакансии")
    public void deleteVacancy() {
        meatBalls.serviceMeatBalls();
        deleteVacancyModal.should(exist, visible, enabled).click();
        confirmDeleteVacancy.should(exist, visible, enabled).click();
        foundCandidateQ.should(exist, visible, enabled).click();
    }
}
