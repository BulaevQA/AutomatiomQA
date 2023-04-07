package pages.trudvsemPages.megaMenu.calendar;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class CalendarPage {

    private final SelenideElement
            pageTitle = $x("//h1[@class][text()[normalize-space()='Производственный календарь на 2023 год']]");

    /**
     === Провека заголовка страницы ===
     */
    @Step(value = "Проверка заголовка страницы")
    public boolean pageTitle() {
        return pageTitle.should(visible).exists();
    }
}
