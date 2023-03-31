package test.megaMenuTests.guideInformation.helpAndSupport;

import base.BrowserConfig;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static core.classObjects.ClassObjects.*;

public class HelpAndSupportTest extends BrowserConfig {

    @Epic(value = "Тесты Мега-меню")
    @Test
    @Description(value = "Тест страницы мега-меню")
    @Tag("MegaMenu")
    @DisplayName("MegaMenuTest")
    public void helpAndSupport() {
        openLink.openUrl(testValues.url);
        click.clickButton("Согласен");
        click.clickButton("Все сервисы");
        switchWindow.switchToActiveWindow();
        openLink.openLink("Помощь и поддержка");
        infoBlockHealth.errorInfoBlock();
        helpAndSupportPage.checkPageTitle();
    }
}
