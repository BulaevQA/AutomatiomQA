package pages.trudvsemPages.vacancyPage;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;
import static core.classObjects.ClassObjects.testValues;

public class VacancyPage {

    private final SelenideElement
            pageHeader = $x("//h1[@class]"),
            companyName = $x("//h2[text()='Основная информация']/following-sibling::div//h3"),
            vacancyName = $x("//*[text()[normalize-space() = 'Название вакансии:']]/..//a"),
            profession = $x("//*[text()[normalize-space() = 'Профессия:']]/following-sibling::dd"),
            salary = $x("//*[text()[normalize-space() = 'Заработная плата:']]/following-sibling::dd"),
            region = $x("//*[text()[normalize-space() = 'Регион:']]/following-sibling::dd"),
            address = $x("//*[text()[normalize-space() = 'Адрес места работы:']]/following-sibling::dd"),
            jobResponsibilities = $x("//h2[text()='Должностные обязанности']/following-sibling::p"),
            jobRequirements = $x("//h2[text()='Требования к кандидату']/following-sibling::p"),
            schedule = $x("//*[text()[normalize-space() = 'График работы:']]/following-sibling::dd"),
            employmentType = $x("//*[text()[normalize-space() = 'Тип занятости:']]/following-sibling::dd"),
            amountWorkPlaces = $x("//*[text()[normalize-space() = 'Количество рабочих мест:']]/following-sibling::dd"),
            unprotectedSocialGroup = $x("//*[text()[normalize-space() = 'Возможность работы для социально " +
                    "незащищённых групп:']]/following-sibling::dd"),
            contactPerson = $x("//*[text()[normalize-space() = 'Контактное лицо:']]/following-sibling::dd"),
            vacancyDate = $x("//time[@data-content='published-date']");

    /**
     === Получение заголовка страницы ===
     */
    @Step(value = "Получение заголовка страницы")
    public String getHeader() {
        return pageHeader.should(exist, visible).getText().trim();
    }

    /**
     === Получение наименования компании ===
     */
    @Step(value = "Получение наименования компании")
    public String getCompany() {
        return companyName.should(exist, visible).getText().trim().equals("Индивидуальный предприниматель "
                + testValues.myName) ? testValues.companyName : "Наименование компании не соответствует ожидаемому";
    }

    /**
     === Получение наименования вакансии ===
     */
    @Step(value = "Получение наименования вакансии")
    public String getVacancyName() {
        return vacancyName.should(exist, visible).getText().trim();
    }

    /**
     === Получение профессии компании ===
     */
    @Step(value = "Получение профессии компании")
    public String getProfession() {
        return profession.should(exist, visible).getText().trim();
    }

    /**
     === Получение заработной платы вакансии ===
     */
    @Step(value = "Получение заработной платы")
    public String getSalary() {
        return salary.should(exist, visible).getText().trim();
    }

    /**
     === Получение региона вакансии ===
     */
    @Step(value = "Получение региона")
    public String getRegion() {
        return region.should(exist, visible).getText().trim();
    }

    /**
     === Получение адреса вакансии ===
     */
    @Step(value = "Получение адреса")
    public String getAddress() {
        return address.should(exist, visible).getText().trim();
    }

    /**
     === Получение заработнйо платы вакансии ===
     */
    @Step(value = "Получение обязанностей вакансии")
    public String getJobResponsibilities() {
        return jobResponsibilities.should(exist, visible).getText().trim();
    }

    /**
     === Получение требований вакансии ===
     */
    @Step(value = "Получение требований вакансии")
    public String getJobRequirements() {
        return jobRequirements.should(exist, visible).getText().trim();
    }

    /**
     === Получение графика работы вакансии ===
     */
    @Step(value = "Получение графика работы")
    public String getSchedule() {
        return schedule.should(exist, visible).getText().trim();
    }

    /**
     === Получение типа занятости вакансии ===
     */
    @Step(value = "Получение типа занятости")
    public String getEmploymentType() {
        return employmentType.should(exist, visible).getText().trim();
    }

    /**
     === Получение количества рабочих мест вакансии ===
     */
    @Step(value = "Получение количества рабочих мест")
    public String getAmountWorkPlaces() {
        return amountWorkPlaces.should(exist, visible).getText().trim();
    }

    /**
     === Получение возможности работы для социально незащищённых групп вакансии ===
     */
    @Step(value = "Получение возможности работы для социально незащищённых групп")
    public String getUnprotectedSocialGroup() {
        return unprotectedSocialGroup.should(exist, visible).getText().trim();
    }

    /**
     === Получение контактного лица компании ===
     */
    @Step(value = "Получение контактного лица вакансии")
    public String getContactPerson() {
        return contactPerson.should(exist, visible).getText().trim();
    }

    /**
     === Получение даты создания вакансии ===
     */
    @Step(value = "Получение даты создания вакансии")
    public String getVacancyDate() {
        return vacancyDate.should(exist, visible).getAttribute("datetime");
    }
}
