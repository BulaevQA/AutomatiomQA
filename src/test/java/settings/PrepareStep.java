package settings;

import org.junit.jupiter.api.BeforeAll;
import owner.OwnerData;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import static com.codeborne.selenide.Selenide.open;

public class PrepareStep extends OwnerData {
    static String siteUrl = System.getProperty("baseUrl", "https://www.google.com/");
@BeforeAll
    public static void openBrowser() {
        Configuration.holdBrowserOpen = true;
        Configuration.browser = System.getProperty("browser", "edge");
        Configuration.browserSize = System.getProperty("size", "1920x1080");
        Configuration.baseUrl = siteUrl;
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide());
        open(siteUrl);
    }
}
