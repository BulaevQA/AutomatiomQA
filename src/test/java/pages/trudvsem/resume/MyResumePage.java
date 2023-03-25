package pages.trudvsem.resume;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;
import static helpers.other.ClassObjects.meatBalls;

public class MyResumePage {

    ///////////////// XPath \\\\\\\\\\\\\\\\\\\

    private final SelenideElement
            progressBarCheck = $x("(//progress)[last()]"),
            resumeModStatusCheck = $x("(//div[contains(@class, 'status ')]//span[not(contains(@class,'d-flex'))])[last()]"),
            resumeNameCheck = $x("(//div[@data-name]//h2//a)[last()]"),
            deleteResumeModal = $x("(//button[@class='dropdown-item']//span/..)[last()]"),
            confirmDeleteResume = $x("(//div[@class='modal__content'])[last()]//div[3]//*[text()='Удалить']"),
            deleteNotification = $x("//div[@class='notifications__card-title']"),
            pageTitle = $x("//h1[text()='Мои резюме']");

    ///////////////// Логика взаимодействия cо страницей \\\\\\\\\\\\\\\\\\\

    /**
     * === Метод получения заголовска страницы ===
     */
    @Step(value = "Получение заголовка стрницы")
    public String myResumeTitle() {
        return pageTitle.should(exist, visible).getText();
    }

    /**
     === Получение названия резюме ===
     */
    @Step(value = "Получение наименования резюме")
    public String resumeNameCheck() {
        return resumeNameCheck.should(exist, visible).getText().trim();
    }

    /**
     === Проверка заполнения резюме ===
     */
    @Step(value = "Получение заполнености резюме")
    public String progressBarCheck() {
        return progressBarCheck.should(exist, visible).getAttribute("value");
    }

    /**
     === Получение статуса модерации резюме ===
     */
    @Step(value = "Получение статуса модерации резюме")
    public String moderationStatusCheck() {
        return resumeModStatusCheck.should(exist, visible).getText();
    }

    /**
     === Метод удаления резюме ===
     */
    @Step(value = "Процесс удаления резюме")
    public void deleteResume() {
        meatBalls.serviceMeatBalls();
        deleteResumeModal.should(exist, visible, enabled).click();
        confirmDeleteResume.should(exist, visible, enabled).click();
        deleteNotification.should(appear, visible);
    }
}
