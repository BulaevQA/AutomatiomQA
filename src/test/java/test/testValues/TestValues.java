package test.testValues;

import com.github.javafaker.Faker;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TestValues {

            //Генерация данных
    private final String positionGenerator = Faker.instance().bothify("Автотест####");

    public final String

            //Креды ПРР
            url = System.getProperty("base_url", "https://web-stable-test01.k8s.trudvsem.ru/"),
            login = System.getProperty("login", "abilimpiks@pbs.bftcom.com"),
            password = System.getProperty("password", "Ex3t8yh96mj!"),

            //Креды АДМ легаси
            urlAdm = System.getProperty("base_urlAdm", "https://hotfix-rtadm.show.pbs.bftcom.com/"),
            loginAdm = System.getProperty("loginAdm", "admin@trudvsem.ru"),
            passwordAdm = System.getProperty("passwordAdm", "Qwerty123"),

            //Общие
            myName = "Булаев Денис Сергеевич",
            position = positionGenerator,
            workSphere = "Домашний персонал",
            salary = "30000",
            profession = "Учитель",
            currentDate = ZonedDateTime.now(ZoneId.of("Europe/Moscow"))
                    .format(DateTimeFormatter.ofPattern("dd.MM.yyy")),
            unprotectedSocialGroup = "не указано",

            //Соискатель
            minProgressBar = "47",
            regionCv = "Архангельская область",
            email = "abilimpiks@pbs.bftcom.com",
            birthdayDate = "01.01.1977",
            gender = "Мужчщина",
            nationality = "Российская Федерация",
            married = "не указано",
            children = "не указано",
            house = "не указано",

            //Работодатель
            companyName = "ИП Булаев Д. С.",
            salaryManager = "«з/п по договоренности»",
            regionManager = "г. Москва",
            address = "г. Москва, 44",
            schedule = "Полный рабочий день",
            employmentType = "Полная занятость",
            amountWorkPlaces = "1",
            jobFields = "Тестовое значение",
            ogrn = "321774600790221";

            //Мега-меню
    public final String megaMenuArray =
                    "[Работа с переездом по России, " +
                    "Работа без границ, " +
                    "Аналитическая информация, " +
                    "Рейтинг регионов, " +
                    "Справочник востребованных профессий, " +
                    "Профессиональная ориентация, " +
                    "Опросы для соискателя, " +
                    "Опросы для работодателя, " +
                    "Найм граждан Узбекистана, " +
                    "Найм граждан Таджикистана, " +
                    "О стажировках и практиках, " +
                    "О портале, " +
                    "Помощь и поддержка, " +
                    "Государственные службы занятости, " +
                    "Трудоустройство студентов, " +
                    "Опытные кадры, " +
                    "Частные агентства занятости, " +
                    "Abilympics, " +
                    "Worldskills, " +
                    "Трудоустройство инвалидов, " +
                    "Меры безопасности, " +
                    "О Работе без границ, " +
                    "Об Электронном кадровом документообороте, " +
                    "Информационные страницы, " +
                    "Открытые данные, " +
                    "Мероприятия, " +
                    "Ресурсы, использующие вакансии портала, " +
                    "API, " +
                    "Наборы данных, " +
                    "Виджеты, " +
                    "Социальная сеть SkillsNet, " +
                    "О мобильном приложении, " +
                    "Скачать на iPhone, " +
                    "Скачать на Android, " +
                    "Новое на портале, " +
                    "Новости, " +
                    "Статьи, " +
                    "2021 год, " +
                    "2022 год, " +
                    "2023 год, " +
                    "Список образовательных программ]";
}
