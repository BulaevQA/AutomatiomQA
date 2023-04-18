package hashMaps.expectedHashMaps.auth;

import test.testValues.TestValues;

import java.util.HashMap;
import java.util.Map;

import static core.classObjects.ClassObjects.hashKeys;

public class ExpectedAuth extends TestValues {

    /**
     === Hashmaps с ожидаемыми результатами главной соискателя ===
     */
    public Map<String, Object> expectedCvAuth() {
        return new HashMap<String, Object>() {{
            put(hashKeys.pageHeader, true);
            put(hashKeys.myName, myName);
        }};
    }

    /*
    === Hashmaps с ожидаемыми результатами главной соискателя работодателя ===
    */
    public Map<String, Object> expectedManagerAuth() {
        return new HashMap<String, Object>() {{
            put(hashKeys.pageHeader, true);
            put(hashKeys.companyName, companyName);
        }};
    }
}
