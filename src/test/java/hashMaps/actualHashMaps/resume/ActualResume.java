package hashMaps.actualHashMaps.resume;

import java.util.HashMap;
import java.util.Map;

import static core.classObjects.ClassObjects.hashKeys;
import static core.classObjects.ClassObjects.resumePage;

public class ActualResume {

    /*
    === HashMap с актуальными значениями резюме ===
     */
    public Map<String, Object> actualValueResume() {
        return new HashMap<String, Object>() {{
            put(hashKeys.myName, resumePage.getName());
            put(hashKeys.resumeName, resumePage.getPosition());
            put(hashKeys.workSphere, resumePage.getWorkSphere());
            put(hashKeys.salary, resumePage.getSalary());
            put(hashKeys.progressBar, resumePage.progressBar());
            put(hashKeys.creationDate, resumePage.getResumeDate());
        }};
    }
}
