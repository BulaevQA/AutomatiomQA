package hashMaps.actualHashMaps.vacancy;

import java.util.HashMap;
import java.util.Map;

import static core.classObjects.ClassObjects.*;
import static core.classObjects.ClassObjects.testValues;

public class ActualVacancy {

    /*
    === HashMap с актуальными значениями вакансии ===
     */
    public Map<String, Object> actualValueVacancy() {
        return new HashMap<String, Object>() {{
            put(hashKeys.pageHeader, vacancyPage.getHeader());
            put(hashKeys.companyName, vacancyPage.getCompany());
            put(hashKeys.vacancyName, vacancyPage.getVacancyName());
            put(hashKeys.profession, vacancyPage.getProfession());
            put(hashKeys.salary, vacancyPage.getSalary());
            put(hashKeys.region, vacancyPage.getRegion());
            put(hashKeys.address, vacancyPage.getAddress());
            put(hashKeys.jobResponsibilities, vacancyPage.getJobResponsibilities());
            put(hashKeys.jobRequirements, vacancyPage.getJobRequirements());
            put(hashKeys.schedule, vacancyPage.getSchedule());
            put(hashKeys.employmentType, vacancyPage.getEmploymentType());
            put(hashKeys.amountWorkPlaces, vacancyPage.getAmountWorkPlaces());
            put(hashKeys.unprotectedSocialGroup, vacancyPage.getUnprotectedSocialGroup());
            put(hashKeys.contactPerson, vacancyPage.getContactPerson());
            put(hashKeys.creationDate, vacancyPage.getVacancyDate());
        }};
    }
}
