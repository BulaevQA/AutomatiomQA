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
            url = System.getProperty("base_url", "https://hotfix.rtportal.show.pbs.bftcom.com/"),
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
            //Соискатель
            minProgressBar = "47",
            //Работодатель
            companyName = "ИП Булаев Д. С.",
            salaryManager = "«з/п по договоренности»",
            jobFields = "Тестовое значение";
}
