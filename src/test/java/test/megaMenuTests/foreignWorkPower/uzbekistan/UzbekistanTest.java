package test.megaMenuTests.foreignWorkPower.uzbekistan;

import base.BrowserConfig;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static core.classObjects.ClassObjects.*;

public class UzbekistanTest extends BrowserConfig {

    @Epic(value = "Тесты Мега-меню")
    @Test
    @Description(value = "Тест страницы мега-меню")
    @Tag("MegaMenu")
    @DisplayName("MegaMenuTest")
    public void articlesData() {
        openLink.openUrl(testValues.url);
        click.clickButton("Согласен");
        click.clickButton("Все сервисы");
        switchWindow.switchToActiveWindow();
        openLink.openLink("Найм граждан Узбекистана");
        infoBlockHealth.errorInfoBlock();
        uzbekistanPage.checkPageTitle();
    }
}
