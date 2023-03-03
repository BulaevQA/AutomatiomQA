package conf;

import org.junit.jupiter.api.BeforeAll;
import owner.OwnerData;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

import static com.codeborne.selenide.Selenide.open;

public class PrepareStep extends OwnerData {
    public static String siteUrl = System.getProperty("base_url", "http://localhost:8080/");
@BeforeAll
    public static void browserConfig() {
        Configuration.holdBrowserOpen = true;
        Configuration.browser = System.getProperty("browser", "firefox");
        Configuration.browserSize = System.getProperty("size", "1920x1080");
        Configuration.baseUrl = siteUrl;
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide());
        open(siteUrl);
    }
}
