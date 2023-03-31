package test.megaMenuTests.openData.dataSets;

import base.BrowserConfig;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static core.classObjects.ClassObjects.*;

public class DataSetsTest extends BrowserConfig {

    @Epic(value = "Тесты Мега-меню")
    @Test
    @Description(value = "Тест страницы мега-меню")
    @Tag("MegaMenu")
    @DisplayName("MegaMenuTest")
    public void dataSets() {
        openLink.openUrl(testValues.url);
        click.clickButton("Согласен");
        click.clickButton("Все сервисы");
        switchWindow.switchToActiveWindow();
        openLink.openLink("Наборы данных");
        infoBlockHealth.errorInfoBlock();
        dataSetsPage.checkPageTitle();
    }
}
