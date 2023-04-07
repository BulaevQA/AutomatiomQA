package hashMaps.actualHashMaps.resume;

import java.util.HashMap;
import java.util.Map;

import static core.classObjects.ClassObjects.*;

public class ActualResume {

    /*
    === HashMap с актуальными значениями резюме ===
     */
    public Map<String, Object> actualValueResume() {
        return new HashMap<String, Object>() {{
            put(hashKeys.pageHeader, resumePage.getHeader());
            put(hashKeys.myName, resumePage.getName());
            put(hashKeys.birthdayDate, resumePage.getBirthday());
            put(hashKeys.gender, resumePage.getGender());
            put(hashKeys.resumeName, resumePage.getPosition());
            put(hashKeys.workSphere, resumePage.getWorkSphere());
            put(hashKeys.salary, resumePage.getSalary());
            put(hashKeys.nationality, resumePage.getNationality());
            put(hashKeys.region, resumePage.getRegion());
            put(hashKeys.email, resumePage.getEmail());
            put(hashKeys.schedule, resumePage.getSchedule());
            put(hashKeys.employmentType, resumePage.getEmploymentType());
            put(hashKeys.married, resumePage.getMarried());
            put(hashKeys.children, resumePage.getChildren());
            put(hashKeys.house, resumePage.getHouse());
            put(hashKeys.unprotectedSocialGroup, resumePage.getUnprotectedSocialGroup());
            put(hashKeys.progressBar, resumePage.progressBar());
            put(hashKeys.creationDate, resumePage.getResumeDate());
        }};
    }
}
