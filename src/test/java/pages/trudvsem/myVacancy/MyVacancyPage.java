package pages.trudvsem.myVacancy;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import helpers.HashMaps;
import io.qameta.allure.Step;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;
import static pages.core.ClassObjects.infoBlockHealth;
import static pages.core.ClassObjects.meatBalls;

public class MyVacancyPage {

    private final SelenideElement myVacancyTitleCheck = $x("//h1[text()='Вакансии компании']");
    private final SelenideElement vacancyNameCheck = $x("(//a[@data-content='title'])[last()]");
    private final SelenideElement vacancyModStatusCheck = $x("(//div[contains(@class, 'status ')]//span[@class])[last()]");
    private final SelenideElement deleteVacancyModal = $x("(//div[@class='dropdown-menu dropdown-menu-right show']" +
            "//button)[last()]");
    private final SelenideElement confirmDeleteVacancy = $x("(//div[@class='modal__content'])[last()]" +
            "//div[3]//*[text()='Удалить']");
    private final SelenideElement foundCandidateQ = $x("//div[@class='modal__content']//*[text()='Да']");


    public Map<String, Object> actualAttributes() {
        return new HashMap<String, Object>() {{
            put(HashMaps.infoBlockError, infoBlockHealth.errorInfoBlock());
            put(HashMaps.myVacancyTitle, myVacancyTitle());
            put(HashMaps.vacancyName, vacancyName());
            put(HashMaps.vacancyModStatusCheck, moderationStatus());
        }};
    }

    /**
     === Получение загаовка старницы Вакансии компании ===
     */
    @Step(value = "Получение заголовка страницы")
    public String myVacancyTitle() {
        return myVacancyTitleCheck.getText();
    }

    /**
     === Получение наименование вакансии ===
     */
    @Step(value = "Получение наименования вакансии")
    public String vacancyName() {
        return vacancyNameCheck.getText();
    }

    /**
     === Получение статуса модерации вакансии ===
     */
    @Step(value = "Получение статуса модерации ")
    public String moderationStatus() {
       return vacancyModStatusCheck.getText();
    }

    /**
     === Метод удаления вакансии ===
     */
    @Step(value = "Процесс удаления вакансии")
    public void deleteVacancy() {
        meatBalls.serviceMeatBalls(1000);
        deleteVacancyModal.should(Condition.enabled).click();
        sleep(1000);
        confirmDeleteVacancy.should(Condition.enabled).click();
        foundCandidateQ.should(Condition.enabled).click();
    }
}
