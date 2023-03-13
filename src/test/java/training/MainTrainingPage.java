package training;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$x;

public class MainTrainingPage {

    private final SelenideElement SEARCH_FIELD = $x("//input[@id='a11y-search-input']");
    private final SelenideElement FIRST_TEXT = $x("//h3[@class]//a[contains(text(), 'в любом регионе')]");
    private final SelenideElement SECOND_TEXT = $x("//h3[@class]//a[contains(text(), 'по месту')]");

    public MainTrainingPage openWebPage(String url) {
        Selenide.open(url);
        return this;
    }

    public SearchPage inputSearchValue(String value) {
        SEARCH_FIELD.setValue(value).sendKeys(Keys.ENTER);
        return new SearchPage();
    }

    public String firstValue() {
        return FIRST_TEXT.getText();
    }

    public String secondValue() {
        return SECOND_TEXT.getText();
    }
}
