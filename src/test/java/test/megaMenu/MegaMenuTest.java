package test.megaMenu;

import base.BrowserConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static helpers.ClassObjects.*;

public class MegaMenuTest extends BrowserConfig {

    @Test
    @Tag("Mega-menu")
    @DisplayName("Mega-menu test")
    public void megaMenuTest() {
        openLink.openUrl(url);
        click.clickButton("Все сервисы");
        switchWindow.switchToActiveWindow();
        openLink.openLink("Работа с переездом по России");
        switchWindow.switchToDefaultWindow();
        Assertions.assertEquals(expectedHashMaps.expectedMegaMenu(), actualHashMaps.actualMegaMenu());
    }
}
