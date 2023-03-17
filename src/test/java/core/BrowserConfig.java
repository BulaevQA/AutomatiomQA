package core;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

abstract public class BrowserConfig {
@BeforeAll
    public static void beforeTestConfiguration() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "3840x2160";
        Configuration.browser = System.getProperty("browser", "chrome");
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide());
    }
    @AfterAll
    public static void afterTestConfiguration() {
    WebDriverRunner.closeWebDriver();
    }
}

