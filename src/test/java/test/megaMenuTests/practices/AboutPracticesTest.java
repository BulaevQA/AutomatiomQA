package test.megaMenuTests.practices;

import base.BrowserConfig;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static core.classObjects.ClassObjects.*;

public class AboutPracticesTest extends BrowserConfig {

    @Test
    @Tag("MegaMenu")
    @Epic(value = "Тесты Мега-меню")
    @Description(value = "Тест страницы мега-меню")
    @DisplayName("MegaMenuTest")
    public void aboutPractices() {
        open.openUrl(testValues.url);
        click.clickButton("Согласен");
        click.clickButton("Все сервисы");
        switchWindow.switchToActiveWindow();
        open.openLink("О стажировках и практиках");
        infoBlockHealth.errorInfoBlock();
        aboutPracticesPage.pageTitle();
    }
}
