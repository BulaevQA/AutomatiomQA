package hashMaps.actualHashMaps.auth;

import java.util.HashMap;
import java.util.Map;

import static core.classObjects.ClassObjects.hashKeys;
import static core.classObjects.ClassObjects.mainPage;

public class ActualAuth {

    /**
    === HashMap с актуальными значениями главной страницы соискателя ===
    */
    public Map<String, Object> actualValueCv() {
        return new HashMap<String, Object>() {{
            put(hashKeys.pageHeader, mainPage.pageTitle());
            put(hashKeys.myName, mainPage.myNameCheck());
        }};
    }

    /*
    === HashMap с актуальными значениями главной страницы работодателя ===
    */
    public Map<String, Object> actualValueManager() {
        return new HashMap<String, Object>() {{
            put(hashKeys.pageHeader, mainPage.pageTitle());
            put(hashKeys.companyName, mainPage.myCompanyCheck());
        }};
    }

}
