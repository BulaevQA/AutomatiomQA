package helpers.hashMaps;

import java.util.HashMap;
import java.util.Map;

import static helpers.hashMaps.ExpectedHashMaps.*;
import static helpers.other.ClassObjects.*;

public class ActualHashMaps {

    /*
    === HashMap с актуальными значениями резюме ===
     */
    public Map<String, Object> actualValueResume() {
        return new HashMap<String, Object>() {{
            put(pageHeader, getPageTitle.pageTitleIsVisible(testValues.position));
            put(myName, resumePage.getName());
            put(resumeName, resumePage.getPosition());
            put(workSphere, resumePage.getWorkSphere());
            put(salary, resumePage.getSalary());
            put(progressBar, resumePage.progressBar());
            put(creationDate, resumePage.getResumeDate());
        }};
    }

    /*
    === HashMap с актуальными значениями вакансии ===
     */
    public Map<String, Object> actualValueVacancy() {
        return new HashMap<String, Object>() {{
            put(pageHeader, getPageTitle.pageTitleIsVisible(testValues.position));
            put(companyName, vacancyPage.getCompany());
            put(vacancyName, vacancyPage.getVacancyName());
            put(salary, vacancyPage.getSalary());
            put(jobResponsibilities, vacancyPage.getJobResponsibilities());
            put(jobRequirements, vacancyPage.getJobRequirements());
            put(contactPerson, vacancyPage.getContactPerson());
            put(creationDate, vacancyPage.getVacancyDate());
        }};
    }
    /*
    === HashMap с актуальными значениями главной страницы соискателя ===
    */
    public Map<String, Object> actualValueCv() {
        return new HashMap<String, Object>() {{
            put(pageHeader, getPageTitle.pageTitleIsVisible("Мой кабинет"));
            put(myName, mainPage.myNameCheck());
        }};
    }
    /*
    === HashMap с актуальными значениями главной страницы работодателя ===
    */
    public Map<String, Object> actualValueManager() {
        return new HashMap<String, Object>() {{
            put(pageHeader, getPageTitle.pageTitleIsVisible("Мой кабинет"));
            put(companyName, mainPage.myCompanyCheck());
        }};
    }

    /**
     === HashMap с актуальными значениями мега-меню ===
     */
    public Map<String, Object> actualMegaMenu() {
        return new HashMap<String, Object>() {{
            put(mobilityProgram, "");
        }};
    }
}
