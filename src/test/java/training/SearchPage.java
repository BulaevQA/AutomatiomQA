package training;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SearchPage {

    private final SelenideElement SEARCH_FIELD = $x("//input[@id='searchInput']");
    private final SelenideElement TITLE_NAME_PATH = $x("//div[@class='product-card__wrapper']//span[@class='goods-name']//span");

    public SearchPage setTitleName() {
        String TITLE_NAME = TITLE_NAME_PATH.getText();
        return this;
    }

}
