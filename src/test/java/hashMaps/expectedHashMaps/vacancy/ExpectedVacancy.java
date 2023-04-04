package hashMaps.expectedHashMaps.vacancy;

import java.util.HashMap;
import java.util.Map;

import static core.classObjects.ClassObjects.hashKeys;
import static core.classObjects.ClassObjects.testValues;

public class ExpectedVacancy {

    /*
    === Hashmaps с ожидаемыми результатами отмодерированной вакансии ===
    */
    public Map<String, Object> expectedVacancy() {
        return new HashMap<String, Object>() {{
            put(hashKeys.pageHeader, testValues.position);
            put(hashKeys.companyName, testValues.companyName);
            put(hashKeys.vacancyName, testValues.position);
            put(hashKeys.profession, testValues.profession);
            put(hashKeys.salary, testValues.salaryManager);
            put(hashKeys.region, testValues.regionManager);
            put(hashKeys.address, testValues.address);
            put(hashKeys.jobResponsibilities, testValues.jobFields);
            put(hashKeys.jobRequirements, testValues.jobFields);
            put(hashKeys.schedule, testValues.schedule);
            put(hashKeys.employmentType, testValues.employmentType);
            put(hashKeys.amountWorkPlaces, testValues.amountWorkPlaces);
            put(hashKeys.unprotectedSocialGroup, testValues.unprotectedSocialGroup);
            put(hashKeys.contactPerson, testValues.myName);
            put(hashKeys.creationDate, testValues.currentDate);
        }};
    }
}
