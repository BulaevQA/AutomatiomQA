package settings;

import org.junit.jupiter.api.BeforeAll;
import owner.OwnerData;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import static com.codeborne.selenide.Selenide.open;

public class PrrUrl extends OwnerData {
@BeforeAll
    public static void openBrowser() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
//        Configuration.browserVersion = System.getProperty("browser","edge");
//        Configuration.baseUrl = System.getProperty("url","https://www.google.com/");
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide());
        open(mainUrl);
    }
}
