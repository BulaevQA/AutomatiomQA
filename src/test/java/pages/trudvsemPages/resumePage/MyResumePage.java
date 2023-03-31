package pages.trudvsemPages.resumePage;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;
import static core.classObjects.ClassObjects.meatBalls;
import static core.classObjects.ClassObjects.notificationCheck;

public class MyResumePage {

    ///////////////// XPath \\\\\\\\\\\\\\\\\\\

    private final SelenideElement
            pageTitle = $x("//h1[@class][text()[normalize-space()='Мои резюме']]"),
            progressBarCheck = $x("(//progress)[last()]"),
            resumeNameCheck = $x("(//div[@data-name]//h2//a)[last()]"),
            statusWaitForModeration = $x("(//div[@class='status status_warning']//span[text()='Ожидает модерации'])[last()]"),
            statusApproved = $x("(//div[@class='status ']//span[text()='Одобрено'])[last()]"),
            deleteResumeModal = $x("(//button[@class='dropdown-item']//span/..)[last()]"),
            confirmDeleteResume = $x("(//div[@class='modal__content'])/..//button[text()='Удалить']");


    ///////////////// Логика взаимодействия cо страницей \\\\\\\\\\\\\\\\\\\

    /**
     === Сравнение заголовка страницы ===
     */
    @Step(value = "Получение заголоска страницы")
    public boolean pageTitle() {
        return pageTitle.should(visible).exists();
    }

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
    public boolean statusWaitForModeration() {
        return statusWaitForModeration.should(visible).exists();
    }

    /**
     === Получение статуса модерации резюме ===
     */
    @Step(value = "Статус резюме Одобрено")
    public boolean statusApproved() {
        return statusApproved.should(visible).exists();
    }

    /**
     === Метод удаления резюме ===
     */
    @Step(value = "Процесс удаления резюме")
    public void deleteResume() {
        meatBalls.serviceMeatBalls();
        deleteResumeModal.should(visible, enabled).click();
        confirmDeleteResume.should(visible, enabled).click();
        notificationCheck.notification();
    }
}
