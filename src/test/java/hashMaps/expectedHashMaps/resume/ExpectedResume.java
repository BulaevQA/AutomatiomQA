package hashMaps.expectedHashMaps.resume;

import java.util.HashMap;
import java.util.Map;

import static core.classObjects.ClassObjects.hashKeys;
import static core.classObjects.ClassObjects.testValues;

public class ExpectedResume {

    /*
    === Hashmaps с ожидаемыми результатами отмодерированного резюме ===
    */
    public Map<String, Object> expectedResume() {
        return new HashMap<String, Object>() {{
            put(hashKeys.pageHeader, testValues.position);
            put(hashKeys.myName, testValues.myName);
            put(hashKeys.birthdayDate, testValues.birthdayDate);
            put(hashKeys.gender, testValues.gender);
            put(hashKeys.resumeName, testValues.position);
            put(hashKeys.workSphere, testValues.workSphere);
            put(hashKeys.salary, testValues.salary);
            put(hashKeys.nationality, testValues.nationality);
            put(hashKeys.region, testValues.regionCv);
            put(hashKeys.email, testValues.email);
            put(hashKeys.schedule, testValues.schedule);
            put(hashKeys.employmentType, testValues.employmentType);
            put(hashKeys.married, testValues.married);
            put(hashKeys.children, testValues.children);
            put(hashKeys.house, testValues.house);
            put(hashKeys.unprotectedSocialGroup, testValues.unprotectedSocialGroup);
            put(hashKeys.progressBar, testValues.minProgressBar);
            put(hashKeys.creationDate, testValues.currentDate);
        }};
    }
}
