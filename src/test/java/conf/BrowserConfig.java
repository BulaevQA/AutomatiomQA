package conf;

import org.junit.jupiter.api.BeforeAll;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

public class BrowserConfig {
@BeforeAll
    public static void browserConfig() {
        Configuration.holdBrowserOpen = true;
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserSize = System.getProperty("size", "1920x1080");
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide());
    }
}
