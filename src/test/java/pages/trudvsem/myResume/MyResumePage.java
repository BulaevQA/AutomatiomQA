package pages.trudvsem.myResume;

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

public class MyResumePage {

    MeatBalls meatBalls = new MeatBalls();
    CorePage corePage = new CorePage();
    InfoBlockHealth infoBlockHealth = new InfoBlockHealth();

    ///////////////// XPath \\\\\\\\\\\\\\\\\\\

    private final SelenideElement myResumeTitleCheck = $x("//h1[text()='Мои резюме']");
    private final SelenideElement progressBarCheck = $x("(//progress)[last()]");
    private final SelenideElement resumeModStatusCheck = $x("(//div[contains(@class, 'status ')]" +
            "//span[not(contains(@class,'d-flex'))])[last()]");
    private final SelenideElement resumeNameCheck = $x("(//div[@data-name]//h2//a)[last()]");
    private final SelenideElement deleteResumeModal = $x("(//button[@class='dropdown-item']//span/..)[last()]");
    private final SelenideElement confirmDeleteResume = $x("(//div[@class='modal__content'])[last()]" +
            "//div[3]//*[text()='Удалить']");

    /**
     === hashmap проверки резюме ===
     */
    public Map<String, Object> actualAttributes() {
        return new HashMap<String, Object>() {{
            put(HashMaps.infoBlockError, infoBlockHealth.errorInfoBlock());
            put(HashMaps.myResumeTitle, myResumeCheck());
            put(HashMaps.resumeName, resumeNameCheck());
            put(HashMaps.progressBar, progressBarCheck());
            put(HashMaps.resumeModStatusCheck, moderationStatusCheck());
        }};
    }

    /**
     === Метод получения тектса заголовка ===
     */
    @Step(value = "Получение заголовка страницы")
    private String myResumeCheck(){
        return myResumeTitleCheck.getText();
    }

    /**
     === Получение названия резюме ===
     */
    @Step(value = "Получение наименования резюме")
    private String resumeNameCheck() {
        return resumeNameCheck.getText().trim();
    }

    /**
     === Проверка заполнения резюме ===
     */
    @Step(value = "Получение заполнености резюме")
    private String progressBarCheck() {
        return progressBarCheck.getAttribute("value");
    }

    /**
     === Получение статуса модерации резюме ===
     */
    @Step(value = "Получение статуса модерации резюме")
    private String moderationStatusCheck() {
        return resumeModStatusCheck.getText();
    }

    /**
     === Метод удаления резюме ===
     * @param milliseconds - таймер ожидания перед кликом на элемент(для стабильности теста)
     */
    @Step(value = "Процесс удаления резюме")
    public void deleteResume(int milliseconds) {
        meatBalls.serviceMeatBalls(milliseconds);
        deleteResumeModal.should(Condition.enabled).click();
        corePage.sleeper(milliseconds);
        confirmDeleteResume.should(Condition.enabled).click();
    }
}
