package helpers;

import java.util.HashMap;
import java.util.Map;

public class HashMaps {

    //Общие ключи
    public static String infoBlockError = "Информация временно недоступна";
    public static String myCabinetTitle = "Мой кабинет";

    //Ключи соискателя
    public static String progressBar = "Шкала заполнения";
    public static String myResumeTitle = "Мои резюме";
    public static String resumeName = "Наименование резюме";
    public static String resumeModStatusCheck = "Статус модерации";
    public static String myName = "Мое имя";

    //Ключи работодателя
    public static String myVacancyTitle = "Вакансии компании";
    public static String vacancyName = "Наименование вакансии";
    public static String vacancyModStatusCheck = "Статус модерации";
    public static String companyName = "Наименование компании";

    /**
     === Hashmaps с ожидаемыми результатами для сравнения с актуальными ===
     */
    public Map<String, Object> expectedMainCv() {
        return new HashMap<String, Object>() {{
            put(infoBlockError, false);
            put(myCabinetTitle, "Мой кабинет");
            put(myName, "Булаев Денис Сергеевич");
        }};
    }

    public Map<String, Object> expectedMinResumeModerated() {
        return new HashMap<String, Object>() {{
            put(infoBlockError, false);
            put(myResumeTitle, "Мои резюме");
            put(resumeName, "Автотест");
            put(progressBar, "47");
            put(resumeModStatusCheck, "Одобрено");
        }};
    }

    public Map<String, Object> expectedMainManager() {
        return new HashMap<String, Object>() {{
            put(infoBlockError, false);
            put(myCabinetTitle, "Мой кабинет");
            put(companyName, "ИП Булаев Д. С.");
        }};
    }

    public Map<String, Object> expectedVacancyModerated() {
        return new HashMap<String, Object>() {{
            put(infoBlockError, false);
            put(myVacancyTitle, "Вакансии компании");
            put(vacancyName, "Автотест");
            put(vacancyModStatusCheck, "Одобрена");
        }};
    }
}
