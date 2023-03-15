package training;

import com.codeborne.selenide.Selenide;
import helpers.ElementCollectionsHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class TrainingClass extends TrainingConfig {

    private String url = "https://rtportal.show.pbs.bftcom.com/vacancy/card/308663325300062/75ed5b77-a06a-11ec-8816-954f4083594a";

    @Test
    public void trainingTest() {
        new VacancyPage().openBrowser(url);
        Map<String, Object> expectedAttributes = new HashMap<>();
        expectedAttributes.put(VacancyPage.VACANCY_NAME, "Электрик");
        expectedAttributes.put(VacancyPage.SALARY, "«з/п по договоренности»");
        expectedAttributes.put(VacancyPage.COMPANY_LINK, "https://rtportal.show.pbs.bftcom.com/company/308663325300062");
        expectedAttributes.put(VacancyPage.CONFIRMED_VACANCY, true);

        Map<String, Object> actualAttributes = new VacancyPage().getAttributes();

        Assertions.assertEquals(expectedAttributes, actualAttributes);
    }

//    @Test
//    public void javaTest() {
//        Selenide.open("https://ru.wikipedia.org/wiki/Java");
//        new ElementCollectionsHelper().randomElementCollectionClick("//div[@id='toc']//a[@href]");
//    }
}
