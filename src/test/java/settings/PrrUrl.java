package settings;

import owner.OwnerData;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import static com.codeborne.selenide.Selenide.open;

public class PrrUrl extends OwnerData {

    public void openBrowser() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.browserVersion = "chrome";
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide());
        open(mainUrl);
    }
}
