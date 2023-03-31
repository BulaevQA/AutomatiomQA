package pages.trudvsemPages.megaMenu.openData.apiPage;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class ApiPage {

    private final SelenideElement pageTitle = $x("//h1[@class][text()[normalize-space()='API «Работа России»']]");

    /**
     === Получение заголовка страницы ===
     */
    public String getTitlePage() {
        return pageTitle.should(exist, visible).getText().trim();
    }
}
