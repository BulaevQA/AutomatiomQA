package base;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

abstract public class BrowserConfig {

    /**
     === Переменные для ПРР ===
     */
    protected final String url = System.getProperty("base_url", "https://hotfix.rtportal.show.pbs.bftcom.com/");
    protected final String login = System.getProperty("login", "abilimpiks@pbs.bftcom.com");
    protected final String password = System.getProperty("password", "Ex3t8yh96mj!");

    /**
     === Переменнты для АДМ ===
     */
    protected final String urlAdm = System.getProperty("base_urlAdm", "https://rtadm.show.pbs.bftcom.com/");
    protected final String loginAdm = System.getProperty("loginAdm", "admin@trudvsem.ru");
    protected final String passwordAdm = System.getProperty("passwordAdm", "Qwerty123");

@BeforeAll
    public static void beforeTestConfiguration() {
        Configuration.browser = System.getProperty("browser", "chrome");
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide());
    }
    @AfterEach
    public void afterTestConfiguration() {
        WebDriverRunner.closeWebDriver();
    }
}

