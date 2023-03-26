package helpers.hashMaps;

import java.util.HashMap;
import java.util.Map;

import static helpers.other.ClassObjects.testValues;

public class ExpectedHashMaps {

    public static String
            //Общие ключи
            pageHeader = "H1 заголовок",
            workSphere = "Сфера деятельности",
            salary = "Заработая плата",
            creationDate = "Дата создания",
            //Ключи соискателя
            progressBar = "Шкала заполнения",
            resumeName = "Наименование резюме",
            myName = "Мое имя",
            //Ключи работодателя
            vacancyName = "Наименование вакансии",
            companyName = "Наименование компании",
            jobResponsibilities = "Обязанности",
            jobRequirements = "Требования",
            contactPerson = "Контактное лицо",
            //Ключи мега-меню
            mobilityProgram = "Программа переезда";

    /*
     === Hashmaps с ожидаемыми результатами главной соискателя ===
     */
    public Map<String, Object> expectedCvAuth() {
        return new HashMap<String, Object>() {{
            put(pageHeader, true);
            put(myName, testValues.myName);
        }};
    }

    /*
    === Hashmaps с ожидаемыми результатами отмодерированного резюме ===
    */
    public Map<String, Object> expectedResume() {
        return new HashMap<String, Object>() {{
            put(pageHeader, true);
            put(myName, testValues.myName);
            put(resumeName, testValues.position);
            put(workSphere, testValues.workSphere);
            put(salary, testValues.salary);
            put(progressBar, testValues.minProgressBar);
            put(creationDate, testValues.currentDate);
        }};
    }

    /*
    === Hashmaps с ожидаемыми результатами главной соискателя работодателя ===
    */
    public Map<String, Object> expectedMainManager() {
        return new HashMap<String, Object>() {{
            put(pageHeader, true);
            put(companyName, testValues.companyName);
        }};
    }

    /*
    === Hashmaps с ожидаемыми результатами отмодерированной вакансии ===
    */
    public Map<String, Object> expectedVacancy() {
        return new HashMap<String, Object>() {{
            put(pageHeader, true);
            put(companyName, testValues.companyName);
            put(vacancyName, testValues.position);
            put(salary, testValues.salaryManager);
            put(jobResponsibilities, testValues.jobFields);
            put(jobRequirements, testValues.jobFields);
            put(contactPerson, testValues.myName);
            put(creationDate, testValues.currentDate);
        }};
    }

     /**
     === HashMap с ожидаемыми значениями мега-меню ===
     */
    public Map<String, Object> expectedMegaMenu() {
        return new HashMap<String, Object>() {{
            put(mobilityProgram, "Программа повышения трудовой мобильности");
        }};
    }
}
