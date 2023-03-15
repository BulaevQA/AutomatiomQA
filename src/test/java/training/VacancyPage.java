package training;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$x;

public class VacancyPage {

    private final SelenideElement getVacancyName = $x("//h1[@class]");
    private final SelenideElement getSalary = $x("//div[@class='vacancy-sidebar__price']");
    private final SelenideElement getCompanyLink = $x("//a[contains(@href, '/company')]");
    private final SelenideElement confirmedVacancy = $x("//*[text()='Данные вакансии проверены работодателем']");

    public static String VACANCY_NAME = "Наименвоание вакансии";
    public static String SALARY = "Заработная плата";
    public static String COMPANY_LINK = "Ссылка на вакансию";
    public static String CONFIRMED_VACANCY = "Вакансий подтверждена работодателем";

    public Map<String, Object> getAttributes() {
        return new HashMap<String, Object>() {{
            put(VACANCY_NAME, vacancyName());
            put(SALARY, vacancySalary());
            put(COMPANY_LINK, companyLink());
            put(CONFIRMED_VACANCY, isConfirmedVacancy());
        }};
    }

    public VacancyPage openBrowser(String url) {
        Selenide.open(url);
        return this;
    }

    public String vacancyName() {
       return getVacancyName.getText();
    }

    public String vacancySalary() {
        return getSalary.getText();
    }

    public String companyLink() {
        return getCompanyLink.getAttribute("href");
    }

    public boolean isConfirmedVacancy() {
       return confirmedVacancy.isDisplayed();
    }
}
