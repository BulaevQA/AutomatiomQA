package pages.trudvsem.myVacancy;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import helpers.HashMaps;
import helpers.InfoBlockHealth;
import helpers.MeatBalls;
import io.qameta.allure.Step;
import pages.core.CorePage;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$x;

public class MyVacancyPage {

    MeatBalls meatBalls = new MeatBalls();
    CorePage corePage = new CorePage();

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
            put(HashMaps.infoBlockError, new InfoBlockHealth().errorInfoBlock());
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
     * @param milliseconds - таймер ожидания перед кликом на элемент(для стабильности теста)
     */
    @Step(value = "Процесс удаления вакансии")
    public void deleteVacancy(int milliseconds) {
        meatBalls.serviceMeatBalls(milliseconds);
        deleteVacancyModal.should(Condition.enabled).click();
        corePage.sleeper(milliseconds);
        confirmDeleteVacancy.should(Condition.enabled).click();
        foundCandidateQ.should(Condition.enabled).click();
    }
}
