package core.main;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

public class Search {

    private final SelenideElement search = $x("//button[contains(@class, 'd-none')]/preceding-sibling::input");

    /**
     === Поисковая строка ===
     * @param value - Искомое значение
     */
    @Step(value = "Поиск значения {value} в поисковой выдаче")
    public Search searchField(String value) {
        search.should(exist, enabled).clear();
        search.should(editable).setValue(value);
        return this;
    }
}
