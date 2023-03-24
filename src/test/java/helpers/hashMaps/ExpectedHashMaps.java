package helpers.hashMaps;

import java.util.HashMap;
import java.util.Map;

public class ExpectedHashMaps {

    //Общие ключи
    public static String
            infoBlockError = "Информация временно недоступна",
            myCabinetTitle = "Мой кабинет",

    //Ключи соискателя
            progressBar = "Шкала заполнения",
            myResumeTitle = "Мои резюме",
            resumeName = "Наименование резюме",
            resumeModStatusCheck = "Статус модерации",
            myName = "Мое имя",

    //Ключи работодателя
            myVacancyTitle = "Вакансии компании",
            vacancyName = "Наименование вакансии",
            vacancyModStatusCheck = "Статус модерации",
            companyName = "Наименование компании",

    //Ключи мега-меню
            mobilityProgram = "Программа переезда";

    /*
     === Hashmaps с ожидаемыми результатами главной соискателя ===
     */
    public Map<String, Object> expectedMainCv() {
        return new HashMap<String, Object>() {{
            put(infoBlockError, false);
            put(myCabinetTitle, "Мой кабинет");
            put(myName, "Булаев Денис Сергеевич");
        }};
    }

    /*
    === Hashmaps с ожидаемыми результатами отмодерированного резюме ===
    */
    public Map<String, Object> expectedResume() {
        return new HashMap<String, Object>() {{
            put(infoBlockError, false);
            put(myResumeTitle, "Мои резюме");
            put(resumeName, "Автотест");
            put(progressBar, "47");
            put(resumeModStatusCheck, "Одобрено");
        }};
    }

    /*
    === Hashmaps с ожидаемыми результатами главной соискателя работодателя ===
    */
    public Map<String, Object> expectedMainManager() {
        return new HashMap<String, Object>() {{
            put(infoBlockError, false);
            put(myCabinetTitle, "Мой кабинет");
            put(companyName, "ИП Булаев Д. С.");
        }};
    }

    /*
    === Hashmaps с ожидаемыми результатами отмодерированной вакансии ===
    */
    public Map<String, Object> expectedVacancy() {
        return new HashMap<String, Object>() {{
            put(infoBlockError, false);
            put(myVacancyTitle, "Вакансии компании");
            put(vacancyName, "Автотест");
            put(vacancyModStatusCheck, "Одобрена");
        }};
    }

     /**
     === HashMap с ожидаемыми значениями мега-меню ===
     */
    public Map<String, Object> expectedMegaMenu() {
        return new HashMap<String, Object>() {{
            put(infoBlockError, false);
            put(mobilityProgram, "Программа повышения трудовой мобильности");
        }};
    }
}
