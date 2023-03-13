package training;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;

abstract public class TrainingConfig {
@BeforeAll
    public static void browserConfig() {
        Configuration.holdBrowserOpen = true;
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserSize = System.getProperty("size", "1920x1080");
        Configuration.timeout = 50000;
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide());
    }
}

