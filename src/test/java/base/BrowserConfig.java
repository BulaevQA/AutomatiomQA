package base;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

abstract public class BrowserConfig {

    @BeforeAll
    protected static void beforeTestConfiguration() {
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

