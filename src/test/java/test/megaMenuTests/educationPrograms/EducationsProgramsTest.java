package test.megaMenuTests.educationPrograms;

import base.BrowserConfig;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static core.classObjects.ClassObjects.*;

public class EducationsProgramsTest extends BrowserConfig {

    @Test
    @Tag("MegaMenu")
    @Epic(value = "Тесты Мега-меню")
    @Description(value = "Тест страницы мега-меню")
    @DisplayName("MegaMenuTest")
    public void educationPrograms() {
        openLink.openUrl(testValues.url);
        click.clickButton("Согласен");
        click.clickButton("Все сервисы");
        switchWindow.switchToActiveWindow();
        openLink.openLink("Список образовательных программ");
        infoBlockHealth.errorInfoBlock();
        switchWindow.switchToActiveWindow();
        dropDown.selectDropDown("Социальная категория", "Безработные граждане, " +
                "зарегистрированные в органах службы занятости", "5");
        click.clickButton("Применить");
        educationProgramsPage.pageTitle();
    }
}
