package pages.trudvsem.resume;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class ResumePage {

    private final SelenideElement
            myName = $x("//p[@class='photo__name']//span"),
            progressBarCheck = $x("(//progress)[last()]"),
            position = $x("//strong[text()='Желаемая должность:']/../following-sibling::div//span"),
            workSphere = $x("//strong[text()='Сфера деятельности:']/../following-sibling::div//span"),
            salary = $x("//strong[text()='Заработная плата:']/../following-sibling::div//span"),
            resumeDate = $x("//time[@data-content='published-date']");

    /**
     === Получение имени соискателя из карточки резюме ===
     */
    @Step(value = "Получение имени соискателя")
    public String getName() {
        return myName.should(exist, visible).getText().trim();
    }

    /**
     === Получение шкалы заполнености из карточки резюме ===
     */
    @Step(value = "Получение заполнености резюме")
    public String progressBar() {
        return progressBarCheck.should(exist, visible).getAttribute("value");
    }

    /**
     === Получение желаемой должности из карточки резюме ===
     */
    @Step(value = "Получение желаемой должности")
    public String getPosition() {
        return position.should(exist, visible).getText().trim();
    }

    /**
     === Получение сферы деятельности из карточки резюме ===
     */
    @Step(value = "Получение сферы деятельности")
    public String getWorkSphere() {
        return workSphere.should(exist, visible).getText().trim();
    }

    /**
     === Получение зарплаты из карточки резюме ===
     */
    @Step(value = "Получение зарплаты")
    public String getSalary() {
        return salary.should(exist, visible).getText().trim().replaceAll("\\D+", "");
    }

    /**
     === Получение даты создания из карточки резюме ===
     */
    @Step(value = "Получение даты создания резюме")
    public String getResumeDate() {
        return resumeDate.should(exist, visible).getAttribute("datetime");
    }

}
