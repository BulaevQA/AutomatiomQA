package hashMaps.actualHashMaps.vacancy;

import java.util.HashMap;
import java.util.Map;

import static core.classObjects.ClassObjects.hashKeys;
import static core.classObjects.ClassObjects.vacancyPage;

public class ActualVacancy {

    /*
    === HashMap с актуальными значениями вакансии ===
     */
    public Map<String, Object> actualValueVacancy() {
        return new HashMap<String, Object>() {{
            put(hashKeys.companyName, vacancyPage.getCompany());
            put(hashKeys.vacancyName, vacancyPage.getVacancyName());
            put(hashKeys.salary, vacancyPage.getSalary());
            put(hashKeys.jobResponsibilities, vacancyPage.getJobResponsibilities());
            put(hashKeys.jobRequirements, vacancyPage.getJobRequirements());
            put(hashKeys.contactPerson, vacancyPage.getContactPerson());
            put(hashKeys.creationDate, vacancyPage.getVacancyDate());
        }};
    }
}
