package helpers.hashMaps;

import java.util.HashMap;
import java.util.Map;

import static helpers.hashMaps.ExpectedHashMaps.*;
import static helpers.other.ClassObjects.*;

public class ActualHashMaps {

    /*
    === HashMap с актуальными значениями резюме ===
     */
    public Map<String, Object> actualValueResume() {
        return new HashMap<String, Object>() {{
            put(infoBlockError, infoBlockHealth.errorInfoBlock());
            put(myResumeTitle, myResumePage.myResumeCheck());
            put(resumeName, myResumePage.resumeNameCheck());
            put(progressBar, myResumePage.progressBarCheck());
            put(resumeModStatusCheck, myResumePage.moderationStatusCheck());
        }};
    }

    /*
    === HashMap с актуальными значениями вакансии ===
     */
    public Map<String, Object> actualValueVacancy() {
        return new HashMap<String, Object>() {{
            put(infoBlockError, infoBlockHealth.errorInfoBlock());
            put(myVacancyTitle, myVacancyPage.myVacancyTitle());
            put(vacancyName, myVacancyPage.vacancyName());
            put(vacancyModStatusCheck, myVacancyPage.moderationStatus());
        }};
    }
    /*
    === HashMap с актуальными значениями главной страницы соискателя ===
    */
    public Map<String, Object> actualValueCv() {
        return new HashMap<String, Object>() {{
            put(infoBlockError, infoBlockHealth.errorInfoBlock());
            put(myCabinetTitle, getTitle.getTitle());
            put(myName, mainPage.myNameCheck());
        }};
    }
    /*
    === HashMap с актуальными значениями главной страницы работодателя ===
    */
    public Map<String, Object> actualValueManager() {
        return new HashMap<String, Object>() {{
            put(infoBlockError, infoBlockHealth.errorInfoBlock());
            put(myCabinetTitle, getTitle.getTitle());
            put(companyName, mainPage.myCompanyCheck());
        }};
    }

    /**
     === HashMap с актуальными значениями мега-меню ===
     */
    public Map<String, Object> actualMegaMenu() {
        return new HashMap<String, Object>() {{
            put(infoBlockError, infoBlockHealth.errorInfoBlock());
            put(mobilityProgram, getTitle.getTitle());
        }};
    }
}
