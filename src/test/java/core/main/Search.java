package core.main;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

public class Search {

    private final SelenideElement search = $x("//button[contains(@class, 'd-none')]/preceding-sibling::input");

    @Step(value = "Поиск значения {value} в поисковой выдаче")
    public Search searchField(String value) {
        search.should(Condition.enabled).setValue(value).sendKeys(Keys.ENTER);
        return this;
    }
}
