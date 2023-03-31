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
            put(hashKeys.myName, testValues.myName);
            put(hashKeys.resumeName, testValues.position);
            put(hashKeys.workSphere, testValues.workSphere);
            put(hashKeys.salary, testValues.salary);
            put(hashKeys.progressBar, testValues.minProgressBar);
            put(hashKeys.creationDate, testValues.currentDate);
        }};
    }
}
