package test.testValues;

import com.github.javafaker.Faker;
import org.openqa.selenium.WindowType;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TestValues {

    // Генерация данных
    private final String positionGenerator = Faker.instance().bothify("Автотест####");

    public final String

            // Креды ПРР
            url = System.getProperty("base_url", "https://web-hotfix-test01.k8s.trudvsem.ru/"),
            login = System.getProperty("login", "abilimpiks@pbs.bftcom.com"),
            password = System.getProperty("password", "Ex3t8yh96mj!"),

            // Креды АДМ легаси
            urlAdm = System.getProperty("base_urlAdm", "http://admin.apps.test01.stable.trudvsem.ru/"),
            loginAdm = System.getProperty("loginAdm", "admin@trudvsem.ru"),
            passwordAdm = System.getProperty("passwordAdm", "Qwerty123"),

            // Общие
            myName = "Булаев Денис Сергеевич",
            position = positionGenerator,
            workSphere = "Домашний персонал",
            salary = "30000",
            profession = "Учитель",
            currentDate = ZonedDateTime.now(ZoneId.of("Europe/Moscow"))
                    .format(DateTimeFormatter.ofPattern("dd.MM.yyy")),
            unprotectedSocialGroup = "не указано",

            // Соискатель
            minProgressBar = "47",
            regionCv = "г. Санкт-Петербург",
            email = "abilimpiks@pbs.bftcom.com",
            birthdayDate = "01.01.1977",
            gender = "Мужчщина",
            nationality = "Российская Федерация",
            married = "не указано",
            children = "не указано",
            house = "не указано",

            // Работодатель
            companyName = "ИП Булаев Д. С.",
            salaryManager = "«з/п по договоренности»",
            regionManager = "г. Санкт-Петербург",
            address = "г. Санкт-Петербург, 44",
            schedule = "Полный рабочий день",
            employmentType = "Полная занятость",
            amountWorkPlaces = "1",
            jobFields = "Тестовое значение",
            ogrn = "321774600790221";

    // Переключение между вкладками / окнами браузера
    public final WindowType
            newTab = WindowType.TAB,
            newWindow = WindowType.WINDOW;

    // Мега-меню
    public List<String> megaMenuList() {
        return new ArrayList<String>() {{
            add("Работа с переездом по России");
            add("Работа без границ");
            add("Аналитическая информация");
            add("Рейтинг регионов");
            add("Справочник востребованных профессий");
            add("Профессиональная ориентация");
            add("Опросы для соискателя");
            add("Опросы для работодателя");
            add("Найм граждан Узбекистана");
            add("Найм граждан Таджикистана");
            add("О стажировках и практиках");
            add("О портале");
            add("Помощь и поддержка");
            add("Государственные службы занятости");
            add("Трудоустройство студентов");
            add("Частные агентства занятости");
            add("Worldskills");
            add("Abilympics");
            add("Трудоустройство инвалидов");
            add("Меры безопасности");
            add("О Работе без границ");
            add("Открытые данные");
            add("Мероприятия");
            add("API");
            add("Наборы данных");
            add("Виджеты");
            add("О мобильном приложении");
            add("Скачать на iPhone");
            add("Скачать на Android");
            add("Новое на портале");
            add("Новости");
            add("Статьи");
            add("2021 год");
            add("2022 год");
            add("2023 год");
            add("Образовательные программы");
            add("Информационные страницы");
            add("Социальная сеть Skillsnet");
        }};
    }
}
