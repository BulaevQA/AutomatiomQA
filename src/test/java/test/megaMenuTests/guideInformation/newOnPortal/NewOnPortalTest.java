package test.megaMenuTests.guideInformation.newOnPortal;

import base.BrowserConfig;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static core.classObjects.ClassObjects.*;

public class NewOnPortalTest extends BrowserConfig {

    @Test
    @Tag("MegaMenu")
    @Epic(value = "Тесты Мега-меню")
    @Description(value = "Тест страницы мега-меню")
    @DisplayName("MegaMenuTest")
    public void newOnPortal() {
        openLink.openUrl(testValues.url);
        click.clickButton("Согласен");
        click.clickButton("Все сервисы");
        switchWindow.switchToActiveWindow();
        openLink.openLink("Новое на портале");
        infoBlockHealth.errorInfoBlock();
        newOnPortalPage.pageTitle();
    }
}
