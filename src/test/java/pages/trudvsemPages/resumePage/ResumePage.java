package pages.trudvsemPages.resumePage;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class ResumePage {

    private final SelenideElement
            pageHeader = $x("//h1[@class]"),
            myName = $x("//p[@class='photo__name']//span"),
            birthday = $x("//time[@class='date-preview']"),
            gender = $x("(//dt[@class='photo__birth-text'])[last()]"),
            nationality = $x("//strong[text()='Гражданство:']/../following-sibling::div//span"),
            region = $x("//strong[text()='Регион:']/../following-sibling::div//span"),
            email = $x("//strong[text()='E-mail:']/../following-sibling::div//span"),
            schedule = $x("//strong[text()='График работы:']/../following-sibling::div"),
            employmentType = $x("//strong[text()='Тип занятости:']/../following-sibling::div"),
            married = $x("//strong[text()='Семейное положение:']/../following-sibling::div//span"),
            children = $x("//strong[text()='Наличие детей:']/../following-sibling::div//span"),
            house = $x("//strong[text()='Наличие жилья:']/../following-sibling::div//span"),
            unprotectedSocialGroup = $x("//strong[text()='Социально-незащищённая группа:']/../following-sibling::div//span"),
            progressBarCheck = $x("(//progress)[last()]"),
            position = $x("//strong[text()='Желаемая должность:']/../following-sibling::div//span"),
            workSphere = $x("//strong[text()='Сфера деятельности:']/../following-sibling::div//span"),
            salary = $x("//strong[text()='Заработная плата:']/../following-sibling::div//span"),
            resumeDate = $x("//time[@data-content='published-date']");

    /**
     === Получение заголовка страницы ===
     */
    @Step(value = "Получение заголовка страницы")
    public String getHeader() {
        return pageHeader.should(exist, visible).getText().trim();
    }

    @Step(value = "Получение имени соискателя")
    public String getName() {
        return myName.should(exist, visible).getText().trim();
    }

    @Step(value = "Получение даты рождения")
    public String getBirthday() {
        return birthday.should(exist, visible).getText().trim();
    }

    @Step(value = "Получение пола соискателя")
    public String getGender() {
        return gender.should(exist, visible).getText().trim();
    }

    @Step(value = "Получение гражданства соискателя")
    public String getNationality() {
       return nationality.should(exist, visible).getText().trim();
    }

    @Step(value = "Получение региона соискателя")
    public String getRegion() {
        return region.should(exist, visible).getText().trim();
    }

    @Step(value = "Получение почты соискателя")
    public String getEmail() {
        return email.should(exist, visible).getText().trim();
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

    @Step(value = "Семейное положение")
    public String getMarried() {
        return married.should(exist, visible).getText().trim();
    }

    @Step(value = "Наличие детей")
    public String getChildren() {
        return children.should(exist, visible).getText().trim();
    }

    @Step(value = "Наличие жилья")
    public String getHouse() {
        return house.should(exist, visible).getText().trim();
    }

    @Step(value = "Получение социально-незащищенной группы")
    public String getUnprotectedSocialGroup() {
        return unprotectedSocialGroup.should(exist, visible).getText().trim();
    }

    @Step(value = "Получение заполнености резюме")
    public String progressBar() {
        return progressBarCheck.should(exist, visible).getAttribute("value");
    }

    @Step(value = "Получение желаемой должности")
    public String getPosition() {
        return position.should(exist, visible).getText().trim();
    }

    @Step(value = "Получение сферы деятельности")
    public String getWorkSphere() {
        return workSphere.should(exist, visible).getText().trim();
    }

    @Step(value = "Получение зарплаты")
    public String getSalary() {
        return salary.should(exist, visible).getText().trim().replaceAll("\\D+", "");
    }

    @Step(value = "Получение даты создания резюме")
    public String getResumeDate() {
        return resumeDate.should(exist, visible).getAttribute("datetime");
    }

}
