package pages.trudvsem.resume;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;
import static helpers.other.ClassObjects.meatBalls;
import static helpers.other.ClassObjects.notificationCheck;

public class MyResumePage {

    ///////////////// XPath \\\\\\\\\\\\\\\\\\\

    private final SelenideElement
            progressBarCheck = $x("(//progress)[last()]"),
            resumeNameCheck = $x("(//div[@data-name]//h2//a)[last()]"),
            statusWaitForModeration = $x("(//div[@class='status status_warning']//span[text()='Ожидает модерации'])[last()]"),
            statusApproved = $x("(//div[@class='status ']//span[text()='Одобрено'])[last()]"),
            deleteResumeModal = $x("(//button[@class='dropdown-item']//span/..)[last()]"),
            confirmDeleteResume = $x("(//div[@class='modal__content'])/..//button[text()='Удалить']");


    ///////////////// Логика взаимодействия cо страницей \\\\\\\\\\\\\\\\\\\

    /**
     === Получение названия резюме ===
     */
    @Step(value = "Получение наименования резюме")
    public String resumeName() {
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
    @Step(value = "Статус резюме Ожидает модерации")
    public String statusWaitForModeration() {
        return statusWaitForModeration.should(exist, visible).getText().trim();
    }

    /**
     === Получение статуса модерации резюме ===
     */
    @Step(value = "Статус резюме Одобрено")
    public String statusApproved() {
        return statusApproved.should(exist, visible).getText().trim();
    }

    /**
     === Метод удаления резюме ===
     */
    @Step(value = "Процесс удаления резюме")
    public void deleteResume() {
        meatBalls.serviceMeatBalls();
        deleteResumeModal.should(visible, enabled).click();
        confirmDeleteResume.should(visible, enabled).click();
        notificationCheck.notificationCheck();
    }
}
