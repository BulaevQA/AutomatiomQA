package test.megaMenuTests.megaMenuLinks;

import base.BrowserConfig;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import net.bytebuddy.build.Plugin;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

import java.util.Arrays;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static core.classObjects.ClassObjects.*;

public class MegaMenuLinksTest extends BrowserConfig {

    @Test
    @Tag("MegaMenu")
    @Epic(value = "Тесты Мега-меню")
    @Description(value = "Тест страницы мега-меню")
    @DisplayName("MegaMenuTest")
    public void megaMenuLinksTest() {
        open.openUrl(testValues.url);
        click.clickButton("Все сервисы");
        mainPage.checkMegaMenu();
    }
}