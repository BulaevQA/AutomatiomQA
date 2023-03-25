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
    protected final String
            url = System.getProperty("base_url", "https://hotfix.rtportal.show.pbs.bftcom.com/"),
            login = System.getProperty("login", "abilimpiks@pbs.bftcom.com"),
            password = System.getProperty("password", "Ex3t8yh96mj!"),
    /**
     === Переменнты для АДМ ===
     */
            urlAdm = System.getProperty("base_urlAdm", "https://hotfix-rtadm.show.pbs.bftcom.com/"),
            loginAdm = System.getProperty("loginAdm", "admin@trudvsem.ru"),
            passwordAdm = System.getProperty("passwordAdm", "Qwerty123");

@BeforeAll
    public static void beforeTestConfiguration() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.browser = System.getProperty("browser", "chrome");
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide());
    }
    @AfterEach
    public void afterTestConfiguration() {
        WebDriverRunner.closeWebDriver();
    }
}

