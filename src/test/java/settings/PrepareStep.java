package settings;

import org.junit.jupiter.api.BeforeAll;
import owner.OwnerData;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import static com.codeborne.selenide.Selenide.open;

public class PrepareStep extends OwnerData {
@BeforeAll
    public static void openBrowser() {
        Configuration.holdBrowserOpen = true;
        Configuration.browser = System.setProperty("browser", "edge");
        Configuration.browserSize = System.setProperty("size", "1920x1080");
        Configuration.baseUrl = System.setProperty("baseUrl", "https://www.google.com/");
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide());
        open(baseUrl());
    }
}
