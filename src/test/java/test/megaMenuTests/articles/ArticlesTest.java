package test.megaMenuTests.articles;

import base.BrowserConfig;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static core.classObjects.ClassObjects.*;

public class ArticlesTest extends BrowserConfig {

    @Epic(value = "Тесты Мега-меню")
    @Test
    @Description(value = "Тест страницы мега-меню")
    public void articlesData() {
        openLink.openUrl(testValues.url);
        click.clickButton("Согласен");
        click.clickButton("Все сервисы");
        switchWindow.switchToActiveWindow();
        openLink.openLink("Статьи");
        infoBlockHealth.errorInfoBlock();
        articlesPage.checkPageTitle();
    }
}
