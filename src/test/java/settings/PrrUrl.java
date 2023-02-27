package settings;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;

public class PrrUrl {
    static String SITE_URL = ("https://hotfix.rtportal.show.pbs.bftcom.com/");

    @BeforeAll
    public static void openBrowser() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = SITE_URL;
        Configuration.browserSize = "3840x2160";
        Configuration.browserVersion = "chrome";
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide());
        open(SITE_URL);
    }
}
