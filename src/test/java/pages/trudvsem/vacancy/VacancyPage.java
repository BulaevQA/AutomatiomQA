package pages.trudvsem.vacancy;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;
import static helpers.other.ClassObjects.testValues;

public class VacancyPage {

    private final SelenideElement
            companyName = $x("//h2[text()='Основная информация']/following-sibling::div//h3"),
            vacancyName = $x("//*[text()[normalize-space() = 'Название вакансии:']]/..//a"),
            profession = $x("//*[text()[normalize-space() = 'Профессия:']]/following-sibling::dd"),
            salary = $x("//*[text()[normalize-space() = 'Заработная плата:']]/following-sibling::dd"),
            jobResponsibilities = $x("//h2[text()='Должностные обязанности']/following-sibling::p"),
            jobRequirements = $x("//h2[text()='Требования к кандидату']/following-sibling::p"),
            contactPerson = $x("//*[text()[normalize-space() = 'Контактное лицо:']]/following-sibling::dd"),
            vacancyDate = $x("//time[@data-content='published-date']");

    public String getCompany() {
        return companyName.should(exist, visible).getText().trim().equals("Индивидуальный предприниматель "
                + testValues.myName) ? testValues.companyName : "Наименование компании не соответсвует ожидаемому";
    }

    public String getVacancyName() {
        return vacancyName.should(exist, visible).getText().trim();
    }

    public String getProfession() {
        return profession.should(exist, visible).getText().trim();
    }

    public String getSalary() {
        return salary.should(exist, visible).getText().trim();
    }

    public String getJobResponsibilities() {
        return jobResponsibilities.should(exist, visible).getText().trim();
    }

    public String getJobRequirements() {
        return jobRequirements.should(exist, visible).getText().trim();
    }

    public String getContactPerson() {
        return contactPerson.should(exist, visible).getText().trim();
    }

    /**
     === Получение даты создания из карточки вакансии ===
     */
    @Step(value = "Получение даты создания вакансии")
    public String getVacancyDate() {
        return vacancyDate.should(exist, visible).getAttribute("datetime");
    }
}
